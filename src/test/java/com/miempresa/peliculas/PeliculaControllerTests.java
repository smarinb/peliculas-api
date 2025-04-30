package com.miempresa.peliculas;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import com.miempresa.peliculas.model.Director;
import com.miempresa.peliculas.model.Pelicula;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import static org.hamcrest.Matchers.containsString;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Import(TestDataConfig.class)
public class PeliculaControllerTests {

    @Autowired
    private MockMvc mockMvc;


    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private Director director; // <<< Añadimos aquí una variable de clase

    private String toJson(Object obj) throws Exception {
        return objectMapper.writeValueAsString(obj);
    }


    //Test listar todas las peliculas
    @Test
    void listarPeliculas_devuelve200() throws Exception {
        mockMvc.perform(get("/peliculas"))
                .andExpect(status().isOk());
    }

    //Añadir película código 201
    @Test
    void agregarPelicula_devuelve201ConJson() throws Exception {

        Director director = new Director();
        director.setId(director.getId()); // <-- Esto ya está bien

        Pelicula pelicula = new Pelicula();
        pelicula.setDirector(director); // <-- ¡AQUÍ SÍ asignas un director real!
        pelicula.setAnio(2000);
        pelicula.setTitulo("The Lord of the Rings");
        pelicula.setDuracion(180);
        pelicula.setGenero(Pelicula.Genero.CIENCIA_FICCION); // <-- Asegúrate también de poner el género si es @NotNull

        mockMvc.perform(post("/peliculas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(toJson(pelicula)))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(containsString("Lord")));
    }


    //Añadir una pelicula mal y forzar un 400
    @Test
    void agregarPeliculaSinTitulo_devuelve400() throws Exception{
        Director director = new Director();
        director.setId(director.getId()); // <-- Esto ya está bien

        Pelicula pelicula = new Pelicula();
        pelicula.setDirector(director); // <-- ¡AQUÍ SÍ asignas un director real!
        pelicula.setAnio(2000);
        pelicula.setDuracion(180);
        pelicula.setGenero(Pelicula.Genero.CIENCIA_FICCION); // <-- Asegúrate también de poner el género si es @NotNull


        mockMvc.perform(post("/peliculas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(toJson(pelicula)))
                .andExpect(status().isBadRequest());

    }


    //Buscar pelicula por id

    @Test
    void buscarPelicula_existente_devuelve200ConContenido() throws Exception{
        Director director = new Director();
        director.setId(director.getId()); // <-- Esto ya está bien

        Pelicula pelicula = new Pelicula();
        pelicula.setDirector(director); // <-- ¡AQUÍ SÍ asignas un director real!
        pelicula.setAnio(2000);
        pelicula.setTitulo("The Lord of the Rings");
        pelicula.setDuracion(180);
        pelicula.setGenero(Pelicula.Genero.CIENCIA_FICCION); // <-- Asegúrate también de poner el género si es @NotNull

        String response = mockMvc.perform(post("/peliculas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(toJson(pelicula)))
                .andExpect(status().isCreated())
                .andReturn()
                .getResponse()
                .getContentAsString();

        Number idNum = JsonPath.read(response, "$.id");
        long id = idNum.longValue();


        mockMvc.perform(get("/peliculas/" + id))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Lord")));
    }

    //Test buscar peliculas por id del director

    @Test
    void buscarPeliculas_existentesPorIdDirector_devuelve200ConContenido() throws Exception {
        Director director = new Director();
        director.setId(director.getId());

        Pelicula pelicula = new Pelicula();
        pelicula.setDirector(director);
        pelicula.setAnio(2000);
        pelicula.setTitulo("The Lord of the Rings");
        pelicula.setDuracion(180);
        pelicula.setGenero(Pelicula.Genero.CIENCIA_FICCION);

        // Crear película
        mockMvc.perform(post("/peliculas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(toJson(pelicula)))
                .andExpect(status().isCreated());

        // Buscar películas por id del director
        mockMvc.perform(get("/peliculas/director/" + director.getId()))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Lord")));
    }




}
