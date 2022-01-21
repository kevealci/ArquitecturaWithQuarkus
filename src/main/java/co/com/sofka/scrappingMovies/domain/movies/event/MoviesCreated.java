package co.com.sofka.scrappingMovies.domain.movies.event;

import co.com.sofka.scrappingMovies.domain.generic.DomainEvent;

public class MoviesCreated extends DomainEvent {
    private final String moviesId;
    private final String name;

    public MoviesCreated(String moviesId, String name) {
        super("sofka.scrapping.movies.moviescreated");
        this.moviesId = moviesId;
        this.name = name;
    }

    public String getMoviesId() {
        return moviesId;
    }

    public String getName() {
        return name;
    }
}
