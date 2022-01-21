package co.com.sofka.scrappingMovies.domain.movies;

import co.com.sofka.scrappingMovies.domain.generic.EventChange;
import co.com.sofka.scrappingMovies.domain.movies.event.MovieAdded;
import co.com.sofka.scrappingMovies.domain.movies.event.MoviesCreated;

import java.util.HashMap;

public class MoviesEventChange implements EventChange {

    protected MoviesEventChange(Movies movies) {

        listener( (MoviesCreated event) -> {
            movies.name = event.getName();
            movies.movies = new HashMap<>();
        });

        listener( (MovieAdded event) -> {
            movies.movies.put(event.getMovieId(),
                    new Movie(event.getMovieId(),
                            event.getTitulo(),
                            event.getYear(),
                            event.getGenero(),
                            event.getSinopsis(),
                            event.getUrlMovie()));
        });

    }
}
