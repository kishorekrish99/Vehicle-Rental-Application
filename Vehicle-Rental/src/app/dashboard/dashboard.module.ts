import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomeComponent } from './home/home.component';
import { SideBarComponent } from './side-bar/side-bar.component';
import { HomeDetailsComponent } from './home-details/home-details.component';
import { VehiclesComponent } from './vehicles/vehicles.component';
import { TransactionsComponent } from './transactions/transactions.component';
import { CurrentTransactionsComponent } from './current-transactions/current-transactions.component';
import { UserDetailsComponent } from './user-details/user-details.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { UsersComponent } from './users/users.component';



@NgModule({
  declarations: [
    HomeComponent,
    SideBarComponent,
    HomeDetailsComponent,
    VehiclesComponent,
    TransactionsComponent,
    CurrentTransactionsComponent,
    UserDetailsComponent,
    UsersComponent
  ],
  imports: [
    CommonModule,
    FormsModule, // <-- add this line
    ReactiveFormsModule
  ]
})
export class DashboardModule { }
