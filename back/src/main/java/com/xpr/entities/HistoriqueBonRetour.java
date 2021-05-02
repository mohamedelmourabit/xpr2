package com.xpr.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class HistoriqueBonRetour extends Historique implements Serializable  {
	
	
	
	@ManyToOne
	@JsonIgnore
	private BonRetour bonRetour;
	
	
	
	public HistoriqueBonRetour() {
		
	}



	public BonRetour getBonRetour() {
		return bonRetour;
	}



	public void setBonRetour(BonRetour bonRetour) {
		this.bonRetour = bonRetour;
	}


	public static Historique getHistorique(String action,BonRetour bonRetour,String cniUtilisateur) {
		Historique historique = new Historique();
		historique.setAction(action);
		
		
		
		historique.setStatut(bonRetour.getStatut().getLibelle());
		
		Utilisateur user = new Utilisateur(cniUtilisateur);
		historique.setUtilisateur(user);
		return historique;
		
	}
	

	
	

}
