import { Component, OnInit } from '@angular/core';
import { ApiServiceService } from 'src/app/api-service.service';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {
  users : any
  constructor(private apiservice: ApiServiceService) { }

  ngOnInit(): void {
    this.getUsers();
  }

  getUsers(){
    this.apiservice.getUsers().subscribe((res: any) => {
      this.users = res;
    })
  }

}
