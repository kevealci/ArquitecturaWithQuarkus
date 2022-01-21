package co.com.sofka.scrappingMovies.domain.movies.command;

import co.com.sofka.scrappingMovies.domain.generic.Command;

public class AddMovie extends Command {
    private String moviesId;
    private String movieId;
    private String titulo;
    private String year;
    private String genero;
    private String sinopsis;
    private String urlMovie;


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

    public String getMoviesId() {
        return moviesId;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMoviesId(String moviesId) {
        this.moviesId = moviesId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public void setUrlMovie(String urlMovie) {
        this.urlMovie = urlMovie;
    }
}
