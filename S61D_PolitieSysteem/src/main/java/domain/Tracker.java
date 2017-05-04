/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author ruthgervandeneikhof
 */
@Entity
public class Tracker implements Serializable {

    @Id
    String id;
    @Column(name = "Latitude", columnDefinition = "Double default '0'")
    double latitude;
    @Column(name = "Longitude", columnDefinition = "Double default '0'")
    double longitude;
    @OneToOne
    private Vehicle vehicle;

    public Tracker(String id, double Latitude, double longitude) {
        this.id = id;
        this.latitude = Latitude;
        this.longitude = longitude;
    }

    public Tracker() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double Latitude) {
        this.latitude = Latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

}

