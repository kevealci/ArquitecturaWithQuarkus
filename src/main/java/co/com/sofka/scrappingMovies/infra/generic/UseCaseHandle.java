package co.com.sofka.scrappingMovies.infra.generic;

import co.com.sofka.scrappingMovies.domain.generic.DomainEvent;
import co.com.sofka.scrappingMovies.domain.generic.EventStoreRepository;
import co.com.sofka.scrappingMovies.infra.generic.EventSerializer;
import co.com.sofka.scrappingMovies.infra.generic.StoredEvent;
import co.com.sofka.scrappingMovies.infra.message.BusService;

import javax.inject.Inject;
import java.util.Date;
import java.util.List;

public abstract class UseCaseHandle {
    @Inject
    private EventStoreRepository repository;

    @Inject
    private BusService busService;;

    public void process(String moviesId, List<DomainEvent> events) {
        events.stream().map(event -> {
            String eventBody = EventSerializer.instance().serialize(event);
            return new StoredEvent(event.getClass().getTypeName(), new Date(), eventBody);
        }).forEach(storedEvent -> repository.saveEvent("movies", moviesId, storedEvent));

        events.forEach(busService::send);
    }
}