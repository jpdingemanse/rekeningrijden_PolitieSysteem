/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import domain.Beacon;
import factory.VehicleTransmitter;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author ruthgervandeneikhof
 */
@Stateless
public class BeaconService {
    @Inject
    VehicleTransmitter vt;
    
    public  List<Beacon> getAllRideByIcan(String iCan){

        List<Beacon> tempResult = null;
        try {
            tempResult =  vt.GetAllMovements(iCan); 
        } catch (Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }
         return tempResult;
    }
}
