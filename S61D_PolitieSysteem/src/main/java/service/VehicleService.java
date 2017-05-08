/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.VehicleDao;
import domain.Vehicle;
import factory.VehicleTransmitter;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author ruthgervandeneikhof
 */
@Stateless
public class VehicleService {
    @Inject
    VehicleDao vehicleDAO;
    @Inject 
    VehicleTransmitter vehicletm;
    
    public void createStolenVehicle(Vehicle vehicle){
        vehicleDAO.createStolenVehicle(vehicle); 
    }
    
    public Vehicle getVehicleByLicensePlate(String licensePlate) {
        Vehicle vehicle = vehicleDAO.getVehicleByLicensePlate(licensePlate);
        if(vehicle==null){
            vehicle = vehicletm.getVehicleByLicenseRekening(licensePlate);
        }
        return vehicle;
    }    
}
