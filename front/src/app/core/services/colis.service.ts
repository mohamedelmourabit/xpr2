import {Injectable} from '@angular/core';
import {AuthenticationService} from './authentification.service';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {host} from './host';
import {Colis} from '../models/model.colis';
import {Commentaire} from '../models/model.commentaire';

@Injectable()
export class ColisService{

  private host = host;

  constructor(private authenticationService: AuthenticationService, private http: HttpClient){}


  ajouterColis(colis: Colis){

    return this.http.post(this.host + '/colis/saveColis', colis, {headers: new HttpHeaders({'Authorization': this.authenticationService.getToken()})});
  }

  getColis(numCommande: string){
    return this.http.get(this.host + '/colis' + numCommande, {headers: new HttpHeaders({'Authorization': this.authenticationService.getToken()})});
  }

  getHistoriques(numCommande: string){
    return this.http.get(this.host + '/colis/historiques/' + numCommande, {headers: new HttpHeaders({'Authorization': this.authenticationService.getToken()})});
  }

  getCommentaires(numCommande: string){
    return this.http.get(this.host + '/colis/commentaires/' + numCommande, {headers: new HttpHeaders({'Authorization': this.authenticationService.getToken()})});
  }

  addCommentaire(numCommande: string, commentaire: Commentaire){
    return this.http.post(this.host + '/colis/addCommentaire/' + numCommande, commentaire, {headers: new HttpHeaders({'Authorization': this.authenticationService.getToken()})});
  }

  deleteCommentaire(idCommentaire: number){
    return this.http.delete(this.host + '/colis/deleteCommentaire/' + idCommentaire, {headers: new HttpHeaders({'Authorization': this.authenticationService.getToken()})});
  }

  modifierColis(colis: Colis){
    return this.http.put(this.host + '/colis/update/' + colis.numCommande, colis, {headers: new HttpHeaders({'Authorization': this.authenticationService.getToken()})});
  }

  updateStatutColis(numCommande: string, statutColisId: number ){
    return this.http.put(this.host + '/colis/updateStatutColis?numCommande=' + numCommande + '&statutColisId='+statutColisId ,{headers: new HttpHeaders({'Authorization': this.authenticationService.getToken()})});

  }

  supprimerColis(numCommande: string){
    return this.http.delete(this.host + '/colis/deleteColis/' + numCommande,{headers: new HttpHeaders( { 'Authorization': this.authenticationService.getToken()})});
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

  getColisFilter(filter) {
    return this.http.get(this.host + '/colis/listColis?' + this.toQueryString(filter), {headers: new HttpHeaders({'Authorization': this.authenticationService.getToken()})});
  }


  getColisByMotCle(mc: string, page: number, size: number) {
    return this.http.get(this.host + '/chercherColis?motCle=' + mc + '&size=' + size + '&page=' +page,{headers: new HttpHeaders({'Authorization': this.authenticationService.getToken()})});
  }

  getColisByMotCleAndEntite(mc: string, entiteId: number, page: number, size: number) {
    return this.http.get(this.host + '/chercherColis?entiteId=' + entiteId + '&motCle=' + mc + '&size=' + size +'&page=' +page,{headers: new HttpHeaders({'Authorization': this.authenticationService.getToken()})});
  }


  getColisByLivreurAndEntite(cniLivreur: string, mc: string, entiteId: number, page: number, size: number) {
    return this.http.get(this.host + '/chercherColisByLivreurAndEntitieId?entiteId=' + entiteId + '&cni=' + cniLivreur + '&motCle=' + mc + '&size=' + size +'&page=' +page,{headers: new HttpHeaders({'Authorization': this.authenticationService.getToken()})});
  }

  getColisByClientAndEntite(ice: string, mc: string, entiteId: number, page: number, size: number) {
    return this.http.get(this.host + '/chercherColisByClientAndEntitieId?entiteId= ' + entiteId + '&ice=' + ice + '&motCle=' + mc + '&size=' + size +'&page=' +page,{headers: new HttpHeaders({'Authorization': this.authenticationService.getToken()})});
  }



  getAllStatutColis(){
    return this.http.get(this.host + '/colis/getAllStatutsColis',{headers: new HttpHeaders({'Authorization': this.authenticationService.getToken()})});
  }

}
