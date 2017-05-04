/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Driver;
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
public class DriverDao {
    @PersistenceContext
    EntityManager em;
    
    public DriverDao(){
        
    }
    
    public Driver createNewDriver(Driver driver){
        em.persist(driver);
        em.flush();
        return em.find(Driver.class, driver.getId());
    }

    public Driver getDriver(int id) {
        Driver result = em.find(Driver.class, id);
        return result;
    }

    public List<Driver> getDriverByName(String name, String lastName) {
            Query query = em.createNamedQuery("Driver.getDriverByName").setParameter("name", name).setParameter("lastname", lastName);
            return query.getResultList();
    }
    
    
}
