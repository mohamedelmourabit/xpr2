import {Utilisateur} from './model.utilisateur';
import {Colis} from './model.colis';
import {BonRamassage} from './model.bonRamassage';
import {Ville} from './model.ville';
import {XprBaseModel} from './model.xprBaseModel';

export class Ramasseur extends  Utilisateur{

      nom: string;

     prenom: string;

     telephone: string;


   colis: Array<Colis> = new Array<Colis>();

    bonRamassages: Array<BonRamassage> = new Array<BonRamassage>();


    villes: Array<Ville> = new Array<Ville>();


}
