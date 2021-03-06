/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lino_
 */
@Entity
@XmlRootElement
public class Vehicle implements Serializable{
    @Id
    private String licensePlate;
    
    

    @ManyToOne
    private Driver owner;
    
    @ManyToMany
    private List<Driver> previousOwners;

    public Vehicle() {
    }

    public Vehicle(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public List<Driver> getPreviousOwners() {
        return previousOwners;
    }

    public void setPreviousOwners(List<Driver> previousOwners) {
        this.previousOwners = previousOwners;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public Driver getOwner() {
        return owner;
    }

    public void setOwner(Driver owner) {
        this.owner = owner;
    }
    
    
}
