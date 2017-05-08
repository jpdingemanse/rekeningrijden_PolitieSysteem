import { Component, OnInit } from '@angular/core'

import { VehicleService } from './../rest/vehicle.service';
import { Driver } from './../domain/driver';
import { Vehicle } from './../domain/vehicle';
import { History } from './../domain/history';

@Component({
    selector: 'historie-page',
    templateUrl: './historie.html',
    styleUrls: ['./../app.component.css']
})
export class HistoryPageComponent implements OnInit {
    ngOnInit(): void {
    }
    vehicleSearch : Vehicle;
    historySearch : History[];

    constructor(private vehicleService : VehicleService) { }

    onclickSearch(license: String) {
        this.vehicleService.getVehicleByLicenseplate(license)
            .then(value => this.vehicleSearch = value)
            .then(() => { this.historySearch = this.vehicleSearch.history })
    }
}