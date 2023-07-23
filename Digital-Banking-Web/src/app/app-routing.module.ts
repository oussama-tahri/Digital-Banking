import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {CustomersComponent} from "./customers/customers.component";
import {AccountsComponent} from "./accounts/accounts.component";
import {NewCustomerComponent} from "./new-customer/new-customer.component";
import {CustomerAccountsComponent} from "./customer-accounts/customer-accounts.component";
import {HomeComponent} from "./home/home.component";
import {EditCustomerComponent} from "./edit-customer/edit-customer.component";
import {LoginComponent} from "./login/login.component";
import {AdminTemplateComponent} from "./admin-template/admin-template.component";
import {AuthenticationGuard} from "./guards/authentication.guard";
import {AuthorizationGuard} from "./guards/authorization.guard";
import {NotAuthComponent} from "./not-auth/not-auth.component";

const routes: Routes = [
  {path : "login", component : LoginComponent},
  {path : "", redirectTo : "/login", pathMatch : "full"},
  {path : "admin", component : AdminTemplateComponent, canActivate : [AuthenticationGuard],
    children : [
      {path: "customers", component : CustomersComponent},
      {path : "accounts", component : AccountsComponent},
      {path : "new-customer", component : NewCustomerComponent, canActivate : [AuthorizationGuard], data : {role : "ADMIN"}},
      {path :"customer-accounts/:id", component : CustomerAccountsComponent , canActivate : [AuthorizationGuard], data : {role : "ADMIN"}},
      { path :"editCustomer", component : EditCustomerComponent , canActivate : [AuthorizationGuard], data : {role : "ADMIN"}},
      { path :"home", component : HomeComponent},
      { path :"404", component : NotAuthComponent},
    ]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
