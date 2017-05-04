import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { Routing } from './routes/routing.component';
import { ModalModule, TabsModule } from 'ng2-bootstrap';

import { AppComponent } from './app.component';
import { NavbarTopComponent } from './navbar/navbarTop.component';
import { NavbarLeftComponent } from './navbar/navbarLeft.component';
import { VehiclePageComponent } from './vehicle/vehicle.component';

import { LoginComponent } from './login/login.component';
import { HistoriePageComponent } from "app/voertuigGeschiedenis/historie.component";
import { VehicleService } from './rest/vehicle.service';
import { UserService } from './rest/user.Service';
import { DriverService } from './rest/driver.Service';

import { LoginService } from './global/login.Service';



@NgModule({
  declarations: [
    AppComponent,
    NavbarTopComponent,
    NavbarLeftComponent,
    HistoriePageComponent,
    VehiclePageComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    Routing,
    ModalModule.forRoot(),
    TabsModule.forRoot()
  ],
  providers: [
    VehicleService,
    UserService,
    DriverService,
    LoginService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
