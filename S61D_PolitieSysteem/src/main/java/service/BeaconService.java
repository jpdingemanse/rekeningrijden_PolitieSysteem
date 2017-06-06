/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import domain.Beacon;
import factory.VehicleTransmitter;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author ruthgervandeneikhof
 */
public class BeaconService {
    @Inject
    VehicleTransmitter vt;
    
    public  List<Beacon> getAllRideByIcan(String iCan, String date){

        List<Beacon> tempResult = null;
        try {
            tempResult =  vt.GetAllMovementsByIcanAndDate(iCan, date); 
        } catch (Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }
         return tempResult;
    }
}
