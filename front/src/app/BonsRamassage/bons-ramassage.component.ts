import {ChangeDetectorRef, Component, HostListener, OnInit, TemplateRef, ViewChild} from '@angular/core';
import {Ville} from '../models/model.ville';
import {StatutColis} from '../models/model.statutColis';
import {HistoriqueColis} from '../models/model.historiqueColis';
import {Colis} from '../models/model.colis';
import {NgxDrpOptions, PresetItem, Range} from 'ngx-mat-daterange-picker';
import {MatCalendar} from '@angular/material/datepicker';
import {Commentaire} from '../models/model.commentaire';
import {MatTableDataSource} from '@angular/material/table';
import {SelectionModel} from '@angular/cdk/collections';
import {MatPaginator} from '@angular/material/paginator';
import {MatSort} from '@angular/material/sort';
import {Autorisation} from '../Services/autorisation';
import {Router} from '@angular/router';
import {ColisService} from '../Services/colis.service';
import {VilleService} from '../Services/ville.service';
import {AuthenticationService} from '../Services/authentification.service';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {LigneColis} from '../models/model.ligneColis';
import {Produit} from '../models/model.produit';
import * as moment from 'moment';
import {BonRamassageService} from '../Services/bonRamassage.service';
import {BonRamassage} from '../models/model.bonRamassage';
import {HistoriqueBonRamassage} from '../models/model.historiqueBonRamassage';

@Component({
  selector: 'app-bons-ramassage',
  templateUrl: './bons-ramassage.component.html',
  styleUrls: ['./bons-ramassage.component.sass']
})
export class BonsRamassageComponent implements OnInit {


  isLoading = true;
  public isFilterCollapsed = true;
  filtredVille: Ville = new Ville();
  filtredStatut: StatutColis = new StatutColis();
  statuts: Array<StatutColis>;
  filtredPage: number;
  pages: Array<number>;
  currentColisHistorique: Array<HistoriqueBonRamassage>;
  currentBonRamassage: BonRamassage;
  updatedBonRamassage: BonRamassage;

  errorForm: boolean;
  errorMessage: string;

  errorUpdateForm: boolean;
  errorUpdateMessage: string;

  errorDeleteForm: boolean;
  errorDeleteMessage: string;

  range: Range = {fromDate: new Date(), toDate: new Date()};
  options: NgxDrpOptions;
  presets: Array<PresetItem> = [];
  @ViewChild(MatCalendar)
  matCalendar: MatCalendar<Date>;


  showColis: boolean;
  writeColis: boolean;


  bonRamassages = new Array<BonRamassage>();

  mode: number;

  size: number;

  pageSize: number;

  filter: string;

  pageSizeOptions: number[] = [10, 15, 25, 30];

  currentPage: number;

  selectBonRamassage: BonRamassage;

  selectedPeriode: {start: any, end: any};

  displayedColumns: string[] = ['select', 'createdDate', 'nom',	'statut', 'nbColis','colisRamasse','colisExpedie','colisEnAttente','outils'];

  displayedColumnsColis: string[] = [ 'createdDate', 'numCommande',	'statut','idIntern', 'destinataire',
    'telephone', 'villeDestination.nom', 'ligneColis[0].prix', 'ligneColis[0].produit.nom', 'outils'];


  params = {  };

  dataSource = new MatTableDataSource<BonRamassage>();
  dataSource2 = new MatTableDataSource<Colis>();
  selection = new SelectionModel<BonRamassage>(true, []);
  @ViewChild('pagination', {static: true}) paginator: MatPaginator;

  @ViewChild(MatSort, {static: true}) sort: MatSort;


  currentColis: Colis;
  selectColis: Colis;
  currentColisCommentaire: Array<Commentaire>;


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

    this.chargerBonRamassage();





  }

  ngAfterViewInit() {

    this.dataSource.paginator = this.paginator;
  }

  onPaginateChange(event) {
    console.log('onPaginateChangeevent ');
    this.currentPage = event.pageIndex + 1;
    this.pageSize = event.pageSize;
    this.chargerBonRamassage();
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
  checkboxLabel(row?: BonRamassage): string {
    if (!row) {
      return `${this.isAllSelected() ? 'select' : 'deselect'} all`;
    }
    return `${this.selection.isSelected(row) ? 'deselect' : 'select'} row ${row.nom + 1}`;
  }


  constructor(private ref: ChangeDetectorRef, private autorisation: Autorisation, private router: Router,
              private bonRammassageService: BonRamassageService,private colisService: ColisService,
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
    this.chargerBonRamassage();
  }


  chargerBonRamassage( ) {

    if (!this.params){
      this.params = {};
    }
    this.bonRammassageService.getBonRamassageFilter(this.params).subscribe(
        (data: any) => {
          this.isLoading=false;
          for(const br of data.content){
            let colisRamasse =0;
            let colisLivre =0;
            let colisEnAttente=0;
            let nbColis=0;

            /*for(const coli of br.colis){
              nbColis  = nbColis +1;

              switch (coli.statut.code){
                case 'LIVRE' : colisLivre = colisLivre + 1; break;
                case 'RAMASSE' : colisRamasse = colisRamasse + 1; break;
                case 'EN ATTENTE DE RAMASSAGE' : colisEnAttente = colisEnAttente + 1; break;
                default : break;
              }

            }*/
            br.colisRamasse = colisRamasse;
            br.nbColis = nbColis;
            br.colisEnAttente = colisEnAttente;
            br.colisExpedie = colisLivre;
            this.bonRamassages.push(br);

          }

          console.log("brs " + JSON.stringify(this.bonRamassages));
          this.size = data.totalElements;
          this.dataSource = new MatTableDataSource<BonRamassage>(this.bonRamassages);
          this.dataSource.sort = this.sort;
          this.ref.detectChanges();
        }
        );





  }

  ajouterBonRamassage(bonRamassageFormulaire){

    console.log('colisForm ' + JSON.stringify(bonRamassageFormulaire));

    const br = new BonRamassage();

   /* this.colisService.ajouterColis (colis).subscribe(
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
    )*/
  }

  modifierBonRamassage(bonRamassage1: BonRamassage){


    console.log('updatedColis ' + JSON.stringify(this.updatedBonRamassage));
    /*colis1 = this.updatedColis;
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
    );*/
  }


  showDetails(row) {
  }

  editItem(row) {

  }

  deleteItem(row) {

  }

  selectedElement(element, template: any) {
  }

  selectedBonRamassage(bonRamassage: BonRamassage, template: TemplateRef<any>){
    this.selectBonRamassage = bonRamassage;
    this.currentBonRamassage = bonRamassage;

    console.log(
        'this.selectColis ' + JSON.stringify(this.selectBonRamassage)
    );

    this.modalService.open(template, {
      size: 'lg'
    });
    this.ref.detectChanges();


  }

  showModalDeleteBonRamassage(bonRamassage: BonRamassage, template: TemplateRef<any>){
    this.currentBonRamassage= bonRamassage;
    this.errorDeleteForm=false;
    this.errorDeleteMessage='';
    this.modalService.open(template, {
      size: 'lg'
    });
    this.ref.detectChanges();
  }

  showModalExpedieBonDeRamassage(bonRamassage: BonRamassage, template: TemplateRef<any>){
    this.currentBonRamassage= bonRamassage;
    this.modalService.open(template, {
      size: 'lg'
    });
    this.ref.detectChanges();
  }

  showModalModifierBonDeRamassage(bonRamassage: BonRamassage, template: TemplateRef<any>){
    this.errorUpdateMessage = '';
    this.errorUpdateForm = false;
    this.updatedBonRamassage = bonRamassage;
    console.log(JSON.stringify(this.updatedBonRamassage));
    this.modalService.open(template, {
      size: 'lg'
    });
    this.ref.detectChanges();
  }


  deleteBonRamassage(numCommande: string , template: TemplateRef<any>){
    /*this.bonRamassages.supprimerBonRamassage (numCommande).subscribe(
        (data: any) => {
          this.modalService.dismissAll();
          this.errorDeleteForm = false;
          this.errorDeleteMessage = '';
          this.chargerBonRamassage();
        },
        (error: any) => {
          console.log("error " + JSON.stringify(error));
          this.errorDeleteForm = true;
          this.errorDeleteMessage = error.error.message;
        }
    );*/

    this.ref.detectChanges();
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

    this.chargerBonRamassage();
  }

  expedieBonRamassage(bonRamassage1: BonRamassage){

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

}
