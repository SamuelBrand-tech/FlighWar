import { Component, OnInit } from '@angular/core';
import { User } from '../../interfaces/user'
import { RouterExtensions } from "@nativescript/angular/router";

const firebase = require('nativescript-plugin-firebase')

@Component({
  selector: 'ns-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  isLoggingIn = true;
  processing = false;
  singUp = true;
  public user = new User()


  constructor(private routerExtensions: RouterExtensions) { }

  ngOnInit(): void {}

  submit(){
    alert(`Proccesing ${this.user.email} ${this.user.password} ...`)
    firebase.login(
      {
        type: firebase.LoginType.ANONYMOUS
      })
      .then(user => console.log("User uid: " + user.uid))
      .catch(error => console.log("Trouble in paradise: " + error));
  }

  toggleForm() {
    this.isLoggingIn = !this.isLoggingIn;
  }

}
