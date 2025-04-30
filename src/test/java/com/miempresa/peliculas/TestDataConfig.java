package com.miempresa.peliculas;

import com.miempresa.peliculas.model.Director;
import com.miempresa.peliculas.repository.DirectorRepository;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class TestDataConfig {

    @Bean
    public Director directorId(DirectorRepository directorRepository) {
        Director director = new Director();
        director.setNombre("Peter Jackson");
        director.setNacionalidad(Director.Nacionalidad.ARGENTINA);
        return directorRepository.save(director);

    }
}

