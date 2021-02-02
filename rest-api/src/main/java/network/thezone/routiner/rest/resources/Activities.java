package network.thezone.routiner.rest.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("activities")
public class Activities {

    public Activities() {
    }

    @GET
    @Produces("text/json")
    public String getActivities() {
        return "test";
    }
}
