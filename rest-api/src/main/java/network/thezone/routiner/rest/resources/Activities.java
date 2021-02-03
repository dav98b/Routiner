package network.thezone.routiner.rest.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("activities")
public class Activities {

    public Activities() {
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getActivities() {
        return "test";
    }
}
