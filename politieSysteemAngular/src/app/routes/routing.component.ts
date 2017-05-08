import { ModuleWithProviders } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { AppComponent } from './../app.component';
import { VehiclePageComponent } from './../vehicle/vehicle.component';
import { HistoryPageComponent } from './../voertuigGeschiedenis/historie.component';
import { TrackingPageComponent } from './../tracking/tracking.component';

export const router: Routes = [
    { path: 'vehicle', component: VehiclePageComponent},
    { path: 'Geschiedenis', component: HistoryPageComponent},
    { path: 'Tracking', component: TrackingPageComponent}
];

export const Routing: ModuleWithProviders = RouterModule.forRoot(router);