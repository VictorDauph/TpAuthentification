/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SessionHelper;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Victor
 */
public class SessionHelper {
    static EntityManager entityManager;
    
    public static EntityManager getEntityManager(){
              
        
        if (entityManager==null){
            EntityManagerFactory emf= Persistence.createEntityManagerFactory("tp_rest");  
            entityManager = emf.createEntityManager();
            
        }
        
        return entityManager;
    }
}


