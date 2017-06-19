/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import boundary.jms.TopicConnector;
import com.google.gson.Gson;
import dao.VehicleDao;
import domain.StolenVehicle;
import domain.Vehicle;
import factory.VehicleTransmitter;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.naming.NamingException;

/**
 *
 * @author ruthgervandeneikhof
 */
@Stateless
public class VehicleService {
    @Inject
    VehicleDao vehicleDao;
    @Inject 
    VehicleTransmitter vehicletm;
    Gson gson = new Gson();
    
    public Vehicle createStolenVehicle(Vehicle vehicle) throws NamingException, Exception, Exception{
        Vehicle tempv = vehicleDao.createStolenVehicle(vehicle); 
        tempv.setIsStolen(true);
        StolenVehicle sv = vehicleDao.createEuropeStolen(new StolenVehicle(tempv.getiCan(), tempv.getLicensePlate(), System.currentTimeMillis(), true));
        TopicConnector.sendMessage(gson.toJson(sv));
        return tempv;
    }
    
    public List<StolenVehicle> getAllSv(){
        return vehicleDao.getAllStolenVehicles();
    }
    
    public Vehicle getVehicleByLicensePlate(String licensePlate) {
        Vehicle vehicle = vehicleDao.getVehicleByLicensePlate(licensePlate); 
        if(vehicle==null){
            vehicle = vehicletm.getVehicleByLicenseRekening(licensePlate);
            vehicle.setIsStolen(false);
        } 
        return vehicle;
    }    
}
