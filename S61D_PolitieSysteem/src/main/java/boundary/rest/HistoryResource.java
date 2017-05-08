/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary.rest;

import domain.History;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import service.HistoryService;

/**
 *
 * @author ruthgervandeneikhof
 */
@Stateless
@Path("History")
public class HistoryResource {
    @Inject
    HistoryService historyService;
    
    @GET
    @Path("GetHistoryByLicensePlate/{licensePlate}")
    public List<History> getHistoryByLicensePlate(@PathParam("licensePlate")String licensePlate){
        return historyService.getHistoryByLicenseplate(licensePlate);
    }
}
