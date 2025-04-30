package com.miempresa.peliculas.controller;

import com.miempresa.peliculas.model.Pelicula;
import com.miempresa.peliculas.service.PeliculaService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/peliculas")
public class PeliculaController {

    @Autowired
    private PeliculaService servicio;

    //listar peliculas
    @GetMapping
    public ResponseEntity<?> listarPeliculas() {
        List<Pelicula> peliculas = servicio.listarPeliculas();
        return ResponseEntity.ok(peliculas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerPeliculaById(@PathVariable Long id) {
        var pelicula = servicio.buscarPelicula(id);
        return pelicula.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/director/{id}")
    public ResponseEntity<List<Pelicula>> listarPeliculasByDirector(@PathVariable Long id) {
        List<Pelicula> peliculas = servicio.buscarPeliculasPorDirector(id);
        return ResponseEntity.ok(peliculas);
    }

    @PostMapping
    public ResponseEntity<?> agregarPelicula(@Valid @RequestBody Pelicula pelicula){
        Pelicula p = servicio.anadirPelicula(pelicula);
        return ResponseEntity.status(201).body(p);
    }


}
