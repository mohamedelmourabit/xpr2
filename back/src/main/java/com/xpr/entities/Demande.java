package com.xpr.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.xpr.dao.helper.XprBaseModel;

@Entity
@Table(name = "demandes")
public class Demande extends XprBaseModel implements Serializable {
	
	@Id
	private String nom;
	
	private String type;
	
	private String departement;
	
	private String objet;
	
	private String priorite;
	
	private String statut;
	
	private int evaluation;
	
	@Temporal(TemporalType.DATE)
	private Date dateCreation;
	
	@Temporal(TemporalType.DATE)
	private Date dateModification;
	
	private boolean disabled;
	
	@ManyToOne
	private Client client;
	@ManyToOne
	private Utilisateur creerPar;
	@ManyToOne
	private Utilisateur modifierPar;
	
	@ManyToOne
	private Business business;
	
	private boolean resolu;
	
	
	
	public Demande() {
	
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDepartement() {
		return departement;
	}

	public void setDepartement(String departement) {
		this.departement = departement;
	}

	public String getObjet() {
		return objet;
	}

	public void setObjet(String objet) {
		this.objet = objet;
	}

	public String getPriorite() {
		return priorite;
	}

	public void setPriorite(String priorite) {
		this.priorite = priorite;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public int getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(int evaluation) {
		this.evaluation = evaluation;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Date getDateModification() {
		return dateModification;
	}

	public void setDateModification(Date dateModification) {
		this.dateModification = dateModification;
	}

	

	public Utilisateur getCreerPar() {
		return creerPar;
	}

	public void setCreerPar(Utilisateur creerPar) {
		this.creerPar = creerPar;
	}

	public Utilisateur getModifierPar() {
		return modifierPar;
	}

	public void setModifierPar(Utilisateur modifierPar) {
		this.modifierPar = modifierPar;
	}

	public Business getBusiness() {
		return business;
	}

	public void setBusiness(Business business) {
		this.business = business;
	}

	public boolean isResolu() {
		return resolu;
	}

	public void setResolu(boolean resolu) {
		this.resolu = resolu;
	}


	

}
