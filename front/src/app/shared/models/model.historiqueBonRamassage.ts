import {Utilisateur} from './model.utilisateur';
import {Colis} from './model.colis';
import {Demande} from './model.demande';
import {BonRamassage} from './model.bonRamassage';
import {BonRetour} from './model.bonRetour';
import {BonExpedition} from './model.bonExpedition';

export class HistoriqueBonRamassage{

     id: number;

    action: string;

    statut: string;

     dateCreation: Date;

     utilisateur: Utilisateur;

     bonRamassage: BonRamassage;



}
