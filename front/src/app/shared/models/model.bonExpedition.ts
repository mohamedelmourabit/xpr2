import {Agence} from './model.agence';
import {LigneBonExpedition} from './model.ligneBonExpedition';
import {Utilisateur} from './model.utilisateur';
import {Entite} from './model.entite';
import {XprBaseModel} from './model.xprBaseModel';
import {HistoriqueBonExpedition} from './model.historiqueBonExpedition';

export class BonExpedition extends XprBaseModel{

     nom: string;

     statut: string;

    logistique: string;

    refBonLogistique: string;

    dateCreation: Date;

    dateModification: Date;

     depart: Agence;

    destination: Agence;


    ligneBonExpeditions: Array<LigneBonExpedition> = new Array();

    historiques: Array<HistoriqueBonExpedition> = new Array();

    creerPar: Utilisateur;

     disabled: boolean;

     prix: number;

    entite: Entite;


}
