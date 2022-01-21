package co.com.sofka.scrappingMovies.domain.movies.event;

import co.com.sofka.scrappingMovies.domain.generic.DomainEvent;

public class MovieAdded extends DomainEvent {
    private final String movieId;
    private final String titulo;
    private final String year;
    private final String genero;
    private final String sinopsis;
    private final String urlMovie;

    public MovieAdded(String movieId, String titulo, String year, String genero, String sinopsis, String urlMovie) {
        super("sofka.scrapping.movies.movieadded");
        this.movieId = movieId;
        this.titulo = titulo;
        this.year = year;
        this.genero = genero;
        this.sinopsis = sinopsis;
        this.urlMovie = urlMovie;
    }

    public String getMovieId() {
        return movieId;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getYear() {
        return year;
    }

    public String getGenero() {
        return genero;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public String getUrlMovie() {
        return urlMovie;
    }
}
