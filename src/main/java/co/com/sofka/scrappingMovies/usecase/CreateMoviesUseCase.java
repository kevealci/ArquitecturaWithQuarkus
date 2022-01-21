package co.com.sofka.scrappingMovies.usecase;

import co.com.sofka.scrappingMovies.domain.generic.DomainEvent;
import co.com.sofka.scrappingMovies.domain.movies.Movies;
import co.com.sofka.scrappingMovies.domain.movies.command.CreateMovies;

import javax.enterprise.context.Dependent;
import java.util.List;
import java.util.function.Function;

@Dependent
public class CreateMoviesUseCase implements Function<CreateMovies, List<DomainEvent>> {
    @Override
    public List<DomainEvent> apply(CreateMovies createMoviesCommand) {
        var movies = new Movies(createMoviesCommand.getMoviesId(), createMoviesCommand.getName());
        return movies.getUncommittedChanges();
    }
}
