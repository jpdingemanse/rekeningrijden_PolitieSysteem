/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import com.google.gson.Gson;
import domain.Vehicle;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import static javax.ws.rs.core.HttpHeaders.USER_AGENT;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 *
 * @author ruthgervandeneikhof
 */
@Stateless
public class VehicleTransmitter {

public Vehicle getVehicleByLicenseRekening(String licenseplate){
        StringBuilder result = new StringBuilder();
        Vehicle vehicle = null;
        try {
            String url = "http://192.168.24.46:8080/S61D_RekeningAdministratie/api/Vehicle/GetVehicleByLicensePlate/" + licenseplate;
            HttpClient client = new DefaultHttpClient();
            HttpGet request = new HttpGet(url);

            // add request header
            request.addHeader("User-Agent", USER_AGENT);

            HttpResponse response = client.execute(request);

            System.out.println("\nSending 'GET' request to URL : " + url);
            System.out.println("Response Code : "
                    + response.getStatusLine().getStatusCode());

            BufferedReader rd = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));
            
            Gson gson = new Gson();
            String line = "";
            while ((line = rd.readLine()) != null) {
                result.append(line);
                vehicle = gson.fromJson(line, Vehicle.class);
            }

            System.out.println(result.toString());
        } catch (IOException ex) {
            Logger.getLogger(Vehicle.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vehicle;
    }    
}

