package com.miempresa.peliculas.repository;

import com.miempresa.peliculas.model.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PeliculaRepository  extends JpaRepository<Pelicula,Long> {

    //Ver películas por director

    List <Pelicula> findByDirector_Id(Long id);
}
