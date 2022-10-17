package ifrs.edu.Control;

import javax.ws.rs.core.Response;

import ifrs.edu.Entity.Trick;

public class CcreateTrick {
    public static Response createTrick(Trick trick){
        if(validTrick(trick)) {
            return Response.status(404).build();
        };
        trick.persist(); 
        return Response.ok(trick).build();
    }

    public static boolean validTrick(Trick trick) {
        return !(   trick.getName() == null || 
                    trick.getDifficult() < 0 || 
                    trick.getDescription() == null || 
                    trick.getNumberOfBalls() < 0);
    }
}
