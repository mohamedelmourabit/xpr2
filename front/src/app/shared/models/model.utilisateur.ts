import {NotificationsUtilisateur} from './model.notificationUtilisateur';
import {Client} from './model.client';
import {Entite} from './model.entite';
import {XprBaseModel} from './model.xprBaseModel';

export class Utilisateur extends XprBaseModel{

    ice: string;

   cni: string;

    email: string;

    password: string;

    typeUtilisateur: string;

    nom: string;

    prenom: string;

    telephone: string;

    notifications: Array<NotificationsUtilisateur> = new Array<NotificationsUtilisateur>();

    client: Client;

    entite: Entite;

}
