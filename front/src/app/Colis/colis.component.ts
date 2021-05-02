import {SelectionModel} from '@angular/cdk/collections';
import {
    AfterViewInit,
    ChangeDetectorRef,
    Component,
    HostListener,
    OnInit,
    TemplateRef,
    ViewChild
} from '@angular/core';
import {MatTableDataSource} from '@angular/material/table';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {AuthenticationService} from '../Services/authentification.service';
import {VilleService} from '../Services/ville.service';
import {ColisService} from '../Services/colis.service';
import {Produit} from '../models/model.produit';
import {Colis} from '../models/model.colis';
import {Utilisateur} from '../models/model.utilisateur';
import {LigneColis} from '../models/model.ligneColis';
import {Router} from '@angular/router';
import {Autorisation} from '../Services/autorisation';
import {MatPaginator} from '@angular/material/paginator';
import {MatSort} from '@angular/material/sort';
import {Ville} from '../models/model.ville';
import {StatutColis} from '../models/model.statutColis';

import {Commentaire} from '../models/model.commentaire';
import {HistoriqueColis} from '../models/model.historiqueColis';
import {NgxDrpOptions, PresetItem, Range} from 'ngx-mat-daterange-picker';
import {MatCalendar} from '@angular/material/datepicker';
//import {Moment} from 'moment';
import * as moment from "moment";






@Component({
  selector: 'app-colis',
  templateUrl: './colis.component.html',
  styleUrls: ['./colis.component.sass']
})
export class ColisComponent implements  OnInit, AfterViewInit {

    isLoading = true;
    public isFilterCollapsed = true;
    filtredVille: Ville = new Ville();
    filtredStatut: StatutColis = new StatutColis();
    statuts: Array<StatutColis>;
    filtredPage: number;
    pages: Array<number>;
    currentColisHistorique: Array<HistoriqueColis>;
    currentColis: Colis;
    updatedColis: Colis;

    errorForm: boolean;
    errorMessage: string;

    errorUpdateForm: boolean;
    errorUpdateMessage: string;

    errorDeleteForm: boolean;
    errorDeleteMessage: string;

    errorAddCommentaireForm: boolean;
    errorAddCommentaireMessage: string;

    range: Range = {fromDate: new Date(), toDate: new Date()};
    options: NgxDrpOptions;
    presets: Array<PresetItem> = [];
    @ViewChild(MatCalendar)
    matCalendar: MatCalendar<Date>;

    currentColisCommentaire: Array<Commentaire>;

  showColis: boolean;
  writeColis: boolean;

  villes = new Array<Ville>();

  selectedVille: any;

  coliss = new Array<Colis>();

  mode: number;

  size: number;

  pageSize: number;

  filter: string;

    selectedVilleUpdate: Ville;

    newCommentaire: string;


    pageSizeOptions: number[] = [10, 15, 25, 30];

    currentPage: number;

    selectColis: Colis;

    selectedPeriode: {start: any, end: any};

  displayedColumns: string[] = ['select', 'createdDate', 'numCommande',	'statut', 'codeEnvoi',	'idIntern', 'destinataire',
    'telephone', 'villeDestination.nom', 'ligneColis[0].prix', 'ligneColis[0].produit.nom', 'outils'];

    params = {  };

  dataSource = new MatTableDataSource<Colis>();
  selection = new SelectionModel<Colis>(true, []);
    @ViewChild('pagination', {static: true}) paginator: MatPaginator;

    @ViewChild(MatSort, {static: true}) sort: MatSort;


    @HostListener('matSortChange', ['$event'])
    sortChange(e) {
        // save cookie with table sort data here
        console.log('Sort' + JSON.stringify(e));

        if (e.direction !== ''){
           this.params['sortColumn'] = e.active;
           this.params['sortOrder'] = e.direction.toUpperCase();

        }else{
            this.params['sortColumn'] = null;
            this.params['sortOrder'] = null;
        }

        console.log('params ' + JSON.stringify(this.params));

        this.colisService.getColisFilter(this.params).subscribe(
            (data: any) => {
                this.coliss = data.content;
                this.size = data.totalElements;
                console.log('colis ' + JSON.stringify(this.coliss[0].villeDestination.nom));
                this.dataSource = new MatTableDataSource<Colis>(this.coliss);
                this.dataSource.sort = this.sort;
                this.ref.detectChanges();
            });





    }

    ngAfterViewInit() {

        this.dataSource.paginator = this.paginator;
    }

    onPaginateChange(event) {
        console.log('onPaginateChangeevent ');
        this.currentPage = event.pageIndex + 1;
        this.pageSize = event.pageSize;
        this.chargerColis();
    }

  /** Whether the number of selected elements matches the total number of rows. */
  isAllSelected() {
    const numSelected = this.selection.selected.length;
    const numRows = this.dataSource.data.length;
    return numSelected === numRows;
  }

  /** Selects all rows if they are not all selected; otherwise clear selection. */
  masterToggle() {
    this.isAllSelected() ?
        this.selection.clear() :
        this.dataSource.data.forEach(row => this.selection.select(row));
  }

  /** The label for the checkbox on the passed row */
  checkboxLabel(row?: Colis): string {
    if (!row) {
      return `${this.isAllSelected() ? 'select' : 'deselect'} all`;
    }
    return `${this.selection.isSelected(row) ? 'deselect' : 'select'} row ${row.numCommande + 1}`;
  }


  constructor(private ref: ChangeDetectorRef, private autorisation: Autorisation, private router: Router,
              private colisService: ColisService, private villeService: VilleService,
              private authenticationService: AuthenticationService, private modalService: NgbModal){

  }

  openLarge(content) {
    this.modalService.open(content, {
      size: 'lg'
    });
  }

  ngOnInit() {
      this.pages = new Array<number>();
      this.pages.push(5);this.pages.push(10); this.pages.push(15);


      const today = new Date();
      const fromMin = new Date(today.getFullYear(), today.getMonth()-2, 1);
      const fromMax = new Date(today.getFullYear(), today.getMonth()+1, 0);
      const toMin = new Date(today.getFullYear(), today.getMonth()-1, 1);
      const toMax = new Date(today.getFullYear(), today.getMonth()+2, 0);
      this.selectedVilleUpdate = new Ville();
      this.selectedVilleUpdate.nom = 'FES';
      this.options = {
          presets: this.presets,
          format: 'mediumDate',
          range: {fromDate: today, toDate: today},
          applyLabel: 'Submit',
          calendarOverlayConfig: {
              shouldCloseOnBackdropClick: false,
              hasBackdrop: false
          }
          // cancelLabel: "Cancel",
          // excludeWeekends:true,
          // fromMinMax: {fromDate:fromMin, toDate:fromMax},
          // toMinMax: {fromDate:toMin, toDate:toMax}
      };
      this.pageSize = 10;

      this.chargerStatutColis();
      this.chargerVilles();
      this.chargerColis();
  }

  chargerVilles() {
    this.villeService.getVilles().subscribe(
        (data: any) => {
          this.villes = data;

        }
    );
  }

   chargerStatutColis() {
        this.colisService.getAllStatutColis().subscribe(
            (data: any) => {
                this.statuts = data;
            }
        );
    }

    getHistoriqueColis(numCommande: string) {
        this.colisService.getHistoriques(numCommande).subscribe(
            (data: any) => {
                this.currentColisHistorique = data;
            }
        );
    }

    getCommentairesColis(numCommande: string) {
        this.colisService.getCommentaires(numCommande).subscribe(
            (data: any) => {
                this.currentColisCommentaire = data;
            }
        );
    }

    deleteCommentairesColis(idCommentaire: number) {
        this.colisService.deleteCommentaire(idCommentaire).subscribe(
            (data: any) => {
                this.getCommentairesColis(this.currentColis.numCommande);
            }
        );
    }

  chargerColis( ) {



    if (!this.params){
        this.params = {};
    }

    this.colisService.getColisFilter(this.params).subscribe(
          (data: any) => {
              this.coliss = data.content;
              this.size = data.totalElements;
              this.isLoading = false;
              this.dataSource = new MatTableDataSource<Colis>(this.coliss);
              this.dataSource.sort = this.sort;
              this.ref.detectChanges();
              this.errorForm = false;
              this.errorMessage = '';
          },
         (error: any) => {
              this.errorForm = true;
              this.errorMessage = error;
              this.isLoading = false;
        });



  }

  ajouterColis(colisFormulaire){

    console.log('colisForm ' + JSON.stringify(colisFormulaire));

    const colis = new Colis();
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

    const lc = new LigneColis();

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
          this.chargerColis();
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

  modifierColis(colis1: Colis){


    console.log('updatedColis ' + JSON.stringify(this.updatedColis));
    colis1 = this.updatedColis;
    colis1.lastModifiedDate = new Date();
    colis1.lastModifiedBy  = this.authenticationService.getCurrentUtilisateur().email;


    this.colisService.modifierColis(colis1).subscribe(
        (data: Colis) => {
            this.errorUpdateForm=false;
            this.errorUpdateMessage = '';
            this.chargerColis();
            this.modalService.dismissAll();
        },
        err => {
            this.errorUpdateForm=true;
            this.errorUpdateMessage=err.error.message;

            console.log("error add colis ", err);
        }
    );
  }


  showDetails(row) {
  }

  editItem(row) {

  }

  deleteItem(row) {

  }

  selectedElement(element, template: any) {
  }

  selectedColis(colis: Colis, template: TemplateRef<any>){
        this.selectColis = colis;
        this.currentColis = colis;
        this.getHistoriqueColis(colis.numCommande);

        this.getCommentairesColis(colis.numCommande);



        console.log(
            'this.selectColis ' + JSON.stringify(this.selectColis)
        );

        this.modalService.open(template, {
            size: 'lg'
        });
        this.ref.detectChanges();


    }

    showModalDeleteColis(colis: Colis, template: TemplateRef<any>){
        this.currentColis = colis;
        this.errorDeleteForm=false;
        this.errorDeleteMessage='';
        this.modalService.open(template, {
            size: 'lg'
        });
        this.ref.detectChanges();
    }

    showModalModifierColis(colis: Colis, template: TemplateRef<any>){
        this.errorUpdateMessage = '';
        this.errorUpdateForm = false;
        this.updatedColis = colis;
        console.log(JSON.stringify(this.updatedColis));
        this.modalService.open(template, {
            size: 'lg'
        });
        this.ref.detectChanges();
    }


    deleteColis(numCommande: string , template: TemplateRef<any>){
        this.colisService.supprimerColis (numCommande).subscribe(
            (data: any) => {
                this.modalService.dismissAll();
                this.errorDeleteForm = false;
                this.errorDeleteMessage = '';
                this.chargerColis();
            },
            (error: any) => {
                console.log("error " + JSON.stringify(error));
                this.errorDeleteForm = true;
                this.errorDeleteMessage = error.error.message;
        }
        );

        this.ref.detectChanges();
    }

    addCommentairesColis(numCommande: string){
       console.log('Commentaire ' + this.newCommentaire);
       const commentaire = new Commentaire();
       commentaire.utilisateur = this.authenticationService.getCurrentUtilisateur();
       commentaire.createdBy = this.authenticationService.getCurrentUtilisateur().email;
       commentaire.createdDate = new Date();

       commentaire.commentaire = this.newCommentaire;
       const c = new Colis();
       c.numCommande = this.currentColis.numCommande;
       commentaire.colis = c;
       //this.newCommentaire = null;

       console.log(' commentaire ' + JSON.stringify(commentaire));

       this.colisService.addCommentaire(numCommande, commentaire).subscribe(
            (data: any) => {
                //this.modalService.dismissAll();
                this.errorAddCommentaireForm = false;
                this.errorAddCommentaireMessage = '';
                this.getCommentairesColis(numCommande);
            },
            (error: any) => {
                this.errorAddCommentaireForm = true;
                this.errorAddCommentaireMessage = error;
            }
        );


    }

    ajouterMultipleColis(value){

    }


    updatedFiltre(column: string, value: any) {
      this.isLoading = true;

      console.log('column '+ column);

      if(column=== 'periode'){
          if(value.start!=null && value.end!=null){
              value = moment(value.start).format('YYYY-MM-DD') + 'TO' + moment(value.end).format('YYYY-MM-DD');

          }
       }

       if(value!=null && value !== undefined && value!==''){
           console.log('value!=null ' + value);
           this.params[column] = value;
       }else{
           console.log('delete ' + column);
           this.params[column] = null;
       }

       console.log('filtre '+ JSON.stringify(this.params));

       this.colisService.getColisFilter(this.params).subscribe(
            (data: any) => {
                this.coliss = data.content;
                this.size = data.totalElements;
                this.isLoading = false;
                this.dataSource = new MatTableDataSource<Colis>(this.coliss);
                this.dataSource.sort = this.sort;
                this.ref.detectChanges();
            });
    }
}
