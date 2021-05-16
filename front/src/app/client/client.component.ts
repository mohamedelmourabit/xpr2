import { Component, OnInit } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Client } from '../models/model.client';
import { Ville } from '../models/model.ville';
import { ClientService } from '../Services/client.service';
import { VilleService } from '../Services/ville.service';

@Component({
  selector: 'app-client',
  templateUrl: './client.component.html',
  styleUrls: ['./client.component.sass']
})
export class ClientComponent implements OnInit {
  clients :  Client[]= [];
  villes : Ville[] = [];


  errorForm: boolean;
  errorMessage: string;

  errorUpdateForm: boolean;
  errorUpdateMessage: string;

  // 
  loading = false;
  modal = false;
  constructor(private clientService: ClientService,
     private villeService: VilleService,
     private modalService: NgbModal
     ) { }

  ngOnInit(): void {
    this.chargerVilles();
    this.loading = true;
    this.clientService.getClient("0").subscribe(
      (data: any) => {
          this.clients = data;
      }).add(() => {
        setTimeout(() => {
          this.loading = false;
        }, 0);
      });

  }
  chargerVilles() {
    this.villeService.getVilles().subscribe(
        (data: any) => {
          this.villes = data;

        }
    );
  }
}
