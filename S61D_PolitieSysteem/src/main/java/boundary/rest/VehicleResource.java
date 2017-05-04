/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary.rest;

import domain.Vehicle;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import service.VehicleService;

/**
 *
 * @author ruthgervandeneikhof
 */
@Stateless
@Path("Vehicle")
public class VehicleResource {
    @Inject
    VehicleService vehicleService;
    
    @GET
    @Path("GetVehicleByLicensePlate/{licensePlate}")
    public Vehicle getVehicleByLicensePlate(@PathParam("licensePlate")String licensePlate){
        return vehicleService.getVehicleByLicensePlate(licensePlate);
    }
    
    @POST
    @Path("createStolenVehicle")
    @Consumes("application/json")
    public Vehicle createStolenVehicle(Vehicle vehicle){
        vehicleService.createStolenVehicle(vehicle);
        return vehicle;
    }
    
//    @GET
//    @Path("GetAllVehicles")
//    public List<Vehicle> getAllVehicles(){
//        return vehicleService.getAllVehicles();
//    }
}
