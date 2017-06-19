import { Injectable } from "@angular/core";
import { Http, Response, Headers } from "@angular/http";

import 'rxjs/add/operator/toPromise';

import { Vehicle } from './../domain/vehicle';
import { StolenVehicle } from './../domain/stolenVehicle'

@Injectable()
export class VehicleService {
    private url = "http://192.168.24.45:8080/S61D_PolitieSysteem/api/Vehicle/";
    private localurl = "http://localhost:8080/S61D_PolitieSysteem/api/Vehicle/";

    constructor(private http: Http) { }

    getAllVehicles(): Promise<Vehicle[]>{
        return this.http.get(this.url + "GetAllVehicles")
            .toPromise()
            .then(this.extractData);
    }

    getVehicleByLicenseplate(license: String): Promise<Vehicle>{
         return this.http.get(this.url + 'GetVehicleByLicensePlate/' + license)
                        .toPromise()
                        .then(this.extractData);
    }

    setStolenVehicle(vehicle : Vehicle) : Promise<Vehicle>{
        var header = new Headers();
        header.append('Content-Type', 'application/json');
        return this.http.post(this.url + 'createStolenVehicle', JSON.stringify(vehicle), { headers: header })
        .toPromise().then(this.extractData);
    }

    getAllStolenVehicles(): Promise<StolenVehicle[]>{
        return this.http.get(this.url + "GetAllStolenVehicles")
            .toPromise()
            .then(this.extractData);
    }

    private extractData(res: Response) {
        return res.json();
    }
}