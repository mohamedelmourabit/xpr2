import {BrowserModule} from '@angular/platform-browser';
import {ModuleWithProviders, NgModule} from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {NgReduxModule} from '@angular-redux/store';
import {NgRedux, DevToolsExtension} from '@angular-redux/store';
import {rootReducer, ArchitectUIState} from './ThemeOptions/store';
import {ConfigActions} from './ThemeOptions/store/config.actions';
import {AppRoutingModule} from './app-routing.module';
import {LoadingBarRouterModule} from '@ngx-loading-bar/router';

import {CommonModule, CurrencyPipe, registerLocaleData} from '@angular/common';
import {HttpClientModule} from '@angular/common/http';
import {AppComponent} from './app.component';

// BOOTSTRAP COMPONENTS

import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {PerfectScrollbarModule} from 'ngx-perfect-scrollbar';
import {PERFECT_SCROLLBAR_CONFIG} from 'ngx-perfect-scrollbar';
import {PerfectScrollbarConfigInterface} from 'ngx-perfect-scrollbar';
import {ChartsModule} from 'ng2-charts';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
// LAYOUT



import {PageTitleComponent} from './Layout/Components/page-title/page-title.component';

// HEADER

// SIDEBAR






import {ForgotPasswordBoxedComponent} from './UserPages/forgot-password-boxed/forgot-password-boxed.component';
import {LoginBoxedComponent} from './UserPages/login-boxed/login-boxed.component';
import {RegisterBoxedComponent} from './UserPages/register-boxed/register-boxed.component';
import {BaseLayoutComponent} from './Layout/base-layout/base-layout.component';
import {PagesLayoutComponent} from './Layout/pages-layout/pages-layout.component';
import {HeaderComponent} from './Layout/Components/header/header.component';
import {SearchBoxComponent} from './Layout/Components/header/elements/search-box/search-box.component';
import {UserBoxComponent} from './Layout/Components/header/elements/user-box/user-box.component';
import {SidebarComponent} from './Layout/Components/sidebar/sidebar.component';
import {LogoComponent} from './Layout/Components/sidebar/elements/logo/logo.component';
import {FooterComponent} from './Layout/Components/footer/footer.component';
import {AnalyticsComponent} from './Dashboards/analytics/analytics.component';
import { ColisComponent } from './Colis/colis.component';
import { BonsRamassageComponent } from './BonsRamassage/bons-ramassage.component';
import { BonsDeRetourComponent } from './BonsDeRetour/bons-de-retour.component';
import { FacturesComponent } from './Factures/factures.component';
import { LivreursComponent } from './livreurs/livreurs.component';
import { DemandesComponent } from './Demandes/demandes.component';
import {MatTableModule} from '@angular/material/table';
import {MatInputModule} from '@angular/material/input';
import {MatButtonModule} from '@angular/material/button';
import {MatCheckboxModule} from '@angular/material/checkbox';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatRadioModule} from '@angular/material/radio';
import {MatSelectModule} from '@angular/material/select';
import {MatSliderModule} from '@angular/material/slider';
import {MatSlideToggleModule} from '@angular/material/slide-toggle';
import {MatAutocomplete, MatAutocompleteModule} from '@angular/material/autocomplete';
import {MatCommonModule} from '@angular/material/core';
import {TooltipComponent} from '@angular/material/tooltip';
import {CdkScrollable} from '@angular/cdk/overlay';
import {CdkScrollableModule} from '@angular/cdk/scrolling';
import {MatDatepickerModule} from '@angular/material/datepicker';
import { BonExpeditionComponent } from './BonExpedition/bon-expedition.component';
import {AuthenticationService} from './Services/authentification.service';
import {AuthConfig} from 'angular2-jwt';
import {ColisService} from './Services/colis.service';
import {AgenceService} from './Services/agence.service';
import {BonDeRetourService} from './Services/bonDeRetour.service';
import {BonExpeditionService} from './Services/bonExpedition.service';
import {BonRamassageService} from './Services/bonRamassage.service';
import {DemandeService} from './Services/demande.service';
import {FactureService} from './Services/facture.service';
import {HistoriqueService} from './Services/historique.service';
import {LivreurService} from './Services/livreur.service';
import {NewsService} from './Services/news.service';
import {NotificationService} from './Services/notification.service';
import {ProduitService} from './Services/produit.service';
import {VilleService} from './Services/ville.service';
import {TableauDeBordService} from './Services/tableauDeBord.service';
import {ClientService} from './Services/client.service';
import {CommentaireService} from './Services/commentaire.service';
import {NgSelectModule} from '@ng-select/ng-select';
import {MatPaginatorModule} from '@angular/material/paginator';
import {MatSortModule} from '@angular/material/sort';
import {MatProgressSpinnerModule} from '@angular/material/progress-spinner';
import {Autorisation} from './Services/autorisation';
import localeFr from '@angular/common/locales/fr';
import {NgxMatDrpModule} from 'ngx-mat-daterange-picker';
import {NgxDaterangepickerMd} from 'ngx-daterangepicker-material';


registerLocaleData(localeFr, 'fr');

const DEFAULT_PERFECT_SCROLLBAR_CONFIG: PerfectScrollbarConfigInterface = {
  suppressScrollX: true
};

@NgModule({
  declarations: [

    // LAYOUT

    AppComponent,
    BaseLayoutComponent,
    PagesLayoutComponent,
    PageTitleComponent,
    // HEADER

    HeaderComponent,
    SearchBoxComponent,
    UserBoxComponent,




    // SIDEBAR

    SidebarComponent,
    LogoComponent,

    // Dashboards

    AnalyticsComponent,

    // FOOTER

    FooterComponent,


    ForgotPasswordBoxedComponent,
    LoginBoxedComponent,
    RegisterBoxedComponent,
    ColisComponent,
    BonsRamassageComponent,
    BonsDeRetourComponent,
    FacturesComponent,
    LivreursComponent,
    DemandesComponent,
    BonExpeditionComponent


  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    NgReduxModule,
    CommonModule,
    LoadingBarRouterModule,
    // Angular Bootstrap Components
    HttpClientModule,
    PerfectScrollbarModule,
    NgbModule,
    FontAwesomeModule,
    FormsModule,
    ReactiveFormsModule,
    MatTableModule,
    MatPaginatorModule,
    MatButtonModule,
    MatCheckboxModule,
    MatFormFieldModule,
    MatInputModule,
    MatRadioModule,
    MatSliderModule,
    MatSlideToggleModule,
    CdkScrollableModule,
    MatTableModule,
    MatPaginatorModule,
    MatSortModule,
    MatProgressSpinnerModule,
    ChartsModule,
    NgSelectModule,
    NgxDaterangepickerMd.forRoot()
  ],
  providers: [
    {
      provide:
      PERFECT_SCROLLBAR_CONFIG,
      // DROPZONE_CONFIG,
      useValue:
      DEFAULT_PERFECT_SCROLLBAR_CONFIG,
      // DEFAULT_DROPZONE_CONFIG,
    },
    ConfigActions,
    AuthenticationService,
      ColisService,
      AgenceService,
      BonDeRetourService,
      BonExpeditionService,
      BonRamassageService,
      DemandeService,
      FactureService,
      HistoriqueService,
      LivreurService,
      NewsService,
      NotificationService,
      ProduitService,
      VilleService,
      TableauDeBordService,
      ClientService,
      CommentaireService,
      Autorisation,
      CurrencyPipe

  ],
  bootstrap: [AppComponent]
})



export class AppModule {



  constructor(private ngRedux: NgRedux<ArchitectUIState>,
              private devTool: DevToolsExtension) {

    this.ngRedux.configureStore(
      rootReducer,
      {} as ArchitectUIState,
      [],
      [devTool.isEnabled() ? devTool.enhancer() : f => f]
    );

  }
}
