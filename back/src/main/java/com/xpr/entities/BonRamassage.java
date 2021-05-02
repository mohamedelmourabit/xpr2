package com.xpr.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.xpr.dao.core.view.ModelViews;
import com.xpr.dao.helper.XprBaseModel;

@Entity
@Table(name = "bonRamassages")
public class BonRamassage extends XprBaseModel implements Serializable {
	
	@Id 
	@GenericGenerator(name = "bonRamassage_nom", strategy = "com.xpr.generator.BonRamassageGenerator")
    @GeneratedValue(generator = "bonRamassage_nom")
	@JsonView(ModelViews.SelectView.class)
	private String nom;
	
	
	@ManyToOne
	@JsonView(ModelViews.ListView.class)
	private Ramasseur ramasseur;
	
	@ManyToOne
	@JsonView(ModelViews.SelectView.class)
	private Client client;
	
	@OneToMany(mappedBy = "bonRamassage",fetch = FetchType.EAGER)
	private Set<Colis> colis;
	
	
	@ManyToOne
	@JsonIgnore
	private Facture facture;
	
	@ManyToOne
	@JsonView(ModelViews.SelectView.class)
	private StatutBonRamassage statut;
	
	@JsonIgnore
	private boolean disabled;
	
	@OneToMany(mappedBy = "bonRamassage",fetch = FetchType.EAGER)
	private Set<HistoriqueBonRamassage> historiques;
	
	@ManyToOne
	@JsonView(ModelViews.SelectView.class)
	private Agence agence;
	
	@ManyToOne
	@JsonView(ModelViews.SelectView.class)
	private Agence agenceDepart;
	
	@ManyToOne
	@JsonView(ModelViews.SelectView.class)
	private Agence agenceDestination;
	
	@ManyToOne
	@JsonView(ModelViews.SelectView.class)
	private Entite entite;
	
	public BonRamassage() {
		
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	

	

	public Ramasseur getRamasseur() {
		return ramasseur;
	}

	public void setRamasseur(Ramasseur ramasseur) {
		this.ramasseur = ramasseur;
	}

	
	public Set<HistoriqueBonRamassage> getHistoriques() {
		return historiques;
	}

	public void setHistoriques(Set<HistoriqueBonRamassage> historiques) {
		this.historiques = historiques;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Set<Colis> getColis() {
		return colis;
	}

	public void setColis(Set<Colis> colis) {
		this.colis = colis;
	}

	public Facture getFacture() {
		return facture;
	}

	public void setFacture(Facture facture) {
		this.facture = facture;
	}


	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

	

	public Agence getAgence() {
		return agence;
	}

	public void setAgence(Agence agence) {
		this.agence = agence;
	}

	public Agence getAgenceDepart() {
		return agenceDepart;
	}

	public void setAgenceDepart(Agence agenceDepart) {
		this.agenceDepart = agenceDepart;
	}

	public Agence getAgenceDestination() {
		return agenceDestination;
	}

	public void setAgenceDestination(Agence agenceDestination) {
		this.agenceDestination = agenceDestination;
	}

	public Entite getEntite() {
		return entite;
	}

	public void setEntite(Entite entite) {
		this.entite = entite;
	}

	public StatutBonRamassage getStatut() {
		return statut;
	}

	public void setStatut(StatutBonRamassage statut) {
		this.statut = statut;
	}

	
	
	
	
	
	

}
