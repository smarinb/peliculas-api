package com.miempresa.peliculas.model;



import jakarta.persistence.*;
import jakarta.validation.constraints.*;


@Entity
public class Pelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    

    //Relacion muchas peliculas a un director
    @NotNull(message = "El director no puede ser nulo")
    @ManyToOne
    @JoinColumn(name = "director_id")
    private Director director;


    @NotBlank(message = "El título de la película no puede ser vacío")
    private String titulo;

    @Min(value=1900, message = "El año mínimo es 1900")
    @Max(value=2025, message = "El año máximo es el actual")
    private int anio;


    @Min(value = 15, message = "Como minimo la duración puede ser 15 minutos")
    @Max(value=180, message = "Como mucho la película puede durar 3 horas")
    private int duracion;

    public enum Genero{
        ACCION,
        COMEDIA,
        DRAMA,
        TERROR,
        CIENCIA_FICCION,
        AVENTURA,
        ANIMACION,
        DOCUMENTAL,
        ROMANCE,
        FANTASIA,
        MISTERIO,
        SUSPENSE
    }

    @NotNull(message = "El género no puede ser nulo")
    @Enumerated(EnumType.STRING)
    private Genero genero;

    public Pelicula(Long id, Director director, String titulo, int anio, int duracion) {
        this.id = id;
        this.director = director;
        this.titulo = titulo;
        this.anio = anio;
        this.duracion = duracion;
    }

    public Pelicula() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }
}
