package com.miempresa.peliculas.service;


import com.miempresa.peliculas.model.Pelicula;
import com.miempresa.peliculas.repository.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeliculaService {

    @Autowired
    private PeliculaRepository repository;

    //listar todas las películas
    public List<Pelicula> listarPeliculas(){
        return repository.findAll();
    }

    //buscar una película por un ID

    public Optional<Pelicula> buscarPelicula(Long id){
        return repository.findById(id);
    }

    //guardar nueva pelicula

    public Pelicula anadirPelicula(Pelicula pelicula){
        return repository.save(pelicula);
    }

    //optener peliculas de director
    public List<Pelicula> buscarPeliculasPorDirector(Long id){
        return repository.findByDirector_Id(id);
    }







}
