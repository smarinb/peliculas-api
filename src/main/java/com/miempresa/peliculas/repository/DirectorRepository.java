package com.miempresa.peliculas.repository;

import com.miempresa.peliculas.model.Director;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectorRepository extends JpaRepository<Director,Long> {
}
