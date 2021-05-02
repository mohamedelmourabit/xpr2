import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {LoginBoxedComponent} from './UserPages/login-boxed/login-boxed.component';
import {RegisterBoxedComponent} from './UserPages/register-boxed/register-boxed.component';
import {ForgotPasswordBoxedComponent} from './UserPages/forgot-password-boxed/forgot-password-boxed.component';
import {PagesLayoutComponent} from './Layout/pages-layout/pages-layout.component';
import {BaseLayoutComponent} from './Layout/base-layout/base-layout.component';
import {AnalyticsComponent} from './Dashboards/analytics/analytics.component';
import {ColisComponent} from './Colis/colis.component';
import {BonsRamassageComponent} from './BonsRamassage/bons-ramassage.component';
import {BonsDeRetourComponent} from './BonsDeRetour/bons-de-retour.component';
import {DemandesComponent} from './Demandes/demandes.component';
import {FacturesComponent} from './Factures/factures.component';
import {LivreursComponent} from './livreurs/livreurs.component';
import {BonExpeditionComponent} from './BonExpedition/bon-expedition.component';

// DEMO PAGES



const routes: Routes = [
  {
    path: '',
    component: BaseLayoutComponent,
    children: [

      // Dashboads

      // Dashboads

      {path: '', component: AnalyticsComponent, data: {extraParameter: 'dashboardsMenu'}},

      {path: 'colis', component: ColisComponent, data: {extraParameter: 'elementsMenu'}},

      {path: 'bonsRamassages', component: BonsRamassageComponent, data: {extraParameter: 'elementsMenu'}},

      {path: 'bonsRetours', component: BonsDeRetourComponent, data: {extraParameter: 'elementsMenu'}},

      {path: 'bonsExpeditions', component: BonExpeditionComponent, data: {extraParameter: 'elementsMenu'}},

      {path: 'demandes', component: DemandesComponent, data: {extraParameter: 'elementsMenu'}},
      {path: 'factures', component: FacturesComponent, data: {extraParameter: 'elementsMenu'}},
      {path: 'livreurs', component: LivreursComponent, data: {extraParameter: 'elementsMenu'}},
    ]

  },
  {
    path: '',
    component: PagesLayoutComponent,
    children: [

      // User Pages

      {path: 'login', component: LoginBoxedComponent, data: {extraParameter: ''}},
      {path: 'register', component: RegisterBoxedComponent, data: {extraParameter: ''}},
      {path: 'forgot-password', component: ForgotPasswordBoxedComponent, data: {extraParameter: ''}},
    ]
  },
  {path: '**', redirectTo: ''}
];

@NgModule({
  imports: [RouterModule.forRoot(routes,
    {
    scrollPositionRestoration: 'enabled',
    anchorScrolling: 'enabled',
    relativeLinkResolution: 'legacy'
})],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
