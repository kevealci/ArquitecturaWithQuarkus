package co.com.sofka.scrappingMovies.domain.movies;

import java.util.Objects;

public final class Movie {

    private final String id;
    private String titulo;
    private String year;
    private String genero;
    private String sinopsis;
    private String urlMovie;


    public Movie(String id, String titulo, String year, String genero, String sinopsis, String urlMovie) {
        this.id = Objects.requireNonNull(id);
        this.titulo = titulo;
        this.year = year;
        this.genero = genero;
        this.sinopsis = sinopsis;
        this.urlMovie = urlMovie;
    }

    public String id() {
        return id;
    }

    public String titulo() {
        return titulo;
    }

    public String year() {
        return year;
    }

    public String genero() {
        return genero;
    }

    public String sinopsis() {
        return sinopsis;
    }

    public String urlMovie() {
        return urlMovie;
    }

    public void updateTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void updateYear(String year) {
        this.year = year;
    }

    public void updateGenero(String genero) {
        this.genero = genero;
    }

    public void updateSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public void updateUrlMovie(String urlMovie) {
        this.urlMovie = urlMovie;
    }
}
