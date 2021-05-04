import {Injectable} from '@angular/core';
import {AuthenticationService} from './authentification.service';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {host} from './host';

@Injectable()
export class TableauDeBordService{

  private host = host;

  constructor(private authenticationService: AuthenticationService, private http: HttpClient){}

  getStatistiques(dateDebutPeriode: string, dateFinPeriode: string){
    return this.http.get(this.host + '/getStatistics?dateDebutPeriode=' + dateDebutPeriode + '&dateDebutPeriode=' + dateFinPeriode,{headers: new HttpHeaders({'Authorization': this.authenticationService.getToken()})});
  }

}
