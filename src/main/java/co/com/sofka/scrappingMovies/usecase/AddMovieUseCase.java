package co.com.sofka.scrappingMovies.usecase;

import co.com.sofka.scrappingMovies.domain.generic.DomainEvent;
import co.com.sofka.scrappingMovies.domain.generic.EventStoreRepository;
import co.com.sofka.scrappingMovies.domain.movies.Movies;
import co.com.sofka.scrappingMovies.domain.movies.command.AddMovie;

import javax.enterprise.context.Dependent;
import java.util.List;
import java.util.function.Function;

@Dependent
public class AddMovieUseCase implements Function<AddMovie, List<DomainEvent>> {

    private final EventStoreRepository repository;

    public AddMovieUseCase(EventStoreRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<DomainEvent> apply(AddMovie addMovieCommand) {
        var events = repository.getEventsBy("movies", addMovieCommand.getMoviesId());
        var movies = Movies.from(addMovieCommand.getMoviesId(), events);
        movies.addMovie(addMovieCommand.getMovieId(),
                addMovieCommand.getTitulo(),
                addMovieCommand.getYear(),
                addMovieCommand.getGenero(),
                addMovieCommand.getSinopsis(),
                addMovieCommand.getUrlMovie());
        return movies.getUncommittedChanges();
    }
}
