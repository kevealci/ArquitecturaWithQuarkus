package co.com.sofka.scrappingMovies.domain.movies;

import co.com.sofka.scrappingMovies.domain.generic.AggregateRoot;
import co.com.sofka.scrappingMovies.domain.generic.DomainEvent;
import co.com.sofka.scrappingMovies.domain.movies.event.MovieAdded;
import co.com.sofka.scrappingMovies.domain.movies.event.MoviesCreated;

import java.util.List;
import java.util.Map;

public class Movies extends AggregateRoot {

    protected Map<String, Movie> movies;
    protected String name;

    public Movies(String id, String name) {
        super(id);
        subscribe(new MoviesEventChange(this));
        appendChange(new MoviesCreated(id, name)).apply();
    }

    private  Movies(String id) {
        super(id);
        subscribe(new MoviesEventChange(this));
    }

    public static Movies from(String movieId, List<DomainEvent> events) {
        var movies = new Movies(movieId);
        events.forEach(movies::applyEvent);
        return movies;
    }

    public void addMovie(String movieId, String titulo, String year, String genero, String sinopsis, String urlMovie) {
        appendChange(new MovieAdded(movieId,titulo,year,genero,sinopsis,urlMovie)).apply();
    }

    public Movie findMovieById(String id) {
        return this.movies.get(id);
    }
}
