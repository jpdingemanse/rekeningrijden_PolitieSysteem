/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Vehicle;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
    
    public void createStolenVehicle(Vehicle vehicle){
        Vehicle tempV = em.find(Vehicle.class, vehicle.getLicensePlate());
        if(tempV == null){
            vehicle.setIsStolen(true);
            em.persist(vehicle);
        } else {
            tempV.setIsStolen(true);
            em.merge(tempV);
        }
    }
     
}
