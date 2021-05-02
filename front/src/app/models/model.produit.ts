import {Variante} from './model.variante';
import {XprBaseModel} from './model.xprBaseModel';

export class Produit extends XprBaseModel{

     id: number;

     idIntern: string;

     nom: string;

    reference: string;

     nature: string;


     dimension: string;

    prixOriginale: number;

    prixVente: number;

     qte: number;

    emballer: boolean;

     photo: string;

     containVariantes: string;

     marque: string;

     variantes : Array<Variante>;


}
