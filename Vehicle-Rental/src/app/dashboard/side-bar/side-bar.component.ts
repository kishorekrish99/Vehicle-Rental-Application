import { Component, OnInit } from '@angular/core';
import { Output, EventEmitter } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-side-bar',
  templateUrl: './side-bar.component.html',
  styleUrls: ['./side-bar.component.css']
})
export class SideBarComponent implements OnInit {
  @Output() selectedType: any = new EventEmitter<any>();
  selected: any = 'home';
  isAdmin: boolean = false;

  constructor(private router : Router) {
    
   }

  ngOnInit(): void {
    this.selectedType.emit('home');
    let role = JSON.parse(localStorage.getItem('role')!);
    console.log(role);
    let admin = role.filter((item: any) => item == 'ROLE_ADMIN');
    if(admin?.length > 0) {
      this.isAdmin = true;
    }
    else{
      this.isAdmin = false;
    }
  }

  changeType(type: any) {
    this.selectedType.emit(type);
    this.selected = type;
  }

  logout() {
    localStorage.clear();
    this.router.navigate(['/login']);
  }

}
