package ifrs.edu.View;

import javax.annotation.security.RolesAllowed;
import javax.transaction.Transactional;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ifrs.edu.Control.ControlDelete;

@Transactional
@Path("/")
public class Delete {


    @DELETE
    @Path("/user/{id}")
    @RolesAllowed({"Admin"})
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteUser(@PathParam("id") Long id) {
        return ControlDelete.controlDeleteUser(id);
    }

    @DELETE
    @Path("/trick/{id}")
    @RolesAllowed({"Creator", "Admin"})
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteTrick(@PathParam("id") Long id) {
        return ControlDelete.controlDeleteTrick(id);
    }
    
}
