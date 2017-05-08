import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { AgmCoreModule } from 'angular2-google-maps/core';

import { Routing } from './routes/routing.component';
import { ModalModule, TabsModule } from 'ng2-bootstrap';

import { AppComponent } from './app.component';
import { NavbarTopComponent } from './navbar/navbarTop.component';
import { NavbarLeftComponent } from './navbar/navbarLeft.component';
import { VehiclePageComponent } from './vehicle/vehicle.component';
import { TrackingPageComponent } from './tracking/tracking.component';

import { LoginComponent } from './login/login.component';
import { HistoryPageComponent } from "app/voertuigGeschiedenis/historie.component";
import { VehicleService } from './rest/vehicle.service';
import { UserService } from './rest/user.Service';
import { DriverService } from './rest/driver.Service';
import { BeaconService } from './rest/beacon.Service';
import { HistoryService } from './rest/history.Service';

import { LoginService } from './global/login.Service';



@NgModule({
  declarations: [
    AppComponent,
    NavbarTopComponent,
    NavbarLeftComponent,
    HistoryPageComponent,
    VehiclePageComponent,
    TrackingPageComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    Routing,
    ModalModule.forRoot(),
    TabsModule.forRoot(),
    AgmCoreModule.forRoot({
      apiKey: 'AIzaSyCvXw7f8fGtztwUHQRFthQAKc1-XyYS24A'
    })
  ],
  providers: [
    VehicleService,
    UserService,
    DriverService,
    LoginService,
    HistoryService,
    BeaconService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
