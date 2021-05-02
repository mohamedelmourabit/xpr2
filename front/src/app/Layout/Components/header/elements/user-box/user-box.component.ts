import {Component, OnInit} from '@angular/core';
import {ThemeOptions} from '../../../../../theme-options';
import {AuthenticationService} from '../../../../../Services/authentification.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-user-box',
  templateUrl: './user-box.component.html',
})
export class UserBoxComponent implements OnInit {

  nom;

  prenom;



  constructor(public globals: ThemeOptions, private authenticationService: AuthenticationService, private router:Router) {
  }

  ngOnInit() {

    if( this.authenticationService.getUserName() === '' ){
      console.log("nulll");
      this.router.navigateByUrl('/login');
    }

    this.nom  = this.authenticationService.getNom();
    this.prenom = this.authenticationService.getPrenom();

  }

  OnDeconnecte(){
    this.authenticationService.logout();
    this.router.navigateByUrl('/login');
  }

}
