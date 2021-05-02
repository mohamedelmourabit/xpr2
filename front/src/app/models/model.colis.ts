import {Ville} from './model.ville';
import {Facture} from './model.facture';
import {BonRamassage} from './model.bonRamassage';
import {Client} from './model.client';
import {Livreur} from './model.liveur';
import {Ramasseur} from './model.ramasseur';
import {BonExpedition} from './model.bonExpedition';
import {BonRetour} from './model.bonRetour';
import {HistoriqueColis} from './model.historiqueColis';
import {Commentaire} from './model.commentaire';
import {LigneColis} from './model.ligneColis';
import {Utilisateur} from './model.utilisateur';
import {Variante} from './model.variante';
import {Produit} from './model.produit';
import {Entite} from './model.entite';
import {StatutColis} from './model.statutColis';
import {XprBaseModel} from './model.xprBaseModel';

export class Colis extends XprBaseModel{

     numCommande: string;

   codeEnvoi: string;

     stock: boolean;

     idIntern: string;


     typeLivraison: string;

     nomComplet: string;


     dateRamassage: Date;


     dateLivraison: Date;


    dateCreation: Date;

    dateModification: Date;


     ouvertureColis: boolean;

    applicationFrais: boolean;

    applicationFraisAssurance: boolean;

     remarque: string;

     destinataire: string;

     telephone: string;

    villeDestination: Ville;

    secteur: string;

     adresse: string;

    crbt: number;

     facture: Facture;

     bonRamassage: BonRamassage;


    client: Client;

      livreur: Livreur;

     ramasseur: Ramasseur;

      statut: StatutColis;

     disabled: boolean;

     //business: Business;

    bonExpedition: BonExpedition;

    bonRetour: BonRetour;

    historiques: Array<HistoriqueColis> = new Array();


    commentaires: Array<Commentaire> = new Array();


    ligneColis: Array<LigneColis> = new Array();

    creerPar: Utilisateur;

    modifierPar: Utilisateur;

    produit: Produit;

    variante: Variante;

    facturer: boolean;

    facturerClient: boolean;

    entite: Entite;

}
