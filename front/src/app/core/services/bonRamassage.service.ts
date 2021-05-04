import {Injectable} from '@angular/core';
import {AuthenticationService} from './authentification.service';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {host} from './host';
import {BonRamassage} from '../models/model.BonRamassage';

@Injectable()
export class BonRamassageService{

  private host = host;

  constructor(private authenticationService: AuthenticationService, private http: HttpClient){}

  ajouterBonRamassage(bonRamassage: BonRamassage){

    return this.http.post(this.host + '/bonRamassage/bonRamassages', bonRamassage,{headers: new HttpHeaders({'Authorization': this.authenticationService.getToken()})});
  }

  getBonRamassage(nom: string){
    return this.http.get(this.host + '/bonRamassage/bonRamassages/' + nom,{headers: new HttpHeaders({'Authorization': this.authenticationService.getToken()})});
  }

  modifierBonRamassage(bonRamassage: BonRamassage){
    return this.http.put(this.host + '/bonRamassage/editBonRamassage/' + bonRamassage.nom, bonRamassage,{headers: new HttpHeaders({'Authorization': this.authenticationService.getToken()})});
  }

  supprimerBonRamassage(nom: string){
    return this.http.delete(this.host + '/bonRamassage/deleteBonRamassage/' + nom,{headers: new HttpHeaders({'Authorization': this.authenticationService.getToken()})});
  }

  getAllStatutsBonRamassages(){
    return this.http.get(this.host + '/bonRamassage/getAllStatutsBonRamassage',{headers: new HttpHeaders({'Authorization': this.authenticationService.getToken()})});
  }

  getBonRamassageFilter(filter) {
    return this.http.get(this.host + '/bonRamassage/listBonRamassages?' + this.toQueryString(filter), {headers: new HttpHeaders({'Authorization': this.authenticationService.getToken()})});
  }

  private toQueryString(query): string {
    const parts = [];
    for (const property in query ) {
      const value = query[property];
      if (value != null && value !== undefined) {
        parts.push(encodeURIComponent(property) + '=' + encodeURIComponent(value));
      }
    }

    return parts.join('&');
  }

}
