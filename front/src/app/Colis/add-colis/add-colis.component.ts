import {SelectionModel} from '@angular/cdk/collections';
import {
  AfterViewInit,
  ChangeDetectorRef,
  Component,
  HostListener,
  OnInit,
  Output,
  TemplateRef,
  ViewChild
} from '@angular/core';
import {MatTableDataSource} from '@angular/material/table';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {AuthenticationService} from '../../Services/authentification.service';
import {VilleService} from '../../Services/ville.service';
import {ColisService} from '../../Services/colis.service';
import {Produit} from '../../models/model.produit';
import {Colis} from '../../models/model.colis';
import {Utilisateur} from '../../models/model.utilisateur';
import {LigneColis} from '../../models/model.ligneColis';
import {Router} from '@angular/router';
import {Autorisation} from '../../Services/autorisation';
import {MatPaginator} from '@angular/material/paginator';
import {MatSort} from '@angular/material/sort';
import {Ville} from '../../models/model.ville';
import {StatutColis} from '../../models/model.statutColis';
import {Commentaire} from '../../models/model.commentaire';
import {HistoriqueColis} from '../../models/model.historiqueColis';
import {NgxDrpOptions, PresetItem, Range} from 'ngx-mat-daterange-picker';
import {MatCalendar} from '@angular/material/datepicker';
//import {Moment} from 'moment';
import * as moment from "moment";


@Component({
  selector: 'app-add-colis',
  templateUrl: './add-colis.component.html',
  styleUrls: ['./add-colis.component.sass']
})
export class AddColisComponent implements OnInit {

  isLoading = true;
  public isFilterCollapsed = true;
  
  currentColis: Colis;
  
  errorForm: boolean;
  errorMessage: string;

  showColis: boolean;
  writeColis: boolean;

  villes = new Array<Ville>();

  selectedVille: any;

  coliss = new Array<Colis>();

  mode: number;

  @Output() isAdded : boolean  = false;


  
  constructor(private ref: ChangeDetectorRef, private autorisation: Autorisation, private router: Router,
    private colisService: ColisService, private villeService: VilleService,
    private authenticationService: AuthenticationService, private modalService: NgbModal){

}


  ngOnInit() {
    this.chargerVilles();
  }

  chargerVilles() {
    this.villeService.getVilles().subscribe(
        (data: any) => {
          this.villes = data;

        }
    );
  }

  openLarge(content) {
    this.modalService.open(content, {
      size: 'lg'
    });
  }


  ajouterColis(colisFormulaire){

    console.log('colisForm ' + JSON.stringify(colisFormulaire));

    let colis = new Colis();
    colis.creerPar = this.authenticationService.getCurrentUtilisateur();
    colis.adresse = colisFormulaire.addresse;
    colis.remarque = colisFormulaire.remarque;
    colis.client = this.authenticationService.getCurrentClient();
    colis.createdDate = new Date();
    colis.createdBy = this.authenticationService.getCurrentUtilisateur().email;
    colis.telephone = colisFormulaire.telephone;
    colis.nomComplet = colisFormulaire.destinataire;
    colis.destinataire = colisFormulaire.destinataire;
    colis.idIntern = colisFormulaire.idIntern;
    const v = new Ville();
    v.nom= this.selectedVille;
    colis.villeDestination = v;

    let lc = new LigneColis();

    const produit = new Produit();
    produit.nom = colisFormulaire.produit;
    produit.idIntern = colisFormulaire.idIntern;
    produit.prixOriginale = 1000.00;
    produit.prixVente = 1500.00;

    lc.produit = produit;
    lc.prix = colisFormulaire.prix;
    lc.qte = 1;
    lc.qteLivre = 0;
    lc.qteRetourne = 0;

    colis.ligneColis = new Array<LigneColis>();
    colis.ligneColis.push(lc);

    colis.remarque = colisFormulaire.remarque;
    this.colisService.ajouterColis (colis).subscribe(
        (data: Colis) => {
          this.isAdded = true;
          this.modalService.dismissAll();
          this.errorForm = false;
          this.errorMessage = '';
        },
        err => {
          this.errorForm = true;
          this.errorMessage = err.error.message;
          console.log('error add colis ', err);
        }
    );
  }

 



}
