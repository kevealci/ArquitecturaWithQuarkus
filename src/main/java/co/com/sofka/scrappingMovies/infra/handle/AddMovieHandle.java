package co.com.sofka.scrappingMovies.infra.handle;

import co.com.sofka.scrappingMovies.domain.movies.command.AddMovie;
import co.com.sofka.scrappingMovies.infra.generic.UseCaseHandle;
import co.com.sofka.scrappingMovies.usecase.AddMovieUseCase;
import io.quarkus.vertx.ConsumeEvent;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AddMovieHandle extends UseCaseHandle {

    private final AddMovieUseCase useCase;

    public AddMovieHandle(AddMovieUseCase useCase) {
        this.useCase = useCase;
    }

    @ConsumeEvent(value = "sofka.scrapping.movies.addmovie")
    void consumeBlocking(AddMovie command) {
        var events = useCase.apply(command);
        process(command.getMoviesId(), events);
    }
}
