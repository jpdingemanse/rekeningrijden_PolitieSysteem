/*
 * TetrisBattle Copyright (C) 2015 - 2015 S31D, All rights reserved.
 * S31D is the rightful owner of this file, use without permission
 * from the owner is considered an offense and will be acted on accordingly.
 */
package boundary.rest.service;

import Service.VehicleService;
import domain.Vehicle;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 *
 * @author chielsprangers
 */
@Stateless
@Path("Vehicle")
public class VehicleResource {
    @Inject
    VehicleService vehicleService;
    
    @POST
    @Path("CreateVehicle")
    @Consumes("application/json")
    public Vehicle createVehicle(Vehicle vehicle){
        return vehicleService.createNewVehicle(vehicle);
    }
    
    @POST
    @Path("AddVehicleToDriver")
    @Consumes("application/json")
    public Vehicle addVehicleToDriver(Vehicle vehicle){
        return vehicleService.addVehicleToDriver(vehicle);
    }
    
    @GET
    @Path("GetAllVehicle/{id}")
    public List<Vehicle> getAllVehicle(@PathParam("id")int id){
        return vehicleService.getVehicleByOwner(id);
    }
}
