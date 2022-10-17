package ifrs.edu.Control;

import javax.ws.rs.core.Response;

import ifrs.edu.Entity.Trick;
import ifrs.edu.Entity.User;

public class ControlUpdate {
    
    public static Response updateUserControl(int userId, User user) {
        
        User newUser = searchUser(userId); 

        if(newUser != null || CcreateUser.validUser(user)) {
            newUser.setName(user.getName());
            newUser.setPassword(user.getPassword());
            newUser.setEmail(user.getEmail());
        }

        return Response.status(404).build();
    }

    public static User searchUser(int userId) {
        return User.findById(userId);
    }

    public static Response updateTrickControl(int trickId, Trick trick) {
        
        Trick newTrick = searchTrick(trickId); 

        if(newTrick != null || CcreateTrick.validTrick(trick)) {
           newTrick.setDescription(trick.getDescription());
           newTrick.setDifficult(trick.getDifficult());
           newTrick.setImage(trick.getImage());
           newTrick.setName(trick.getName());
           newTrick.setNumberOfBalls(trick.getNumberOfBalls());
           newTrick.setPreRequisites(trick.getPreRequisites());
           newTrick.setSiteswap(trick.getSiteswap());

           newTrick.persist();
           
           return Response.ok(newTrick).build();
        }

        return Response.status(404).build();
    }
    
    public static Trick searchTrick(int trickId) {
        return Trick.findById(trickId);
    }

}
