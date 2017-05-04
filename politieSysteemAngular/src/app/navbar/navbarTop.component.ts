import { Component, ViewChild } from '@angular/core';
import { LoginService } from 'app/global/login.Service';


@Component({
    selector : 'navbar-Top',
    templateUrl: './navbarTop.html'
})

export class NavbarTopComponent {
    constructor(private loginService : LoginService){

    }  

    login(){
        this.loginService.loginPage = true;
        this.loginService.loginStatus = true;
    }

    logout(){
        this.loginService.loginPage = false;
        this.loginService.loginStatus = false;
    }

}