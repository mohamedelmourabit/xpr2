import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ClientComponent } from './client.component';
import { AddClientComponent } from './add-client/add-client.component';
import { ListClientComponent } from './list-client/list-client.component';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { FormsModule } from '@angular/forms';
import { NgbNavModule } from '@ng-bootstrap/ng-bootstrap';
import { MatSelectModule } from '@angular/material/select';
import { MatFormFieldControl } from '@angular/material/form-field';
import { AppModule } from '../app.module';
import { SharedModule } from '../shared/shared.module';
import { MatCheckboxModule } from '@angular/material/checkbox';



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
    NgbNavModule,
    MatSelectModule,
    FormsModule,
    MatCheckboxModule,
    SharedModule
    ]
})
export class ClientModule { }
