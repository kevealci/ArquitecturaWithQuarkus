package co.com.sofka.scrappingMovies.domain.generic;

import co.com.sofka.scrappingMovies.infra.generic.StoredEvent;

import java.util.List;



public interface EventStoreRepository {


    List<DomainEvent> getEventsBy(String aggregateName, String aggregateRootId);


    void saveEvent(String aggregateName, String aggregateRootId, StoredEvent storedEvent);

}