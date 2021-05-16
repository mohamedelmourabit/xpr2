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
export class ColisComponent implements  OnInit{

  loading = true;
  params = {  };
  isLoading = false;
  
  coliss : Colis[]= [];
  size:number;

  constructor( private router: Router,
    private colisService: ColisService, private villeService: VilleService,
    private authenticationService: AuthenticationService, private modalService: NgbModal){
        
}

  ngOnInit() {
      
      this.chargerColis();
  }

  
  chargerColis( ) {



    if (!this.params){
        this.params = {};
    }

    this.colisService.getColisFilter(this.params).subscribe(
          (data: any) => {
              
              this.coliss = data.content;
              console.log("colisColis "  + this.coliss);
              this.loading=false;
              this.size = data.totalElements;
              //this.isLoading = false;
             
          }).add(() => {
            setTimeout(() => {
              this.loading = false;
            }, 0);
          });
    }

    
}
