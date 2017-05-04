import { Injectable } from '@angular/core'
import {User } from 'app/domain/user';

@Injectable()
export class LoginService {
    public loginStatus : boolean = false;
    public loginPage : boolean = false;

    public loginUser : User;


}

