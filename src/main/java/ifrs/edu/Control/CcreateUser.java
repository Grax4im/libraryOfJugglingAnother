package ifrs.edu.Control;


import javax.ws.rs.core.Response;

import ifrs.edu.Entity.User;

public class CcreateUser {

    //criar método para evitar nomes duplicados
    public static Response createUser(User user) {
        //coloca o tipo de usuário sempre como 1, endpoint só adiciona Criadores
        user.setType(1);
        if(validUser(user)){
            user.persist();
            return Response.ok(user).build();
        }
        return Response.status(404).build();
    }

    public static boolean validUser(User user){
        return !(user.getName() == null || user.getPassword() == null || user.getEmail() == null );
    }
}
