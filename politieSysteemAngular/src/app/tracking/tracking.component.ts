import { Component, OnInit,NgModule } from '@angular/core'

import { VehicleService } from './../rest/vehicle.service';
import { BeaconService } from './../rest/beacon.Service';

import { Driver } from './../domain/driver';
import { Vehicle } from './../domain/vehicle';
import { History } from './../domain/history';
import { Beacon } from './../domain/beacon';

@Component({
    selector: 'tracking-page',
    templateUrl: './tracking.html',
    styleUrls: ['./../app.component.css']
})
export class TrackingPageComponent implements OnInit {
    ngOnInit(): void {
    }
    vehicleSearch : Vehicle;
    historySearch : History[];
    lat: number = 51.452117;
    lng: number = 5.481302;

    constructor(private vehicleService : VehicleService) { }

    onclickSearch(license: String) {
        this.vehicleService.getVehicleByLicenseplate(license)
            .then(value => this.vehicleSearch = value)
            .then(() => { this.historySearch = this.vehicleSearch.history })
    }
}

import {
  BrowserModule
} from '@angular/platform-browser';

import {
  AgmCoreModule
} from 'angular2-google-maps/core';





export class App {
  // google maps zoom level
  zoom: number = 8;
  
  // initial center position for the map
  lat: number = 52.673858;
  lng: number = 4.815982;
  
  clickedMarker(label: string, index: number) {
    console.log(`clicked the marker: ${label || index}`)
  }

  
  markerDragEnd(m: marker, $event: MouseEvent) {
    console.log('dragEnd', m, $event);
  }

  movementList : Beacon[];
    selectedMovement : Beacon;
        ngOnInit(): void {
            this.movementService.GetMovementsPerIcan('123')
                            .then(value => this.movementList = value)
                            .then(() => console.log(this.movementList))
        }
     
    constructor(private movementService : BeaconService){}
  
  markers: marker[] = [
	  {
		  lat: 52.673858,
		  lng: 4.815982,
	  },
	  {
		  lat: 52.373858,
		  lng: 4.215982,
	  },
	  {
		  lat: 52.723858,
		  lng: 4.895982,
	  }
  ]
}

// just an interface for type safety.
interface marker {
	lat: number;
	lng: number;
}

@NgModule({
  imports: [ BrowserModule, AgmCoreModule.forRoot() ],
  declarations: [ App ],
  bootstrap: [ App ]
})
export class AppModule {}