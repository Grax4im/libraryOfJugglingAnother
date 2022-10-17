package ifrs.edu.View;

import javax.annotation.security.RolesAllowed;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ifrs.edu.Control.CcreateTrick;
import ifrs.edu.Control.CcreateUser;
import ifrs.edu.Entity.Trick;
import ifrs.edu.Entity.User;
@Transactional
@Path("/")
public class Create {

    @POST
    @Path("/user")
    @RolesAllowed({"Admin"})
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createCreator(User user) {
        return CcreateUser.createUser(user);
    }

    @POST
    @Path("/trick")
    @RolesAllowed({"Creator", "Admin"})
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createTrick(Trick trick) {
        return CcreateTrick.createTrick(trick);
    }
}
