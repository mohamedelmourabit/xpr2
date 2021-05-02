import {Ramasseur} from './model.ramasseur';
import {Ville} from './model.ville';
import {Colis} from './model.colis';
import {Facture} from './model.facture';
import {Utilisateur} from './model.utilisateur';

export class Livreur extends Utilisateur{

     nom: string;

    prenom: string;

    telephone: string;

    villes: Array<Ville> = new Array<Ville>();

    colis: Array<Colis> = new Array<Colis>();

    factures: Array<Facture> = new Array<Facture>();

}
