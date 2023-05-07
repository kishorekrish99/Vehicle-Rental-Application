import { Component, OnInit } from '@angular/core';
import { ApiServiceService } from 'src/app/api-service.service';

@Component({
  selector: 'app-current-transactions',
  templateUrl: './current-transactions.component.html',
  styleUrls: ['./current-transactions.component.css']
})
export class CurrentTransactionsComponent implements OnInit {

  transactions: any;
  constructor(private apiservice: ApiServiceService) { }

  ngOnInit(): void {
    this.getCurrentTransactions();
  }

  //need to work
  returnVehicle(transaction : any){
    this.apiservice.returnVehicle(transaction).subscribe((res: any) => {
      console.log(res)
      this.getCurrentTransactions();
    });
  }

  getCurrentTransactions() {
    this.apiservice.getTransactions().subscribe((res: any) => {
      this.transactions = res;
      console.log(this.transactions);
    });
  }

}
