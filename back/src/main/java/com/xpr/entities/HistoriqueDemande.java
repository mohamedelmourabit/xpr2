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
public class HistoriqueDemande extends Historique implements Serializable  {
	
	
	@ManyToOne
	@JsonIgnore
	private Demande demande;
	
	
	public HistoriqueDemande() {
		
	}


	public Demande getDemande() {
		return demande;
	}


	public void setDemande(Demande demande) {
		this.demande = demande;
	}



	
	
	

}
