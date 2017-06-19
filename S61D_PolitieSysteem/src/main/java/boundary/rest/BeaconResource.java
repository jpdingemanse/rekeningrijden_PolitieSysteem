/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary.rest;

import domain.Beacon;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import service.BeaconService;

/**
 *
 * @author ruthgervandeneikhof
 */
@Stateless
@Path("Beacon")
public class BeaconResource {

    @Inject
    BeaconService beaconService;

    @GET
    @Path("GetMovementsPerIcan/{iCan}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Beacon> getMovementPerIcan(@PathParam("iCan") String iCan) {
        try {
            return beaconService.getAllRideByIcan(iCan);
        } catch (Exception ex) {
            return null;
        }

    }
}
