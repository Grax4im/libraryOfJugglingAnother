package ifrs.edu.View;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

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
    @Path("trick/{id}")
    public Trick seeTrickById(@PathParam("id") Long id){
        return Trick.findById(id);
    }

    @GET
    @Path("trick/difficult/{difficult}")
    public List<PanacheEntityBase> seeTrickByDifficult(@PathParam("difficult") Integer difficult){
        return Trick.list("difficult", difficult);
    }

    @GET
    @Path("trick/balls/{balls}")
    public List<PanacheEntityBase> seeTrickByBalls(@PathParam("balls") Integer balls){
        return Trick.list("numberOfBalls", balls);
    }

    @GET
    @Path("user")
    @RolesAllowed({"Admin"})
    public List<PanacheEntityBase> seeAllUsers() {
        return User.listAll();
    }

}
