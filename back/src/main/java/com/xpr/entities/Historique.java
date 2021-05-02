package com.xpr.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.xpr.dao.core.view.ModelViews;
import com.xpr.dao.helper.XprBaseModel;

@Entity
@Table(name = "historiques")
public class Historique implements Serializable  {
	
	@Id @GeneratedValue
	private Long id;
	
	 @JsonView(ModelViews.SelectView.class)
	private String action;
	 
	 @JsonView(ModelViews.SelectView.class)
	private String statut;
	
	 @JsonView(ModelViews.SelectView.class)
	private Date dateCreation;
	
	 
	@ManyToOne
	@JsonView(ModelViews.SelectView.class)
	private Utilisateur utilisateur;
	
	private boolean disabled;
	

	public Historique() {
		
	}

	

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	
	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}



	public String getStatut() {
		return statut;
	}



	public void setStatut(String statut) {
		this.statut = statut;
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

	
	
	
	
	

	
	
	

}
