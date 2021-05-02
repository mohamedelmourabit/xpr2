import { Component, OnInit } from '@angular/core';
import {AuthenticationService} from '../../Services/authentification.service';
import {Router} from '@angular/router';
import {Response} from '@angular/http';
import {HttpRequest} from '@angular/common/http';

@Component({
  selector: 'app-login-boxed',
  templateUrl: './login-boxed.component.html',
  styles: []
})
export class LoginBoxedComponent implements OnInit {

  public mode: number;

    public email: string;

    public password: string;

  constructor(private authenticationService: AuthenticationService, private router: Router) { }

  ngOnInit() {
  }


  onLogin(user){
      this.authenticationService.login(user)
        .subscribe((resp: any) => {
            this.mode = 2;
            const jwtToken = resp.headers.get('authorization');
            this.authenticationService.saveToken(jwtToken);
            this.router.navigateByUrl('/');

            },
            err => {
              this.mode = 1;
              this.authenticationService.logout();
              this.router.navigateByUrl('/login');
            }
        );
  }

}
