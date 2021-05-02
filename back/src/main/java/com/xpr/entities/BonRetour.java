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

import com.fasterxml.jackson.annotation.JsonView;
import com.xpr.dao.core.view.ModelViews;
import com.xpr.dao.helper.XprBaseModel;

@Entity
@Table(name = "bonRetours")
public class BonRetour extends XprBaseModel implements Serializable {
	
	@Id 
	@GenericGenerator(name = "bonRetour_nom", strategy = "com.xpr.generator.BonRetourGenerator")
    @GeneratedValue(generator = "bonRetour_nom") 
	@JsonView(ModelViews.SelectView.class)
	private String nom;
	

	@ManyToOne
	private Livreur livreur;
	
	@ManyToOne
	private Client client;
	
	@OneToMany(mappedBy = "bonRetour",fetch = FetchType.EAGER)
	private Set<LigneBonRetour> ligneBonRetours=new HashSet<LigneBonRetour>();
	
	@ManyToOne
	@JsonView(ModelViews.SelectView.class)
	private StatutBonRetour statut;
	
	@JsonView(ModelViews.ListView.class)
	private boolean disabled;
	
	@OneToMany(mappedBy = "bonRetour",fetch = FetchType.EAGER)
	private Set<HistoriqueBonRetour> historiques;
	
	@ManyToOne
	private Entite entite;
	
	
	public BonRetour() {
		
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	
	public Livreur getLivreur() {
		return livreur;
	}

	public void setLivreur(Livreur livreur) {
		this.livreur = livreur;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}	

	public Set<LigneBonRetour> getLigneBonRetours() {
		return ligneBonRetours;
	}

	public void setLigneBonRetours(Set<LigneBonRetour> ligneBonRetours) {
		this.ligneBonRetours = ligneBonRetours;
	}

	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

	
	
	

	public Set<HistoriqueBonRetour> getHistoriques() {
		return historiques;
	}

	public void setHistoriques(Set<HistoriqueBonRetour> historiques) {
		this.historiques = historiques;
	}

	public Entite getEntite() {
		return entite;
	}

	public void setEntite(Entite entite) {
		this.entite = entite;
	}

	public StatutBonRetour getStatut() {
		return statut;
	}

	public void setStatut(StatutBonRetour statut) {
		this.statut = statut;
	}
	
	
	
	
	
	
	

}
