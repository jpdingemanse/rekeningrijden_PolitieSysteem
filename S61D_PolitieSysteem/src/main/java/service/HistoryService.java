/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import domain.History;
import domain.Vehicle;
import factory.VehicleTransmitter;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author ruthgervandeneikhof
 */
@Stateless
public class HistoryService {
    @Inject 
    VehicleTransmitter vehicletm;
    
    public List<History> getHistoryByLicenseplate(String licensplate){
        Vehicle vehicle = vehicletm.getVehicleByLicenseRekening(licensplate);
        return vehicle.getHistory();
    }
}
