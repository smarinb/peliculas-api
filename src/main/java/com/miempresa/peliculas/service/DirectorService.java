package com.miempresa.peliculas.service;

import com.miempresa.peliculas.model.Director;
import com.miempresa.peliculas.repository.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectorService {

    @Autowired
    private DirectorRepository repository;

    //Listar todos los directores

    public List<Director> listarDirectores() {
        return repository.findAll();
    }

    //Añadir un nuevo director

    public Director anadirDirector(Director director){
        return repository.save(director);
    }

}
