import {Autorisation} from './model.autorisation';
import {Entite} from './model.entite';
import {XprBaseModel} from './model.xprBaseModel';

export class Profile extends XprBaseModel{

    id: number;

   prflName: string;


    authorities: Array<Autorisation> = new Array();

    entite: Entite;
}
