/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author ruthgervandeneikhof
 */
@Entity
@NamedQueries({
    @NamedQuery(name="vehicle.getByOwnerId", query="select v from Vehicle v where v.owner.id = :id"),
    @NamedQuery(name="vehicle.getAllVehicles", query="select v from Vehicle v"),
    @NamedQuery(name="vehicle.getVehicleByIcan", query="select v from Vehicle v where v.iCan = :iCan")
})
public class Vehicle implements Serializable{
    @Id
    private String licensePlate;
    private String autorisatieCode;
    @ManyToOne
    private Driver owner;
    private String iCan;
    private boolean isStolen;
    @OneToMany(mappedBy = "vehicle",cascade = CascadeType.PERSIST)
    private List<History> history;
  
    public Vehicle() {
    }

    public Vehicle(String licensePlate) {
        this.licensePlate = licensePlate;
        this.history = new ArrayList();
    }

    public Vehicle(String licensePlate, String iCan) {
        this.licensePlate = licensePlate;
        this.iCan = iCan;
        this.history = new ArrayList();
    }

    public String getAutorisatieCode() {
        return autorisatieCode;
    }

    public void setAutorisatieCode(String autorisatieCode) {
        this.autorisatieCode = autorisatieCode;
    }

    public boolean isIsStolen() {
        return isStolen;
    }

    public void setIsStolen(boolean isStolen) {
        this.isStolen = isStolen;
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

    public String getiCan() {
        return iCan;
    }

    public void setiCan(String iCan) {
        this.iCan = iCan;
    }
    
    public List<History> getHistory() {
        return history;
    }

    public void setHistory(List<History> history) {
        this.history = history;
    }
}

