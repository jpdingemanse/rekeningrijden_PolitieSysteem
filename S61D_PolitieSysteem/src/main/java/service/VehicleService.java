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
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.ejb.Stateless;
import javax.inject.Inject;

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
    
    public void createStolenVehicle(Vehicle vehicle){
        vehicleDao.createStolenVehicle(vehicle); 
        StolenVehicle sv = new StolenVehicle(vehicle.getOwner().getIcan(), vehicle.getLicensePlate(), System.currentTimeMillis(), true);
        //TopicConnector.CArigattor(gson.toJson(sv));
    }
    
    public Vehicle getVehicleByLicensePlate(String licensePlate) {
        Vehicle vehicle = vehicleDao.getVehicleByLicensePlate(licensePlate);
        if(vehicle==null){
            vehicle = vehicletm.getVehicleByLicenseRekening(licensePlate);
        }
        return vehicle;
    }    
}
