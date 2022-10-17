package ifrs.edu.View;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ifrs.edu.Control.ControlUpdate;
import ifrs.edu.Entity.Trick;
import ifrs.edu.Entity.User;

@Path("/")
public class Update {


    @PUT
    @Path("/trick/{id}")
    @RolesAllowed({"Creator"})
    public Response updateTrick(int id, Trick trick) {
        return ControlUpdate.updateTrickControl(id, trick);
    }

    @PUT
    @Path("/user/{id}")
    @RolesAllowed({"Admin"})
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateUser(@PathParam("id") int id,User user) {
        return ControlUpdate.updateUserControl(id, user);
    }
}
