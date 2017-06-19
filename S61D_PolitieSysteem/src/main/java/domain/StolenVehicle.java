/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author ruthgervandeneikhof
 */
@Entity
@NamedQueries({
    @NamedQuery(name="StolenVehicle.getAllSv", query="Select v from StolenVehicle v"),
})
public class StolenVehicle implements Serializable {
    String  ican;
    @Id
    String  licenseplate;
    long    timestamp;
    boolean stolenValue;

    public StolenVehicle() {
    }

    public StolenVehicle(String ican, String licenseplate, long timestamp, boolean stolenValue) {
        this.ican = ican;
        this.licenseplate = licenseplate;
        this.timestamp = timestamp;
        this.stolenValue = stolenValue;
    }

    public String getIcan() {
        return ican;
    }

    public void setIcan(String ican) {
        this.ican = ican;
    }

    public String getLicenseplate() {
        return licenseplate;
    }

    public void setLicenseplate(String licenseplate) {
        this.licenseplate = licenseplate;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public boolean isStolenValue() {
        return stolenValue;
    }

    public void setStolenValue(boolean stolenValue) {
        this.stolenValue = stolenValue;
    }
}
