import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { ApiServiceService } from 'src/app/api-service.service';

@Component({
  selector: 'app-user-details',
  templateUrl: './user-details.component.html',
  styleUrls: ['./user-details.component.css']
})
export class UserDetailsComponent implements OnInit {
  cards: any;
  users: any;
  username: any = localStorage.getItem('username');
  selectedFlow: any = 'details'
  cardtypelist: any = [
    'Visa',
    'Master Card'
  ];
  addCardForm: any = new FormGroup({
    name: new FormControl('', Validators.required),
    number: new FormControl('', [Validators.required, Validators.minLength(16), Validators.maxLength(16)]),
    month: new FormControl('', Validators.required),
    year: new FormControl('', Validators.required),
    cvv: new FormControl('', [Validators.required, Validators.minLength(3), Validators.maxLength(3)]),
    cardtype: new FormControl('', Validators.required)
  });

  constructor(private apiservice: ApiServiceService) { }

  ngOnInit(): void {
    this.apiservice.getusers().subscribe((data: any) => {
      this.users = data;
    })
    this.getCards();
  }

  getCards() {
    this.apiservice.getCards(this.username).subscribe((data: any) => {
      this.cards = data;
      console.log(this.cards);
    });
  }

  addcards() {
    this.selectedFlow = 'addCard';
  }

  addCard() {
    console.log(this.addCardForm.value);
    if(!this.addCardForm.invalid) {
      let params = {
        "name": this.addCardForm.value.name,
        "number": this.addCardForm.value.number,
        "month": this.addCardForm.value.month,
        "year": this.addCardForm.value.year,
        "cvv": this.addCardForm.value.cvv,
        "cardtype": this.addCardForm.value.cardtype,
        "username": this.username
      }
      this.apiservice.addCard(params).subscribe((data: any) => {
        console.log(data);
        this.addCardForm.reset();
        this.getCards();
        this.selectedFlow = 'details';
      });
    }
    else{
      this.addCardForm.markAllAsTouched();
    }
  }
}
