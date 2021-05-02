import {Injectable} from '@angular/core';
import {AuthenticationService} from './authentification.service';
import {HttpClient} from '@angular/common/http';
import {host} from './host';

@Injectable()
export class AgenceService{

  private host = host;

  constructor(private authenticationService: AuthenticationService, private http: HttpClient){}



}
