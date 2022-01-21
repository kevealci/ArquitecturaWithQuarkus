package co.com.sofka.scrappingMovies.infra.entrypoint;

import com.mongodb.client.MongoClient;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/api/movies")
public class QueryController {
    private final MongoClient mongoClient;

    public QueryController(MongoClient mongoClient) {
        this.mongoClient = mongoClient;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response get(@PathParam("id") String moviesId) {
        List<Document> documentList = new ArrayList<>();
        mongoClient.getDatabase("queries")
                .getCollection("movies")
                .find(Filters.eq("_id", moviesId))
                .forEach(documentList::add);
        return Response.ok(documentList.stream().findAny()).build();
    }
}