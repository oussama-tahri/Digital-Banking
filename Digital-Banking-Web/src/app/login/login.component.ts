import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {AuthService} from "../services/auth.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  formlogin! : FormGroup;
  constructor(private fb : FormBuilder, private authService : AuthService, private route : Router) { }

  ngOnInit(): void {
    this.formlogin = this.fb.group({
      username : this.fb.control(""),
      password : this.fb.control("")
    })
  }

  handleLogin() {
    let username = this.formlogin.value.username;
    let password = this.formlogin.value.password;
    this.authService.login(username,password).subscribe({
      next : data => {
        this.authService.loadProfile(data);
        this.route.navigateByUrl("/admin/home")
      },
      error : err => {
        console.log(err);
      }
    })
  }
}
