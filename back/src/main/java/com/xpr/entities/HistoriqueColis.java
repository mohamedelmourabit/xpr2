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
public class HistoriqueColis extends Historique implements Serializable  {
	
	
	@ManyToOne
	@JsonIgnore
	private Colis colis;
	
	
	public HistoriqueColis() {
		
	}


	public Colis getColis() {
		return colis;
	}


	public void setColis(Colis colis) {
		this.colis = colis;
	}
	
	public static HistoriqueColis getHistorique(String action,Colis colis,String emailUtilisateur) {
		HistoriqueColis historique = new HistoriqueColis();
		historique.setAction(action);
		historique.setDateCreation(new Date());
		
		
		historique.setStatut(colis.getStatut().getLibelle());
		
		Utilisateur user = new Utilisateur(emailUtilisateur);
		historique.setUtilisateur(user);
		return historique;
		
	}

	
	
	

}
