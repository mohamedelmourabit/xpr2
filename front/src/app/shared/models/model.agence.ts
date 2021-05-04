import {Ville} from './model.ville';
import {Stock} from './model.stock';
import {Entite} from './model.entite';
import { XprBaseModel} from './model.xprBaseModel';

export class Agence extends XprBaseModel{

      id: number;

      nom: string;

      ville: Ville;


      stocks: Array<Stock> = new Array();

      entite: Entite;

}
