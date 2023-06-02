import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Customer} from "../model/customer.model";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor(private http : HttpClient) { }

  public getCustomers() : Observable<Array<Customer>> {
    return this.http.get<Array<Customer>>(environment.backendBase+"/customers")
  }

  public searchCustomers(keyword : string) : Observable<Array<Customer>> {
    return this.http.get<Array<Customer>>(environment.backendBase+"/customers/search?keyword="+keyword)
  }

  public saveCustomer(customer : Customer) : Observable<Customer> {
    return this.http.post<Customer>(environment.backendBase+"/customers",customer)
  }

  public deleteCustomer(id : number) : Observable<Customer> {
    return this.http.delete<Customer>(environment.backendBase+"/customers/"+id)
  }

  public updateCustomer(id : number, customer : Customer) : Observable<Customer> {
    return this.http.put<Customer>(environment.backendBase+"/customers/"+id ,customer)
  }
}
