/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package m2i.userauthentication;


import SessionHelper.SessionHelper;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

/**
 *
 * @author Victor
 */
public class UserDao {
    private static EntityManager entityManager = SessionHelper.getEntityManager();
    
    
        public User findByEmail(String email ){
            System.out.println("searching email : "+email);
            Query findByEmailQuery = entityManager.createQuery("select u from User u where u.email = :email ")
            .setParameter("email",email);     
            try{
                User foundUser=(User)findByEmailQuery.getSingleResult();
                System.out.println("found User : "+(User)findByEmailQuery.getSingleResult() );
                return foundUser; 
            }catch(NoResultException e){
                return null;
            }

        }
        
        public Boolean checkPassword(User user,String password){
            if(user.getPassword().equals(password) ){
                return true;
            }
            return false;
        }
    
    
        public List<User> findAll(){
            Query findAllQuery = entityManager.createQuery("select u from User u");
            return findAllQuery.getResultList();   
        }    
        
        public void addUser(User newUser){
            EntityTransaction trans = null;
            try{
                trans= entityManager.getTransaction();
                trans.begin();
                    entityManager.persist(newUser);
                trans.commit();
            }catch(Exception e){
                if (trans != null) trans.rollback();
                throw new WebApplicationException (Response.status(Response.Status.BAD_REQUEST).entity("Requête nulle!").build() );
            }            
        }
}
