package ifrs.edu.View;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ifrs.edu.Control.CloginUser;
import ifrs.edu.Entity.User;

@Path("/")
public class Login {
  
    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    public static Response loginUser(User user){
        return CloginUser.loginUser(user);
    }
}
