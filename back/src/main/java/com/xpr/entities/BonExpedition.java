package com.xpr.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonView;
import com.xpr.dao.core.view.ModelViews;
import com.xpr.dao.helper.XprBaseModel;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Table(name="bonExpeditions")
public class BonExpedition extends XprBaseModel implements Serializable  {
	
	@Id 
	@GenericGenerator(name = "bonExpedition_nom", strategy = "com.xpr.generator.BonExpeditionGenerator")
    @GeneratedValue(generator = "bonExpedition_nom")
	@JsonView(ModelViews.SelectView.class)
	private String nom;
	
	@ManyToOne
	@JsonView(ModelViews.SelectView.class)	
	private StatutBonExpedition statut;
	
	@JsonView(ModelViews.SelectView.class)
	private String logistique;
	
	@JsonView(ModelViews.SelectView.class)
	private String refBonLogistique;
	
	@ManyToOne
	private Agence depart;
	
	@ManyToOne
	private Agence destination;
	
	
	@OneToMany(mappedBy = "bonExpedition",fetch = FetchType.EAGER)
	private Set<LigneBonExpedition> ligneBonExpeditions;
	
	@OneToMany(mappedBy = "bonExpedition",fetch = FetchType.EAGER)
	private Set<HistoriqueBonExpedition> historiques;
	
	
	private boolean disabled;
	
	@JsonView(ModelViews.SelectView.class)
	private double prix;
	
	@ManyToOne
	@JsonView(ModelViews.SelectView.class)
	private Entite entite;
	
	public BonExpedition() {
	}
	

	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public String getLogistique() {
		return logistique;
	}

	public void setLogistique(String logistique) {
		this.logistique = logistique;
	}

	public String getRefBonLogistique() {
		return refBonLogistique;
	}

	public void setRefBonLogistique(String refBonLogistique) {
		this.refBonLogistique = refBonLogistique;
	}

	

	public Agence getDepart() {
		return depart;
	}

	public void setDepart(Agence depart) {
		this.depart = depart;
	}

	public Agence getDestination() {
		return destination;
	}

	public void setDestination(Agence destination) {
		this.destination = destination;
	}

	


	public Set<HistoriqueBonExpedition> getHistoriques() {
		return historiques;
	}


	public void setHistoriques(Set<HistoriqueBonExpedition> historiques) {
		this.historiques = historiques;
	}


	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}


	public Set<LigneBonExpedition> getLigneBonExpeditions() {
		return ligneBonExpeditions;
	}


	public void setLigneBonExpeditions(Set<LigneBonExpedition> ligneBonExpeditions) {
		this.ligneBonExpeditions = ligneBonExpeditions;
	}


	public double getPrix() {
		return prix;
	}


	public void setPrix(double prix) {
		this.prix = prix;
	}


	public Entite getEntite() {
		return entite;
	}


	public void setEntite(Entite entite) {
		this.entite = entite;
	}


	public StatutBonExpedition getStatut() {
		return statut;
	}


	public void setStatut(StatutBonExpedition statut) {
		this.statut = statut;
	}

	
	

}
