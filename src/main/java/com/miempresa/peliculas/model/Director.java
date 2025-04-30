package com.miempresa.peliculas.model;


import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Director {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    //Relación uno a muchas películas
    @OneToMany(mappedBy = "director")
    @JsonBackReference
    private List<Pelicula> peliculas;

    public enum Nacionalidad {
        ESPANOLA,
        ESTADOUNIDENSE,
        FRANCESA,
        INGLESA,
        ALEMANA,
        ITALIANA,
        JAPONESA,
        MEXICANA,
        ARGENTINA,
        BRASILEÑA,
        CHINA,
        CANADIENSE,
        INDIA,
        AUSTRALIANA
    }

    @Enumerated(EnumType.STRING)
    private Nacionalidad nacionalidad;

    public Director(Long id, String nombre, List<Pelicula> peliculas, Nacionalidad nacionalidad) {
        this.id = id;
        this.nombre = nombre;
        this.peliculas = peliculas;
        this.nacionalidad = nacionalidad;
    }

    public Director() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Pelicula> getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(List<Pelicula> peliculas) {
        this.peliculas = peliculas;
    }

    public Nacionalidad getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(Nacionalidad nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
}
