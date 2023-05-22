import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor(private http : HttpClient) { }

  public getCustomers() : Observable<any> {
    return this.http.get("http://localhost:8085/customers")
  }
}
