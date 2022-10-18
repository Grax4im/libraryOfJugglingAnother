package ifrs.edu.Control;

import javax.ws.rs.core.Response;

import ifrs.edu.Entity.Trick;
import ifrs.edu.Entity.User;

public class ControlUpdate {
    
    public static Response updateUserControl(Long userId, User user) {
        
        User newUser = searchUser(userId); 

        if(newUser != null || CcreateUser.validUser(user)) {
            newUser.setName(user.getName());
            newUser.setPassword(user.getPassword());
            newUser.setEmail(user.getEmail());
        }

        return Response.status(404).build();
    }

    public static User searchUser(Long userId) {
        return User.findById(userId);
    }

    public static Response updateTrickControl(Long trickId, Trick trick) {
        
        Trick newTrick = searchTrick(trickId); 

        if(newTrick != null) {
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
    
    public static Trick searchTrick(Long trickId) {
        return Trick.findById(trickId);
    }

}
