import {Facture} from './model.facture';
import {LigneColis} from './model.ligneColis';
import {XprBaseModel} from './model.xprBaseModel';

export class LigneFacture extends XprBaseModel{

    id: number;

    libelle: string;

     facture: Facture;

    ligneColis: LigneColis;

     qte: number;

    prixFacture: number;

}
