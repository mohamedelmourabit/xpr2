import { SelectionModel } from '@angular/cdk/collections';
import { Component, HostListener, Input, OnInit, ViewChild } from '@angular/core';
import { MatCalendar } from '@angular/material/datepicker';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { NgxDrpOptions, PresetItem } from 'ngx-mat-daterange-picker';
import { Client } from 'src/app/models/model.client';
import { Colis } from 'src/app/models/model.colis';
import { Commentaire } from 'src/app/models/model.commentaire';
import { HistoriqueColis } from 'src/app/models/model.historiqueColis';
import { StatutColis } from 'src/app/models/model.statutColis';
import { Ville } from 'src/app/models/model.ville';

@Component({
  selector: 'app-list-client',
  templateUrl: './list-client.component.html',
  styleUrls: ['./list-client.component.sass']
})
export class ListClientComponent implements OnInit {

  @Input() clients:  Client[];
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

  // Srange: Range = {fromDate: new Date(), toDate: new Date()};
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

dataSource = new MatTableDataSource<Client>();
selection = new SelectionModel<Colis>(true, []);
  @ViewChild('pagination', {static: true}) paginator: MatPaginator;

  @ViewChild(MatSort, {static: true}) sort: MatSort;

  constructor() { }

  ngOnInit(): void {

    this.dataSource = new MatTableDataSource<Client>(this.clients);
    console.warn('clients recu');
    console.log(this.clients);
    console.log(this.dataSource);
  }

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
  }


}
