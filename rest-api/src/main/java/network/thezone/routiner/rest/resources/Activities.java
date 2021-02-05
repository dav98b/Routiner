package network.thezone.routiner.rest.resources;

import network.thezone.routiner.core.Activity;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.DateTimeException;
import java.time.LocalDate;

import static javax.ws.rs.core.Response.Status.BAD_REQUEST;

@Path("activities")
public class Activities {

    public Activities() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getActivities() {
        return null;
    }

    @GET
    /* day format can be enforced through a regex.
     * This simple regex matches just the date format YYYY-MM-DD but
     * doesn't guarantee the date to be valid, that's up to LocalDate.
     */
    @Path("{date: \\d{4}-\\d{2}-\\d{2}}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getActivitiesByDay(@PathParam("date") String plainDate) {
        LocalDate date;
        try {
            date = LocalDate.parse(plainDate);
        } catch (DateTimeException ex) {
            return Response.status(BAD_REQUEST).build();
        }
        //return all activities scheduled on date instead
        return Response.ok().build();
    }

}
