package m2i.userauthentication;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;


@Provider
@PreMatching
public class AuthFilter implements ContainerRequestFilter {
    
    @Context
    private HttpServletRequest request;
    
    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        /* TODO */
        /* ---- */
        
        String email;
        String password;
        String[] decodedAuth;
        
        // Récuperer le header Authorization
        String authorization=requestContext.getHeaderString("Authorization");
        
        // Décoder la valeur du header Authorization pour récuperer l'email et le mot de passe
        System.out.println("authorization : "+ requestContext.getHeaderString("Authorization"));
        
        if(authorization!=null){
            decodedAuth = BasicAuth.decode(authorization);
            email = decodedAuth[0];
            password = decodedAuth[1];

            // Implémenter la méthode checkUser qui vérifie les identifiants
            System.out.println("filter engaged : "+ decodedAuth[0]+" "+decodedAuth[1]);
            User user=checkUser(email,password);
            System.out.println("userChecked : "+user);

            // Mettre l'utilisateur en attribut de la requete
            request.setAttribute("user", user);
        }else{
            throw new WebApplicationException (Response.status(Response.Status.BAD_REQUEST).entity("Pas de données d'authentification").build() );
        }   
    }
    
    public User checkUser(String email, String password) {
        
        UserDao userDao = new UserDao();
        User userToCheck = userDao.findByEmail(email);
        System.out.println("user to check : "+userToCheck);
        if(userToCheck != null){
           if(userDao.checkPassword(userToCheck, password)==true){
               return userToCheck;
           }
        }
        throw new WebApplicationException (Response.status(Response.Status.NOT_FOUND).entity("mauvaises données d'authentification").build() );
    }   
}
