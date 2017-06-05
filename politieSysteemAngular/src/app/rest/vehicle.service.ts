import { Injectable } from "@angular/core";
import { Http, Response, Headers } from "@angular/http";

import 'rxjs/add/operator/toPromise';

import { Vehicle } from './../domain/vehicle';

@Injectable()
export class VehicleService {
    private url = "http://192.168.24.45:8080/S61D_PolitieSysteem/api/Vehicle/";
    private localurl = "http://localhost:8080/S61D_PolitieSysteem/api/Vehicle/";

    constructor(private http: Http) { }

    getAllVehicles(): Promise<Vehicle[]>{
        return this.http.get(this.localurl + "GetAllVehicles")
            .toPromise()
            .then(this.extractData);
    }

    getVehicleByLicenseplate(license: String): Promise<Vehicle>{
         return this.http.get(this.localurl + 'GetVehicleByLicensePlate/' + license)
                        .toPromise()
                        .then(this.extractData);
    }

    setStolenVehicle(vehicle : Vehicle) : Promise<Vehicle>{
        var header = new Headers();
        header.append('Content-Type', 'application/json');
        return this.http.post(this.localurl + 'createStolenVehicle', JSON.stringify(vehicle), { headers: header })
        .toPromise().then(this.extractData);
    }

    private extractData(res: Response) {
        return res.json();
    }
}