import { Time } from "@angular/common";

export class transaction{
    constructor(
        id : number,
      active : boolean,
         amount: number,
        discount : number,
         model : string,
          pickupdate : Date,
          pickuplocation : string,
          pickuptime : Time,
          returndate : Date,
          returnlocation : string,
          returntime : Time,
          returnfuelquantity : string,
          username : string,
          insurencestatus : boolean,
          totalamount : number,
          miscellaneous : boolean,
          comments : string
     ) {}
}