import {Agence} from './model.agence';
import {LigneBonExpedition} from './model.ligneBonExpedition';
import {HistoriqueBonRamassage} from './model.historiqueBonRamassage';
import {Utilisateur} from './model.utilisateur';
import {Ramasseur} from './model.ramasseur';
import {Client} from './model.client';
import {Colis} from './model.colis';
import {Facture} from './model.facture';
import {XprBaseModel} from './model.xprBaseModel';

export class BonRamassage extends XprBaseModel{


    nom: string;

    statut: string;

     ramasseur: Ramasseur;

     client: Client;

    refBonLogistique: string;

    dateCreation: Date;

    dateModification: Date;

    depart: Agence;

    destination: Agence;

    colis: Array<Colis> = new Array();


    ligneBonExpeditions: Array<LigneBonExpedition> = new Array();

    historiques: Array<HistoriqueBonRamassage> = new Array();

    creerPar: Utilisateur;

    disabled: boolean;

    agence: Agence;

    agenceDepart: Agence;


  agenceDestination: Agence;

  nbColis: number;

  colisRamasse: number;

  colisExpedie: number;

  colisEnAttente: number;


}
