import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { ApiServiceService } from '../api-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  signUpForm:any = new FormGroup({
    username: new FormControl('', Validators.required),
    password: new FormControl('', [Validators.required, Validators.minLength(6)]),
    confirmPassword: new FormControl('', Validators.required),
    email: new FormControl('', Validators.required),
    phone: new FormControl(''),
    address1: new FormControl(''),
    address2: new FormControl(''),
    age: new FormControl(''),
    zipcode: new FormControl(''),
    town: new FormControl('')
  })

  cardtypelist: any = [
    'Visa',
    'Master Card'
  ]

  constructor(private apiService: ApiServiceService, private router: Router) { }

  ngOnInit(): void {
  }

  signUp() {
    if(this.signUpForm.invalid) {
      return;
    }
    else{
      if(this.signUpForm.value.password != this.signUpForm.value.confirmPassword) {
        alert("Password and Confirm Password must be same");
        return;
      }
      else{
        localStorage.removeItem('token');
        let obj = {
          username: this.signUpForm.value.username,
          password: this.signUpForm.value.password,
          email: this.signUpForm.value.email,
          roles:[ "ROLE_USER" ],
          mobile: this.signUpForm.value.phone || null,
          address1: this.signUpForm.value.address1 || null,
          address2: this.signUpForm.value.address2 || null,
          age: this.signUpForm.value.age || null,
          postcode: this.signUpForm.value.zipcode || null,
          enabled: 1,
          town: this.signUpForm.value.town || null
      }
      this.apiService.signup(obj).subscribe((res: any) => {
        console.log(res);
        if(res.status == 200 || res.status == 201) {
          alert(res?.body?.message);
          this.router.navigate(['/login']);
        }
      });
      }
    }
  }

}
