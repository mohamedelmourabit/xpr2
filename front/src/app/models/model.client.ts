import {Utilisateur} from './model.utilisateur';
import {Contrat} from './model.contrat';
import {Colis} from './model.colis';
import {BonRetour} from './model.bonRetour';
import {BonRamassage} from './model.bonRamassage';
import {Stock} from './model.stock';
import {Entite} from './model.entite';
import {XprBaseModel} from './model.xprBaseModel';

export class Client extends XprBaseModel{

     ice: string;
     nom: string;
     contact: string;
     telephone: string;
     prefixCommande: string;
     address: string;
     disabled: boolean;
     typeUtilisateur: string;
     typeClient: string;
     contrat: Contrat;
     colis: Array<Colis> = new Array<Colis>();
     bonRetours: Array<BonRetour> = new Array<BonRetour>();

     bonRamassages: Array<BonRamassage> = new Array<BonRamassage>();

     stocks: Array<Stock> = new Array<Stock>();

     entite: Entite;

}
