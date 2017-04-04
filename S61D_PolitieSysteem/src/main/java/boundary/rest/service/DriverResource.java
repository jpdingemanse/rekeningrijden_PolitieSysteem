/*
 * TetrisBattle Copyright (C) 2015 - 2015 S31D, All rights reserved.
 * S31D is the rightful owner of this file, use without permission
 * from the owner is considered an offense and will be acted on accordingly.
 */
package boundary.rest.service;

import Service.DriverService;
import domain.Driver;
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
@Path("Driver")
public class DriverResource {
    @Inject
    DriverService driverService;
    
    @POST
    @Path("CreateDriver")
    @Consumes("application/json")
    public Driver createNewDriver(Driver driver){
        return driverService.createNewDriver(driver);
    }
    
    @GET
    @Path("GetDriver/{id}")
    public Driver getDriver(@PathParam("id")int id){
        return driverService.getDriver(id);
    }
    
    
    
    
}
