package co.com.sofka.scrappingMovies.infra.handle;

import co.com.sofka.scrappingMovies.domain.movies.command.CreateMovies;
import co.com.sofka.scrappingMovies.infra.generic.UseCaseHandle;
import co.com.sofka.scrappingMovies.usecase.CreateMoviesUseCase;
import io.quarkus.vertx.ConsumeEvent;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CreateMoviesHandle extends UseCaseHandle {

    private final CreateMoviesUseCase useCase;

    public CreateMoviesHandle(CreateMoviesUseCase useCase) {
        this.useCase = useCase;
    }

    @ConsumeEvent(value = "sofka.scrapping.movies.create")
    void consumeBlocking(CreateMovies command) {
        var events = useCase.apply(command);
        process(command.getMoviesId(), events);
    }
}
