import { Injectable } from '@angular/core'
import { Http, Response, Headers } from '@angular/http';

import 'rxjs/add/operator/toPromise';

@Injectable()
export class UserService {
    private url = "http://192.168.24.46:8080/S61D_RekeningAdministratie/api/User/";
    private localurl = "http://localhost:18410/S61D_RekeningAdministratie/api/User/"

    constructor(private http : Http){}

    getUserByUsernameAndPassword(username: String, password: String){
         return this.http.get(this.localurl + 'GetUserByUsernameAndPassword/' + username +'/'+ password)
                        .toPromise()
                        .then(this.extractData);
    }

    private extractData(res: Response) {
        return res.json();
    }
}