package com.xpr.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.xpr.dao.helper.XprBaseModel;

@Entity
@Table(name = "commentaires")
public class Commentaire extends XprBaseModel implements Serializable {
	
	@Id @GeneratedValue
	private long id;

	private String commentaire;
	
	@ManyToOne
	@JsonIgnore
	private Colis colis;
	
	@ManyToOne
	private Utilisateur utilisateur;
	
	private Date dateCreation;
	
	public Commentaire() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public Colis getColis() {
		return colis;
	}

	public void setColis(Colis colis) {
		this.colis = colis;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	
	
}
