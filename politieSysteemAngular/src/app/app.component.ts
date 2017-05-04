import { Component, OnInit } from '@angular/core';
import { LoginService } from 'app/global/login.Service'

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent{
   
   constructor(private loginService : LoginService){}

    
}
