import {Entite} from './model.entite';
import {XprBaseModel} from './model.xprBaseModel';

export class Autorisation extends XprBaseModel{

     idAuth: number;

     authName: string;

     entite: Entite;
}
