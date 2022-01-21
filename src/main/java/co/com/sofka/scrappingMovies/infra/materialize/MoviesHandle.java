package co.com.sofka.scrappingMovies.infra.materialize;

import co.com.sofka.scrappingMovies.domain.movies.event.MovieAdded;
import co.com.sofka.scrappingMovies.domain.movies.event.MoviesCreated;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoClient;
import com.mongodb.client.model.Filters;
import io.quarkus.vertx.ConsumeEvent;
import org.bson.Document;

import javax.enterprise.context.ApplicationScoped;
import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
public class MoviesHandle {

    private final MongoClient mongoClient;

    public MoviesHandle(MongoClient mongoClient) {
        this.mongoClient = mongoClient;
    }


    @ConsumeEvent(value = "sofka.scrapping.movies.moviescreated", blocking = true)
    void consumeProgramCreated(MoviesCreated event) {
        Map<String, Object> document = new HashMap<>();
        document.put("_id", event.getAggregateId());
        document.put("name", event.getName());

        mongoClient.getDatabase("queries")
                .getCollection("movies")
                .insertOne(new Document(document));
    }

    @ConsumeEvent(value = "sofka.scrapping.movies.movieadded", blocking = true)
    void consumeProgramCreated(MovieAdded event) {
        BasicDBObject document = new BasicDBObject();

        document.put("movie."+event.getMovieId()+".titulo", event.getTitulo());
        document.put("movie."+event.getMovieId()+".year", event.getYear());
        document.put("movie."+event.getMovieId()+".genero", event.getGenero());
        document.put("movie."+event.getMovieId()+".sinopsis", event.getSinopsis());
        document.put("movie."+event.getMovieId()+".urlMovie", event.getUrlMovie());


        BasicDBObject updateObject = new BasicDBObject();
        updateObject.put("$set", document);

        mongoClient.getDatabase("queries")
                .getCollection("movies")
                .updateOne( Filters.eq("_id", event.getAggregateId()), updateObject);
    }
}
