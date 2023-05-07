import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { ApiServiceService } from 'src/app/api-service.service';
@Component({
  selector: 'app-vehicles',
  templateUrl: './vehicles.component.html',
  styleUrls: ['./vehicles.component.css']
})
export class VehiclesComponent implements OnInit {

  vehicles: any;
  selectedFlow: any = 'view';
  disabled: boolean = true;
  locationList: any = [
    'Ohio',
    'New York',
    'California',
    'Texas',
    'Washington',
    'Florida',
    'Illinois',
    'Pennsylvania',
    'Georgia',
    'North Carolina',
    'Michigan',
    'New Jersey',
    'Virginia'
  ]
  bookForm: any = new FormGroup({
    insuarance: new FormControl('true',Validators.required),
    amount: new FormControl({value:'', disabled:true},Validators.required),
    model: new FormControl({value:'', disabled:true},Validators.required),
    pickupDate: new FormControl('',Validators.required),
    pickupLocation: new FormControl('',Validators.required),
    pickupTime: new FormControl('',Validators.required),
    returnDate: new FormControl('',Validators.required),
    returnLocation: new FormControl('',Validators.required),
    returnTime: new FormControl('',Validators.required)
  });

  addForm: any = new FormGroup({
    brand: new FormControl('',Validators.required),
    fuelType: new FormControl('',Validators.required),
    model: new FormControl('',Validators.required),
    purchaseDate: new FormControl('',Validators.required),
    type: new FormControl('',Validators.required),
    availability: new FormControl('true',Validators.required),
    color: new FormControl('',Validators.required),
    number: new FormControl('',Validators.required),
    price: new FormControl('',Validators.required),
    fuelquantity: new FormControl('',Validators.required)
  });

  fuelTypeList: any = [
    'Petrol',
    'Diesel',
    'CNG',
    'Electric'
  ]

  fuelQuantityList: any = [
    'Full',
    'Half',
    'Quarter',
    'Empty'
  ]

  typeList: any = [
    'Sedan',
    'SUV',
    'Hatchback',
    'Coupe',
    'Convertible',
    'Minivan',
    'Van',
    'Pickup Truck',
    'Wagon',
    'Luxury'
  ]
  selectedId: any;
  isAdmin: boolean = false;
  isUser: boolean = false;

  constructor(private apiservice: ApiServiceService) { }

  ngOnInit(): void {
    let role = JSON.parse(localStorage.getItem('role')!);
    console.log(role);
    let admin = role.filter((item: any) => item == 'ROLE_ADMIN');
    if(admin?.length > 0) {
      this.isAdmin = true;
    }
    else{
      this.isAdmin = false;
    }
    let user = role.filter((item: any) => item == 'ROLE_USER');
    if(user?.length > 0) {
      this.isUser = true;
    }
    else{
      this.isUser = false;
    }
    this.getVehicles();
  }

  getVehicles(){
    this.apiservice.getVehicles().subscribe((res: any) => {
      this.vehicles = res;
    })
  }

  deleteVehicle(vehicle : any){
    this.apiservice.deleteVehicle(vehicle?.id).subscribe((res: any) => {
      console.log(res);
      this.getVehicles();
    })
  }
  

  editVehicle(vehicle: any){
    console.log(vehicle);
    this.selectedFlow = 'edit';

    this.addForm.patchValue({
      brand: vehicle?.brand,
      model: vehicle?.model,
      fuelType : vehicle?.fuelType,
      purchaseDate : vehicle?.purchaseDate,
      type : vehicle?.type,
      color : vehicle?.color,
      number : vehicle?.number,
      price : vehicle?.price,
      fuelquantity : vehicle?.fuelquantity,
      availability : JSON.stringify(vehicle?.availability)
    })
    this.selectedId = vehicle?.id;
    console.log(this.addForm.value);
  }

  bookVehicle(vehicle: any){
    console.log(vehicle);
    this.selectedFlow = 'book';
    // let todayDate be in format yyyy-mm-dd
    let todayDate = new Date().toISOString().slice(0,10);
    // let returnDate be 1 day after todayDate
    let returnDate = new Date(new Date().getTime() + 24 * 60 * 60 * 1000).toISOString().slice(0,10);
    // let pickup time be 1 hour after current time in format hh:mm
    let pickupTime = new Date(new Date().getTime() + 60 * 60 * 1000).toLocaleTimeString().slice(0,5);
    this.selectedId = vehicle?.id;

    this.bookForm.patchValue({
      amount: vehicle?.price,
      model: vehicle?.model,
      pickupDate: todayDate,
      returnDate: returnDate,
      pickupTime: pickupTime,
      returnTime: pickupTime
    })
  }

  updateTransaction(){
    console.log(this.bookForm.value);
    let obj={
      "amount": this.bookForm.value.amount,
      "model": this.bookForm.value.model,
      "insurence": this.bookForm.value.insuarance=="true"?true:false,
      "pickupdate": this.bookForm.value.pickupDate,
      "pickuptime": this.bookForm.value.pickupTime,
      "pickuplocation": this.bookForm.value.pickupLocation,
      "returndate": this.bookForm.value.returnDate,
      "returntime": this.bookForm.value.returnTime,
      "returnlocation": this.bookForm.value.returnLocation
    }

    this.apiservice.bookVehicle(localStorage.getItem('username'),this.selectedId,obj).subscribe((res: any) => {
      console.log(res);
      this.selectedFlow = 'view';
      this.bookForm.reset();
      this.getVehicles();
    })
  }

  addVehicle(){
    let todayDate = new Date().toISOString().slice(0,10);
    this.selectedFlow = 'add';
    this.addForm.patchValue({
      purchaseDate: todayDate
    })
    console.log(this.addForm.value);
  }

  addVehicles(flow: any){
    if(flow == 'add'){
      console.log(this.addForm.value);
      let obj = {
        "availability": this.addForm.value.availability=="true"?true:false,
        "brand": this.addForm.value.brand,
        "color": this.addForm.value.color,
        "fuelquantity": this.addForm.value.fuelquantity,
        "fuelType": this.addForm.value.fuelType,
        "model": this.addForm.value.model,
        "number": this.addForm.value.number,
        "price": this.addForm.value.price,
        "purchaseDate": this.addForm.value.purchaseDate,
        "type": this.addForm.value.type

      }

      this.apiservice.addVehicle(obj).subscribe((res: any) => {
        console.log(res);
        this.selectedFlow = 'view';
        this.addForm.reset();
        this.getVehicles();
      })
    }
    if(flow == 'edit'){
      let obj = {
        "availability": this.addForm.value.availability=="true"?true:false,
        "brand": this.addForm.value.brand,
        "color": this.addForm.value.color,
        "fuelquantity": this.addForm.value.fuelquantity,
        "fuelType": this.addForm.value.fuelType,
        "model": this.addForm.value.model,
        "number": this.addForm.value.number,
        "price": this.addForm.value.price,
        "purchaseDate": this.addForm.value.purchaseDate,
        "type": this.addForm.value.type
      }
      this.apiservice.editVehicle(localStorage.getItem('username'), this.selectedId, obj).subscribe((res: any) => {
        console.log(res);
        this.selectedFlow = 'view';
        this.addForm.reset();
        this.getVehicles();
      })
    }
  }

}
