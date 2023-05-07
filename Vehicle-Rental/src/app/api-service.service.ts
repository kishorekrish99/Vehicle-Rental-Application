import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { CookieService } from 'ngx-cookie-service';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ApiServiceService {

  constructor(private http: HttpClient, private cookieService: CookieService) { }

  login(data: any) {
    let url = environment.base_url + 'api/auth/signin';
    console.log(this.cookieService.getAll())
    // get response with cookies using cookieService
    return this.http.post(url, data, { observe: 'response' });
    
  }

  getVehicles() {
    let url = environment.base_url + 'api/test/vehicles';
    return this.http.get(url);
  }

  getUsers(){
    let url = environment.base_url + 'api/test/users' ;
    return this.http.get(url);
  }

  signup(data: any) {
    let url = environment.base_url + 'api/auth/signup';
    return this.http.post(url, data, { observe: 'response' });
  }

  getTransactions() {
    let url = environment.base_url + 'api/test/rental/active/' + localStorage.getItem('username');
    
    return this.http.get(url);
  }

  getalltransactions() {
    let url = environment.base_url + 'api/test/rental/' +  localStorage.getItem('username');
    
    return this.http.get(url);
  }

  getusers() {
    let url = environment.base_url + 'api/test/users/' +  localStorage.getItem('username');    
    return this.http.get(url);
  }

  bookVehicle(userName: any,vehicleId: any, params: any){
    let url = environment.base_url + 'api/test/book/'+userName+'/'+vehicleId
    return this.http.post(url, params);
  }

  editVehicle(userName: any,vehicleId: any, params: any){
    let url = environment.base_url + 'api/test/vehicles/'+vehicleId
    return this.http.put(url, params);
  }

  addVehicle(params: any){
    let url = environment.base_url + 'api/test/vehicles'
    return this.http.post(url, params);
  }

  deleteVehicle(vehicleId: any){
    let url = environment.base_url + 'api/test/vehicles/'+vehicleId
    return this.http.delete(url);
  }

  getCards(username: any){
    let url = environment.base_url + 'api/test/cards/'+username
    return this.http.get(url);
  }

  returnVehicle(data: any){
    let url = environment.base_url + 'api/test/rental/return/'+ localStorage.getItem('username') + "/" + data?.id;
    return this.http.post(url,data);
  }

  addCard(data: any){
    let url = environment.base_url + 'api/test/cards/'+ localStorage.getItem('username');
    return this.http.post(url,data);
  }
}
