import { Driver } from "app/domain/driver";
import { Tracker } from "app/domain/tracker";
import { History } from "app/domain/history";

export class Vehicle {
    public licensePlate: string;
    public autorisatieCode: string;
    public owner: Driver;
    public tracker: Tracker;
    public stolen: boolean;
    public history: History[];
    constructor() { }

    setDriver(driver: Driver) {
        this.owner = driver;
    }
    setLicensePlate(licensePlate: string) {
        this.licensePlate = licensePlate;
    }
    setautorisatieCode(autorisatieCode: string) {
        this.autorisatieCode = autorisatieCode;
    }
    setTracker(tracker: Tracker) {
        this.tracker = tracker;
    }
    setStolen(isStolen: boolean){
        this.stolen = isStolen;
    }
    setHistory(history: History[]){
        this.history = history;
    }
}