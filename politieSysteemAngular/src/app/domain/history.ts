import { Driver } from "app/domain/driver";
export class History {
    constructor(
        public id: number,
        public bestuurder: Driver,
        public overschrijfDatum: string
    ) {

    }
}