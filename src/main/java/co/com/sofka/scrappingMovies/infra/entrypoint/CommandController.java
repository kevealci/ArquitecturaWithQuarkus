package co.com.sofka.scrappingMovies.infra.entrypoint;

import co.com.sofka.scrappingMovies.domain.movies.command.AddMovie;
import co.com.sofka.scrappingMovies.domain.movies.command.CreateMovies;
import io.vertx.mutiny.core.eventbus.EventBus;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/api/movies")
public class CommandController {

    private final EventBus bus;

    public CommandController(EventBus bus){
        this.bus = bus;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/create")
    public Response executor(CreateMovies command) {
        bus.publish(command.getType(), command);
        return Response.ok().build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/addMovie")
    public Response executor(AddMovie command) {
        bus.publish(command.getType(), command);
        return Response.ok().build();
    }
}
