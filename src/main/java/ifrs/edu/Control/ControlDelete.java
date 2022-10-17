package ifrs.edu.Control;

import javax.ws.rs.core.Response;

import ifrs.edu.Entity.Trick;
import ifrs.edu.Entity.User;

public class ControlDelete {

    public static Response controlDeleteUser(Long id){
        User user = findUserById(id);
        if(user == null) return Response.status(404).build();

        user.delete();
        return Response.ok().build();
    }

    public static User findUserById(Long id){
        return User.findById(id);
    }

    public static Response controlDeleteTrick(Long id) {
        Trick trick = findTrickById(id);
        if(trick == null) return Response.status(404).build();

        trick.delete();
        return Response.ok().build();
    }

    public static Trick findTrickById(Long id){
        return Trick.findById(id);
    }
    
}
