/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary.rest;

import domain.StolenVehicle;
import domain.Vehicle;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.naming.NamingException;
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
    
    @GET
    @Path("GetAllStolenVehicles")
    public List<StolenVehicle> getAllStolenVehicles(){
        return vehicleService.getAllSv();
    }
    
    @POST
    @Path("createStolenVehicle")
    @Consumes("application/json")
    public Vehicle createStolenVehicle(Vehicle vehicle) throws NamingException, Exception{
        return vehicleService.createStolenVehicle(vehicle);
    }
}
