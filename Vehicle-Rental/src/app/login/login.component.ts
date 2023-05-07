import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { ApiServiceService } from '../api-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm: any = new FormGroup({
    username: new FormControl('', Validators.required),
    password: new FormControl('', [Validators.required, Validators.minLength(6)])
  })
  constructor(private apiService: ApiServiceService, private router: Router) { }

  ngOnInit(): void {
  }

  login() {
    console.log(this.loginForm.value);
    let obj = {
      username: this.loginForm.value.username,
      password: this.loginForm.value.password
    }
    this.apiService.login(obj).subscribe((res: any) => {
      if(res.status == 200) {

        console.log(res);
        localStorage.setItem('token', res?.body?.token);
        localStorage.setItem('username', res?.body?.username);
        localStorage.setItem('role', JSON.stringify(res?.body?.roles));
        this.router.navigate(['/home']);
      }

    });
  }

  getVehicles() {
    this.apiService.getVehicles().subscribe((res: any) => {
      console.log(res);
    });
  }

}
