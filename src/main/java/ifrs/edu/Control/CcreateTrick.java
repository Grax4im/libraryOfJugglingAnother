package ifrs.edu.Control;

import javax.ws.rs.core.Response;

import ifrs.edu.Entity.Trick;

public class CcreateTrick {
    public static Response createTrick(Trick trick){
        trick.persist(); 
        return Response.ok(trick).build();
    }
}
