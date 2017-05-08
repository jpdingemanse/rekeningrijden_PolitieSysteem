import { Component, OnInit } from '@angular/core'

import { HistoryService } from './../rest/history.Service';
import { Driver } from './../domain/driver';
import { Vehicle } from './../domain/vehicle';
import { History } from './../domain/history';

@Component({
    selector: 'historie-page',
    templateUrl: './historie.html',
    styleUrls: ['./../app.component.css']
})
export class HistoryPageComponent implements OnInit {
    ngOnInit(): void {
    }
    
    historySearch : History[];

    constructor(private historyService : HistoryService) { }

    onclickSearch(license: String) {
        this.historyService.getHistoryByLicenseplate(license)
            .then(value => this.historySearch = value)
    }
}