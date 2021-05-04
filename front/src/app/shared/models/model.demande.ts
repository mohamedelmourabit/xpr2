import {Client} from './model.client';
import {Utilisateur} from './model.utilisateur';
import {Entite} from './model.entite';
import {XprBaseModel} from './model.xprBaseModel';

export class Demande extends XprBaseModel{

     nom: string;

      type: string;

     departement: string;

     objet: string;

     priorite: string;

     statut: string;

     evaluation: number;

     dateCreation: Date;

    dateModification: Date;

     disabled: boolean;

     client: Client;
     creerPar: Utilisateur;
     modifierPar: Utilisateur;

    resolu: boolean;

    entite: Entite;

}
