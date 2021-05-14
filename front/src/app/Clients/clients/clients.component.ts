import { Component, OnInit } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Client } from 'src/app/models/model.client';
import { Ville } from 'src/app/models/model.ville';
import { ClientService } from 'src/app/Services/client.service';
import { VilleService } from 'src/app/Services/ville.service';

@Component({
  selector: 'app-clients',
  templateUrl: './clients.component.html',
  styleUrls: ['./clients.component.sass']
})
export class ClientsComponent implements OnInit {

  clients :  Client[]= [];
  villes : Ville[] = [];


  errorForm: boolean;
  errorMessage: string;

  errorUpdateForm: boolean;
  errorUpdateMessage: string;
  constructor(private clientService: ClientService, private villeService: VilleService, private modalService: NgbModal) { }

  ngOnInit(): void {
    this.chargerVilles();
    
    this.clientService.getClient("0").subscribe(
      (data: any) => {
          this.clients = data;
          console.warn("this.clients");
          console.log(this.clients);
      }
  );

  }

  // popin de creation d'un nouveau client
  openLarge(content) {
    this.modalService.open(content, {
      size: 'lg'
    });
  }

  chargerVilles() {
    this.villeService.getVilles().subscribe(
        (data: any) => {
          this.villes = data;

        }
    );
  }

  ajouterClient(clientForm){
    console.warn('clientForm');
    console.log(clientForm);
    let client = new Client();
    client.nom = clientForm.nom;
    client.telephone = clientForm.telephone;
    client.typeClient = client.typeClient;
   
    this.clientService.ajouterClient(client).subscribe(
      (data: Client) => {
        this.modalService.dismissAll();
        this.errorForm = false;
        this.errorMessage = '';
      },
      err => {
        this.errorForm = true;
            console.error('error add client ', err);
      }
  );
  }
}
