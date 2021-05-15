import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ClientComponent } from './client.component';
import { AddClientComponent } from './add-client/add-client.component';
import { ListClientComponent } from './list-client/list-client.component';
import { MatTableModule } from '@angular/material/table';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { FormsModule } from '@angular/forms';
import { NgbNavModule } from '@ng-bootstrap/ng-bootstrap';



@NgModule({
  declarations: [
    ClientComponent,
    AddClientComponent,
    ListClientComponent
  
  ],
  imports: [
    CommonModule,
    MatTableModule,
    FormsModule,
    FontAwesomeModule,
    NgbNavModule
  ]
})
export class ClientModule { }
