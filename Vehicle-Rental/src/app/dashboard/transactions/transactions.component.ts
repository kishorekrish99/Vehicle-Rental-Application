import { Component, OnInit } from '@angular/core';
import { ApiServiceService } from 'src/app/api-service.service';

@Component({
  selector: 'app-transactions',
  templateUrl: './transactions.component.html',
  styleUrls: ['./transactions.component.css']
})
export class TransactionsComponent implements OnInit {

  transactions: any;
  constructor(private apiservice: ApiServiceService) { }

  ngOnInit(): void {
    let resp = this.apiservice.getalltransactions();
    resp.subscribe((data) => this.transactions = data);
  }

}
