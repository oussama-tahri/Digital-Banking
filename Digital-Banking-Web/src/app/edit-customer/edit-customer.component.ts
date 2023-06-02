import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {CustomerService} from "../services/customer.service";
import {Router} from "@angular/router";
import {Customer} from "../model/customer.model";

@Component({
  selector: 'app-edit-customer',
  templateUrl: './edit-customer.component.html',
  styleUrls: ['./edit-customer.component.css']
})
export class EditCustomerComponent implements OnInit {

  editCustomerFormGroup! : FormGroup;
  constructor(private fb : FormBuilder, private customerService : CustomerService, private router : Router) { }

  ngOnInit(): void {
    this.editCustomerFormGroup = this.fb.group({
      id: [null, Validators.required],
      name : this.fb.control(null, [Validators.required , Validators.minLength(4)]),
      email : this.fb.control(null, [Validators.required, Validators.email])
    });
  }

  handleEditCustomer(): void {
    if (this.editCustomerFormGroup.valid) {
      const customer: Customer = this.editCustomerFormGroup.value;
      this.customerService.updateCustomer(customer.id, customer).subscribe({
        next: data => {
          alert('Customer has been edited!');
          this.router.navigateByUrl('/customers');
        },
        error: err => {
          console.log(err);
        }
      });
    }
  }
}
