import { Component, Input, ViewChild } from '@angular/core'

import { VehicleService } from './../rest/vehicle.service';
import { Driver } from './../domain/driver';
import { Vehicle } from './../domain/vehicle';
import { StolenVehicle } from './../domain/stolenVehicle'
import { Tracker } from './../domain/tracker';

@Component({
    selector: 'car-page',
    templateUrl: './vehicle.html',
    styleUrls: ['./../app.component.css']
})

export class VehiclePageComponent {

    @ViewChild('editAutorisatieCodeModal')
    bgModel;

    @ViewChild('addTrackerCModal')
    bgModelTracker;

    vehicleSelected: Vehicle;
    vehicleSearch: Vehicle;
    message: string;
    stolenMessage : string;
    availableVehicleList: Vehicle[] = [];
    stolenVehicles: StolenVehicle[] = [];

    constructor(private vehicleService: VehicleService) { }

    onclickShowModal(value: Vehicle) {
        // this.bgModel.show();
    }

    onclickSearch(license: String) {
        this.message = '';
        if (license != '') {
            this.availableVehicleList.length = 0;
            this.vehicleService.getVehicleByLicenseplate(license)
                .then(result => {
                    if (result == null) {
                         this.message = 'Er is iets fout gegaan bij het kenteken ophalen.';                 
                    } else {
                        this.vehicleSearch = result
                        this.availableVehicleList.push(this.vehicleSearch)
                        console.log(this.vehicleSearch)
                    }
                })
                .catch(error => {this.message = 'Er is iets fout gegaan bij het kenteken ophalen.'})
        } else {
            this.message = 'Geef eerst een kenteken op.';
        }
    }

    onclickGetAllStolen() {
        this.stolenVehicles.length = 0;
        this.vehicleService.getAllStolenVehicles()
            .then(result => {
                    this.stolenVehicles = result
                    if (this.stolenVehicles.length == 0) {
                         this.stolenMessage = "Er zijn gestolen auto's";                 
                    } else {
                        console.log(this.stolenVehicles)
                    }
                })
                .catch(error => {this.stolenMessage = 'Er is iets fout gegaan bij het kenteken ophalen.'})
    }

    setStolen(value: Vehicle) {
        this.availableVehicleList.length = 0
        this.vehicleService.setStolenVehicle(value)
            .then(value => this.vehicleSearch = value)
            .then(() => { this.availableVehicleList.push(this.vehicleSearch) })
            .then(() => { console.log(value) });
        console.log(this.availableVehicleList);
    }

    onclickShowTrackerModal() {
        this.bgModelTracker.show();
    }

}