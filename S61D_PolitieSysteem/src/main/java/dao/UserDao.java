/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.User;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author ruthgervandeneikhof
 */
@Stateless
public class UserDao {
    @PersistenceContext
    EntityManager em;
    
    public User createUser(User user){
        em.persist(user);
        em.flush();
        return em.find(User.class, user.getId());
    }
    
    public User getUserByUsernameAndPassword(String username, String password){
        try{
            Query query = em.createNamedQuery("user.getUserByUsernameAndPassword").setParameter("username", username).setParameter("password", password);
            List<User> result = query.getResultList();
            return result.get(0);
        }catch (Exception ex) {
            return null;
        }
        
    }
}
