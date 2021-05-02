import {Stock} from './model.stock';
import {Variante} from './model.variante';
import {Produit} from './model.produit';
import {Utilisateur} from './model.utilisateur';

export class HistoriqueStock  {

    id: number;

      stock: Stock;

      action: string;

     variante: Variante;

     produit: Produit;

    qte: number;

    creationDate: Date;

    utilisateur: Utilisateur;

}
