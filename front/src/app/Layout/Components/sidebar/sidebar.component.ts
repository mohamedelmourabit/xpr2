import {Component, HostListener, OnInit} from '@angular/core';
import {ThemeOptions} from '../../../theme-options';
import {select} from '@angular-redux/store';
import {Observable} from 'rxjs';
import {ActivatedRoute, Router} from '@angular/router';
import {AuthenticationService} from '../../../Services/authentification.service';
import {Autorisation} from '../../../Services/autorisation';



@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
})
export class SidebarComponent implements OnInit {
  public extraParameter: any;

  showColis: boolean;
  showBonRamassages: boolean;
  showBonRetours: boolean;
  showBonExpeditions: boolean;
  showLivreurs: boolean;
  showRamasseurs: boolean;
  showFactures: boolean;
  showFacturesClient: boolean;
  showDemandes: boolean;
  showUtilisateurs: boolean;
  showNews: boolean;
  showEntites: boolean;
  showClient: boolean;
  showContratClient: boolean;
  showContratEntite: boolean;

  constructor(private autorisation: Autorisation,  private router: Router, private  authenticationService: AuthenticationService,
              public globals: ThemeOptions, private activatedRoute: ActivatedRoute) {

  }

  @select('config') public config$: Observable<any>;

  private newInnerWidth: number;
  private innerWidth: number;
  activeId = 'dashboardsMenu';

  toggleSidebar() {
    this.globals.toggleSidebar = !this.globals.toggleSidebar;
  }

  sidebarHover() {
    this.globals.sidebarHover = !this.globals.sidebarHover;
  }

  ngOnInit() {
    setTimeout(() => {
      this.innerWidth = window.innerWidth;
      if (this.innerWidth < 1200) {
        this.globals.toggleSidebar = true;
      }
    });

    this.extraParameter = this.activatedRoute.snapshot.firstChild.data.extraParameter;
    console.log('autorisations ' + JSON.stringify(this.authenticationService.getRoles()));
    console.log('profiles ' + JSON.stringify(this.authenticationService.getProfiles()));
    if (this.authenticationService.getRoles() == null || this.authenticationService.getRoles().length === 0){
      this.router.navigateByUrl('/login');
    } else {

      if( this.authenticationService.isProfileSuperSuperAdmin() ){
        this.showColis = true;
        this.showBonRamassages = true;
        this.showBonRetours = true;
        this.showBonExpeditions = true;
        this.showLivreurs = true;
        this.showRamasseurs = true;
        this.showFactures = true;
        this.showFacturesClient = true;
        this.showDemandes = true;
        this.showUtilisateurs = true;
        this.showNews = true;
        this.showEntites = true;
        this.showClient = true;
        this.showContratClient = true;
        this.showContratEntite = true;
      }

      if( this.authenticationService.isProfileSuperAdmin() ){
        this.showColis = true;
        this.showBonRamassages = true;
        this.showBonRetours = true;
        this.showBonExpeditions = true;
        this.showLivreurs = true;
        this.showRamasseurs = true;
        this.showFactures = true;
        this.showFacturesClient = true;
        this.showDemandes = true;
        this.showClient = true;
        this.showUtilisateurs = true;
        this.showContratClient = true;

      }

      if( this.authenticationService.isProfileAdmin() ){
        this.showColis = true;
        this.showBonRamassages = true;
        this.showBonRetours = true;
        this.showBonExpeditions = true;
        this.showLivreurs = true;
        this.showRamasseurs = true;
        this.showFactures = true;
        this.showFacturesClient = true;
        this.showDemandes = true;
        this.showClient = true;
        this.showUtilisateurs = true;
        this.showContratClient = true;
      }

      if(this.authenticationService.isProfileLivreur() ){
        this.showColis = true;
        this.showBonRetours = true;
        this.showFactures = true;
      }

      if( this.authenticationService.isProfileRamasseur() ){
        this.showColis = true;
        this.showClient = true;
        this.showBonRamassages = true;
      }





    }

  }

  @HostListener('window:resize', ['$event'])
  onResize(event) {
    this.newInnerWidth = event.target.innerWidth;

    if (this.newInnerWidth < 1200) {
      this.globals.toggleSidebar = true;
    } else {
      this.globals.toggleSidebar = false;
    }

  }
}
