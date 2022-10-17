package ifrs.edu.Control;

import java.util.Arrays;
import java.util.HashSet;

import javax.ws.rs.core.Response;

import org.eclipse.microprofile.jwt.Claims;

import ifrs.edu.Entity.User;
import io.smallrye.jwt.build.Jwt;

public class CloginUser {

   public static Response loginUser(User user) {
        //se o usuário existir
        String jwt = null;

        if(loginAndPassword(user.getName(), user.getPassword())) {
            //user agora é o do banco e não mais o enviado pelo usuário 
            user = findUser(user.getName());
          
            //se for admin retorna o jwt de admin
            if(isAdmin(user)) {
                System.out.println(jwt);
                return Response.ok(jwtAdmin(user)).build();
            } 

            //se for criador, retorna jwt de criador
            else {
                return Response.ok(jwtCreator(user)).build();
            }
        }
        return Response.status(404).build();
    }

    //verifica se o login bate com a senha
    private static boolean loginAndPassword(String name, String password) {
        User userName = User.find("name", name).firstResult();
        User userPass = User.find("password", password).firstResult();
        return (userName.getPassword().equals(userPass.getPassword()));
    }

    //verifica se o user é admin
    public static boolean isAdmin(User user) {
        if (user.getType() == 0) return true;
        return false;
    }

    //retorna o jwt do Admin
    public static String jwtAdmin(User user) {
        return Jwt.issuer("http://localhost:8080")
        .upn(user.getEmail())
        .groups(new HashSet<>(Arrays.asList("Admin")))
        .claim(Claims.full_name, user.getName())
        .sign();        
       
    }

    //retorna o jwt do criador
    public static String jwtCreator(User user) {
        return Jwt.issuer("http://localhost:8080")
        .upn(user.getEmail())
        .groups(new HashSet<>(Arrays.asList("Creator")))
        .claim(Claims.full_name, user.getName())
        .sign();        
    }

    public static User findUser(String name){
        return User.find("name", name).firstResult();
    }
}
