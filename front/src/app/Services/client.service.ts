import {Injectable} from '@angular/core';
import {AuthenticationService} from './authentification.service';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {host} from './host';
import {Client} from '../models/model.client';

@Injectable()
export class ClientService{

  private host = host;

  constructor(private authenticationService: AuthenticationService, private http: HttpClient){}

  ajouterClient(client: Client){

    return this.http.post(this.host + '/clients', client,{headers: new HttpHeaders({'Authorization': this.authenticationService.getToken()})});
  }

  getClient(ice: string){
    return this.http.get(this.host + '/clients/' + ice,{headers: new HttpHeaders({'Authorization': this.authenticationService.getToken()})});
  }

  modifierClient(client: Client){
    return this.http.put(this.host + '/clients/' + client.ice, client,{headers: new HttpHeaders({'Authorization': this.authenticationService.getToken()})});
  }

  supprimerClient(ice: string){
    return this.http.delete(this.host + '/clients/' + ice,{headers: new HttpHeaders({'Authorization': this.authenticationService.getToken()})});
  }

}
