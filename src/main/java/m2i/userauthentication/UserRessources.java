/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package m2i.userauthentication;


import java.util.List;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Victor
 */
@Path("/users")
public class UserRessources {
 
    UserDao userDao = new UserDao();
    
    @Context
    private HttpServletRequest request;

/*    test de récupération de l'user connecté
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRequest(){
        User user= (User)request.getAttribute("user");
        System.out.println("request received, user : "+user);

        return Response.status(Response.Status.OK).entity(user).build();
    }
*/    
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllUsers(){
        List<User> userList= userDao.findAll();
        return Response.status(Response.Status.OK ).entity(userList).build();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addUser(@Context HttpServletRequest request,User current){
        userDao.addUser(current);
        return Response.status(Response.Status.CREATED ).entity(current).build();
    }
}
