import {Colis} from './model.colis';
import {Produit} from './model.produit';
import {Variante} from './model.variante';
import {Stock} from './model.stock';
import {BonRetour} from './model.bonRetour';
import {XprBaseModel} from './model.xprBaseModel';

export class LigneColis extends XprBaseModel{

    id: number;

    colis: Colis;

      produit: Produit;

      variante: Variante;

      stock: Stock;

     qte: number;

    qteLivre: number;

     qteRetourne: number;

     bonRetour: BonRetour;

     prix: number;

}
