import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';
import {JwtHelper} from 'angular2-jwt';
import {host} from './host';
import * as SecureLS from 'secure-ls';
import {Utilisateur} from '../models/model.utilisateur';
import {Client} from '../models/model.client';



@Injectable()
export class AuthenticationService {


  private host = host;

  /*private ls = new SecureLS({
    isCompression: false
  });*/

  private jwtToken = null;
  private roles: Array<any>;
  private profiles: Array<any>;
  private rolesParsed: Array<string> = [];
  private profilesParsed: Array<string> = [];
  private imgProfil: string;
  private name: string;
  private cni: string;
  private nom: string;
  private typeUtilisateur: string;
  private prenom: string;
  private idService: number;
  private direction: string;
  private logged: boolean;
  private entiteId: number;
  private entiteName: string;
  private clientId: string;
  private clientName: string;

  private showColis: boolean;
  private showBonRamassages: boolean;
  private showBonRetours: boolean;
  private showBonExpeditions: boolean;
  private showLivreurs: boolean;
  private showRamasseurs: boolean;
  private showFactures: boolean;
  private showDemandes: boolean;
  private showUtilisateurs: boolean;
  private showNews: boolean;
  private showEntites: boolean;
  private showClient: boolean;




  private ls = new SecureLS({
    isCompression: false
  });

  constructor(private  http: HttpClient) {
  }

  public options: {
    headers?: HttpHeaders | {[header: string]: string | string[]},
    observe?: 'body' | 'events' | 'response',
    params?: HttpParams|{[param: string]: string | string[]},
    reportProgress?: boolean,
    responseType?: 'arraybuffer'|'blob'|'json'|'text',
    withCredentials?: boolean,
  };

  login(user: any) {
    return this.http.post(this.host + '/login', { email : user.username,
      password : user.password, typeUtilisateur : 'Utilisateur'}, {observe: 'response'});
  }

  saveToken(jwt: string) {
    this.jwtToken = jwt;
    this.ls.set('token', jwt );
    const jwtHelper = new JwtHelper();
    this.roles = jwtHelper.decodeToken(this.jwtToken).roles;
    this.profiles = jwtHelper.decodeToken(this.jwtToken).profiles;
    console.log("this.profiles " + this.profiles);
    this.name = jwtHelper.decodeToken(this.jwtToken).sub;
    this.cni = jwtHelper.decodeToken(this.jwtToken).cni;
    this.nom = jwtHelper.decodeToken(this.jwtToken).nom;
    this.clientId = jwtHelper.decodeToken(this.jwtToken).clientId;
    this.clientName = jwtHelper.decodeToken(this.jwtToken).clientName;
    this.entiteId = jwtHelper.decodeToken(this.jwtToken).entiteId;
    this.entiteName = jwtHelper.decodeToken(this.jwtToken).entiteName;
    this.typeUtilisateur = jwtHelper.decodeToken(this.jwtToken).typeUtilisateur;
    this.prenom = jwtHelper.decodeToken(this.jwtToken).prenom;
    this.ls.set('name', this.name);
    this.ls.set('cni', this.cni);
    this.ls.set('nom', this.nom);
    this.ls.set('typeUtilisateur', this.typeUtilisateur);
    this.ls.set('prenom', this.prenom);
    this.ls.set('clientId', this.clientId);
    this.ls.set('clientName', this.clientName);
    this.ls.set('entiteId', this.entiteId);
    this.ls.set('entiteName', this.entiteName);

    this.roles.forEach(oneauthority => {
      console.log("oneauthority.authName " +oneauthority);
      this.rolesParsed.push(oneauthority);

    });
    this.profiles.forEach(oneProfile => {
      console.log("oneProfile " +oneProfile);
      this.profilesParsed.push(oneProfile);

    });
    this.ls.set('profiles', this.profiles);

    this.ls.set('roles', JSON.stringify(this.rolesParsed));

    this.ls.set('connected', true);
  }

  getUser(username: string) {
    return this.http.get(this.host + '/getUser?username=' + username, {headers: new HttpHeaders({Authorization: this.getToken()})});
  }

  loadToken() {
    this.jwtToken = this.ls.get('token');
  }

  loadName() {
    this.name = this.ls.get('name');
  }

  loadClientId() {
    this.clientId = this.ls.get('clientId');
  }

  loadClientName() {
    this.clientName = this.ls.get('clientName');
  }

  loadEntiteName() {
    this.entiteName = this.ls.get('entiteName');
  }

  loadEntiteId() {
    this.entiteId = this.ls.get('entiteId');
  }
  loadCni() {
    this.cni = this.ls.get('cni');
  }



  loadTypeUtilisateur() {
    this.typeUtilisateur = this.ls.get('typeUtilisateur');
  }

  loadNom() {
    this.nom = this.ls.get('nom');
  }

  loadPrenom() {
    this.prenom = this.ls.get('prenom');
  }


  getToken() {
    if (this.jwtToken == null) {
      this.loadToken();
    }
    return this.jwtToken;
  }

  getCurrentUtilisateur(){

    const utilisateur = new Utilisateur();
    utilisateur.email = this.getUserName();
    utilisateur.cni = this.getCni();
    utilisateur.typeUtilisateur  = this.getTypeUtilisateur();

    return utilisateur;


  }

  getCurrentClient(){

    const client = new Client();
    client.ice = this.clientId;
    client.nom = this.clientName;
    client.typeUtilisateur  = this.getTypeUtilisateur();
    return client;


  }

  getUserName() {
    if (this.name == null) {
      this.loadName();
    }
    return this.name;
  }

  getEntiteId() {
    if (this.entiteId == null) {
      this.loadEntiteId();
    }
    return this.entiteId;
  }

  getClientId() {
    if (this.clientId == null) {
      this.loadClientId();
    }
    return this.clientId;
  }

  getTypeUtilisateur() {
    if (this.typeUtilisateur == null) {
      this.loadTypeUtilisateur();
    }
    return this.typeUtilisateur;
  }

  getNom() {
    if (this.nom == null) {
      this.loadNom();
    }
    return this.nom;
  }

  getPrenom() {
    if (this.prenom == null) {
      this.loadPrenom();
    }
    return this.prenom;
  }

  getCni() {
    if (this.cni == null) {
      this.loadCni();
    }
    return this.cni;
  }

  getImgProfile() {
    if (this.jwtToken == null) {
      this.loadToken();
    }
    return this.jwtToken;
  }

  isLogged() {
    if (this.ls.get('connected') === true){
      return true;
    }
    else{
      return  false;
    }

  }

  logout() {
    this.jwtToken = null;
    this.name = null;
    this.nom = null;
    this.prenom = null;
    this.cni = null;
    this.entiteName = null;
    this.entiteId = null;
    this.imgProfil = null;
    this.direction = null;
    this.idService = null;
    this.rolesParsed = [];
    this.profiles = [];
    this.profilesParsed = [];
    this.roles = null;
    this.ls.set('connected', false);
    this.ls.removeAll();
  }

  isContainAutorisation(autorisation: string) {

    if (this.rolesParsed == null) {
      this.loadRoles();
    }

    let res = false;
    res = this.rolesParsed.find(a => a.includes (autorisation)) !== '' ?  true : false;
    return res;
  }

  isContainProfile(profile: string) {

    if (this.profilesParsed == null) {
      this.loadProfiles();
    }

    for (const r of this.profilesParsed) {
      if (r === profile) {return true; }
    }
    return false;
  }


  loadRoles() {
    if (this.ls.get('roles') !== '' && this.ls.get('roles') !== null){
      this.roles = JSON.parse(this.ls.get('roles'));
      this.rolesParsed = JSON.parse(this.ls.get('roles'));
    }

  }

  loadProfiles() {
    if (this.ls.get('profiles') !== '' && this.ls.get('profiles') !== null){
      this.profiles = this.ls.get('profiles');
      this.profilesParsed = this.ls.get('profiles');
    }

  }

  getRoles() {
    if (this.rolesParsed == null || this.rolesParsed.length === 0){
      this.loadRoles();
    }
    return this.rolesParsed;
  }

  getProfiles() {
    if (this.profilesParsed == null || this.profilesParsed.length === 0){
      this.loadProfiles();
    }
    return this.profilesParsed;
  }

  isProfileSuperSuperAdmin(){
     return this.isContainProfile('Super Super Admin');
  }

  isProfileSuperAdmin(){
    return this.isContainProfile('Super Admin');
  }

  isProfileAdmin(){
    return this.isContainProfile('Admin');
  }


  isProfileLivreur(){
    return this.isContainProfile('Livreur');
  }

  isProfileRamasseur(){
    return this.isContainProfile('Ramasseur');
  }

  isProfileClient(){
    return this.isContainProfile('Client');
  }



  saveTask(task) {
    console.log(task);
    return this.http.post(this.host + '/tasks', task, {headers: new HttpHeaders({ Authorization : this.jwtToken})});
  }
}
