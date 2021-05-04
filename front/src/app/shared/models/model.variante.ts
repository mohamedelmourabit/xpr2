import {Produit} from './model.produit';
import {XprBaseModel} from './model.xprBaseModel';

export class Variante extends XprBaseModel{
    sku: string;

    idIntern: string;

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


    produit: Produit;

}
