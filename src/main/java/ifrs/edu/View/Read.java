package ifrs.edu.View;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import ifrs.edu.Entity.Trick;
import ifrs.edu.Entity.User;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Path("/")
public class Read {
    
    @GET
    @Path("trick")
    public List<PanacheEntityBase> seeAllTricks() {
        return Trick.listAll();
    }

    @GET
    @Path("user")
    @RolesAllowed({"Admin"})
    public List<PanacheEntityBase> seeAllUsers() {
        return User.listAll();
    }

}
