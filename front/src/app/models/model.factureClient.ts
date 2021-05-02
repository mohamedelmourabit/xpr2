import {LigneFacture} from './model.ligneFacture';
import {Utilisateur} from './model.utilisateur';
import {Livreur} from './model.liveur';
import {Client} from './model.client';
import {Entite} from './model.entite';

export class FactureClient{

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

    client: Client;

    entite: Entite;

}
