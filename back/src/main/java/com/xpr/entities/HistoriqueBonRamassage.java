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
public class HistoriqueBonRamassage extends Historique implements Serializable  {
	
	
	
	@ManyToOne
	@JsonIgnore
	private BonRamassage bonRamassage;
	
	
	
	public HistoriqueBonRamassage() {
		
	}



	public BonRamassage getBonRamassage() {
		return bonRamassage;
	}



	public void setBonRamassage(BonRamassage bonRamassage) {
		this.bonRamassage = bonRamassage;
	}
	
	public static Historique getHistorique(String action,BonRamassage bonRamassage,String cniUtilisateur) {
		Historique historique = new Historique();
		historique.setAction(action);
		
		
		
		historique.setStatut(bonRamassage.getStatut().getLibelle());
		
		Utilisateur user = new Utilisateur(cniUtilisateur);
		historique.setUtilisateur(user);
		return historique;
		
	}

	
	

}
