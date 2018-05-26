package solutions.cg.devtask.resources;

import solutions.cg.devtask.core.Player;
import solutions.cg.devtask.db.PlayerStorage;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Path("/player")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PlayerResource {
    private final AtomicLong idCounter;
    private final PlayerStorage playersDb;

    public PlayerResource(PlayerStorage playersDb) {
        this.idCounter = new AtomicLong();
        this.playersDb = playersDb;
    }

    @POST
    public Response addNewPlayer(@NotNull @Valid Player p) {
        p.setId(idCounter.incrementAndGet());
        playersDb.addPlayer(p);
        return Response.ok().build();
    }

    @GET
    public Collection<Player> getAllPlayers(@QueryParam("sort") Optional<String> sortBy) {
        if (sortBy.isPresent()) {
            switch (sortBy.get()) {
                case "name":
                    return playersDb.getPlayerListByName();
                case "id":
                    return playersDb.getPlayerListById();
                default:
                    throw new WebApplicationException("sort type is not supported", Response.Status.NOT_FOUND);
            }
        }

        return playersDb.getPlayerListById();
    }
}
