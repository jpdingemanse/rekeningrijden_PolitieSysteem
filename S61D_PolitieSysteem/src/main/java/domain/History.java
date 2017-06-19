/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author ruthgervandeneikhof
 */
@Entity
public class History implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Temporal(javax.persistence.TemporalType.DATE)
    Date overschrijfDatum;
    @ManyToOne
    private Vehicle vehicle;
    
    public History(){}
    
    public History(Vehicle bestuurder, Date overschrijfDatum){
        this.vehicle = bestuurder;
        this.overschrijfDatum = overschrijfDatum;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getId() {
        return id;
    }
    
    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle bestuurder) {
        this.vehicle = bestuurder;
    }

    public Date getOverschrijfDatum() {
        return overschrijfDatum;
    }

    public void setOverschrijfDatum(Date overschrijfDatum) {
        this.overschrijfDatum = overschrijfDatum;
    }
    
}
