import {Client} from './model.client';
import {Produit} from './model.produit';
import {Variante} from './model.variante';
import {Agence} from './model.agence';
import {Ville} from './model.ville';
import {LigneColis} from './model.ligneColis';
import {Entite} from './model.entite';

export class Stock{

   id: number;

     client: Client;

    produit: Produit;

    variante: Variante;

     qte: number;

     qteLivre: number;

     qteEnCoursLivraison: number;

     qteNonLivre: number;

      agence: Agence;

      ville: Ville;

    lignesCommandes: Array<LigneColis> = new Array<LigneColis>();

   entite: Entite;

}
