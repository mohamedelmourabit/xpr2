import {Injectable} from '@angular/core';
import {AuthenticationService} from './authentification.service';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {host} from './host';
import {Ville} from '../models/model.ville';

@Injectable()
export class VilleService{

  private host = host;

  constructor(private authenticationService: AuthenticationService, private http: HttpClient){}

  ajouterVille(ville: Ville){

    return this.http.post(this.host + '/ville/villes', ville,{headers: new HttpHeaders({'Authorization': this.authenticationService.getToken()})});
  }

  getVille(id: string){
    return this.http.get(this.host + '/ville/villes/' + id,{headers: new HttpHeaders({'Authorization': this.authenticationService.getToken()})});
  }

  modifierVille(ville: Ville){
    return this.http.put(this.host + '/ville/villes/' + ville.nom, ville.nom,{headers: new HttpHeaders({'Authorization': this.authenticationService.getToken()})});
  }

  supprimerVille(nom: string){
    return this.http.delete(this.host + '/ville/villes/' + nom,{headers: new HttpHeaders({'Authorization': this.authenticationService.getToken()})});
  }

  getVilles(){
    return this.http.get(this.host + '/ville/getAllVilles',{headers: new HttpHeaders({'Authorization': this.authenticationService.getToken()})});
  }

}
