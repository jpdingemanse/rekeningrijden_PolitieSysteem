import { Component, Input, ViewChild } from '@angular/core'

import { VehicleService } from './../rest/vehicle.service';
import { Driver } from './../domain/driver';
import { Vehicle } from './../domain/vehicle';
import { Tracker } from './../domain/tracker';

@Component({
    selector : 'car-page',
    templateUrl : './vehicle.html',
    styleUrls: ['./../app.component.css']
})

export class VehiclePageComponent {

    @ViewChild('editAutorisatieCodeModal')
    bgModel;

    @ViewChild('addTrackerCModal')
    bgModelTracker;
    
    vehicleSelected : Vehicle;
    vehicleSearch : Vehicle;
    availableVehicleList : Vehicle[] = [];

    constructor(private vehicleService : VehicleService){}

    onclickShowModal(value : Vehicle){
        // this.bgModel.show();
    }

    onclickSearch(license : String){
        this.availableVehicleList.length = 0;
        this.vehicleService.getVehicleByLicenseplate(license)
                           .then(value => this.vehicleSearch = value)
                           .then(() => { this.availableVehicleList.push(this.vehicleSearch) })
    }

    setStolen(value : Vehicle){
        this.availableVehicleList.length = 0
        this.vehicleService.setStolenVehicle(value)
                           .then(value => this.vehicleSearch = value)
                           .then(() => { this.availableVehicleList.push(this.vehicleSearch) })
                           .then(() => { console.log(value)});
        console.log(this.availableVehicleList);
    }

    onclickShowTrackerModal(){
        this.bgModelTracker.show();
    }

}