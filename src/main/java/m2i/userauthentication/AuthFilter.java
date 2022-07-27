package m2i.userauthentication;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.Context;
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
        
        // Récuperer le header Authorization
        // Décoder la valeur du header Authorization pour récuperer l'email et le mot de passe
        // Implémenter la méthode checkUser qui vérifie les identifiants
        // Mettre l'utilisateur en attribut de la requete
        
        // email:password
        String[] decodedAuth = BasicAuth.decode("vdqs");
        
        String email = decodedAuth[0]; // email
        String password = decodedAuth[1]; // password
            
    }
    
    public User checkUser(String email, String password) {
        return null;
    }   
}
