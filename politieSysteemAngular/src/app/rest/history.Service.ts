import { Injectable } from "@angular/core";
import { Http, Response, Headers } from "@angular/http";

import 'rxjs/add/operator/toPromise';

import { History } from './../domain/history';

@Injectable()
export class HistoryService {
    private url = "http://192.168.24.45:8080/S61D_PolitieSysteem/api/History/";
    private localurl = "http://localhost:8080/S61D_PolitieSysteem/api/History/";

    constructor(private http: Http) { }

    // getAllVehicles(): Promise<Vehicle[]>{
    //     return this.http.get(this.localurl + "GetAllVehicles")
    //         .toPromise()
    //         .then(this.extractData);
    // }

    getHistoryByLicenseplate(license: String): Promise<History[]>{
         return this.http.get(this.url + 'GetHistoryByLicensePlate/' + license)
                        .toPromise()
                        .then(this.extractData);
    }

    private extractData(res: Response) {
        return res.json();
    }
}