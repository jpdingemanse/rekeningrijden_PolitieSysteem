/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.StolenVehicle;
import domain.Vehicle;
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
public class VehicleDao {
    @PersistenceContext
    EntityManager em;
    
    public Vehicle getVehicleByLicensePlate(String licensePlate) {
        Vehicle result = em.find(Vehicle.class, licensePlate);        
        return result;
    }
    
    public StolenVehicle createEuropeStolen(StolenVehicle sv){
        em.persist(sv);
        return sv;
    }
    
    public List<StolenVehicle> getAllStolenVehicles(){
        Query qeury = em.createNamedQuery("StolenVehicle.getAllSv");
        return qeury.getResultList();
    }
    
    public Vehicle createStolenVehicle(Vehicle vehicle){
        Vehicle tempV = em.find(Vehicle.class, vehicle.getLicensePlate());
        if(tempV == null){
            vehicle.setIsStolen(true);
            em.persist(vehicle);
            return vehicle;
        } else {
            tempV.setIsStolen(true);
            em.merge(tempV);
            return tempV;
        }
    }
     
}
