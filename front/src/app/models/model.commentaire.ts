import {Utilisateur} from './model.utilisateur';
import {Colis} from './model.colis';
import {XprBaseModel} from './model.xprBaseModel';

export class Commentaire extends XprBaseModel{

    id: number;


     commentaire: string;

     colis: Colis;

     utilisateur: Utilisateur;



}
