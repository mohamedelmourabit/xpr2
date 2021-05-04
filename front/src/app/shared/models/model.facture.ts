import {LigneFacture} from './model.ligneFacture';
import {Utilisateur} from './model.utilisateur';
import {Livreur} from './model.liveur';
import {Client} from './model.client';
import {Entite} from './model.entite';
import {XprBaseModel} from './model.xprBaseModel';

export class Facture extends XprBaseModel{

    name: string;

     totalCrbt: number;

    totalFrais: number;

    totalNet: number;

     nbrColis: number;

    type: string;

     statut: string;

     dateCreation: Date;

     ligneFactures: Array<LigneFacture> = new Array<LigneFacture>();

     disabled: boolean;

    creerPar: Utilisateur;

    livreur: Livreur;

    typeReglement: string;

     statutAvecAgence: string;


    clients: Array<Client> = new Array<Client>();

    entite: Entite;

}
