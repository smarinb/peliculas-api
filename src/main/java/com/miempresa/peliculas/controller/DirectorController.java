package com.miempresa.peliculas.controller;

import com.miempresa.peliculas.model.Director;
import com.miempresa.peliculas.service.DirectorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/directores")
public class DirectorController {

    @Autowired
    private DirectorService service;

    //listar los directores
    @GetMapping
    public ResponseEntity<?> listarDirectores(){
        List<Director> directores = service.listarDirectores();
        return ResponseEntity.ok(directores);
    }

    //Añadir un director
    @PostMapping
    public ResponseEntity<?> agregarDirector(@Valid @RequestBody Director director){
        Director d = service.anadirDirector(director);
        return ResponseEntity.status(201).body(d);
    }









}
