import { Component, Input, OnInit } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Client } from 'src/app/models/model.client';
import { ClientService } from 'src/app/Services/client.service';
import { VilleService } from 'src/app/Services/ville.service';

@Component({
  selector: 'app-add-client',
  templateUrl: './add-client.component.html',
  styleUrls: ['./add-client.component.sass']
})
export class AddClientComponent implements OnInit {

  errorForm: boolean;
  errorMessage: string;

  constructor(
    private clientService: ClientService, 
    private villeService: VilleService,
    private modalService: NgbModal) { }

  @Input() content:  Client[];
  ngOnInit(): void {

  }
 
  ajouterClient(clientForm){
    console.warn('clientForm');
    console.log(clientForm);
    let client = new Client();
    client.nom = clientForm.nom;
    client.ice =  clientForm.ice;
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

   // popin de creation d'un nouveau client
   openLarge(content) {
    this.modalService.open(content, {
      size: 'lg'
    });
  }

}
