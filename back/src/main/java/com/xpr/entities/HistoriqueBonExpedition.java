package com.xpr.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class HistoriqueBonExpedition extends Historique implements Serializable  {
	

	@ManyToOne
	@JsonIgnore
	private BonExpedition bonExpedition;
	
	public HistoriqueBonExpedition() {
		
	}


	public BonExpedition getBonExpedition() {
		return bonExpedition;
	}

	public void setBonExpedition(BonExpedition bonExpedition) {
		this.bonExpedition = bonExpedition;
	}
	
	public static Historique getHistorique(String action,BonExpedition bonExpedition,String cniUtilisateur) {
		Historique historique = new Historique();
		historique.setAction(action);
		
		
		
		historique.setStatut(bonExpedition.getStatut().getLibelle());
		
		Utilisateur user = new Utilisateur(cniUtilisateur);
		historique.setUtilisateur(user);
		return historique;
		
	}



}
