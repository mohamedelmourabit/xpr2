import {Client} from './model.client';
import {XprBaseModel} from './model.xprBaseModel';

export class Contrat extends XprBaseModel{

    id: number;

     client: Client;

    dateDebut: Date;

     dateFin: Date;

     prixLivraison: number;

     prixAnnulation: number;

}
