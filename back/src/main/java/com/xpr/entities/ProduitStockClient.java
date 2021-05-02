package com.xpr.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.xpr.dao.helper.XprBaseModel;

@Entity
@Table(name = "produitStockClient")
public class ProduitStockClient extends XprBaseModel implements Serializable {
	
	@Id @GeneratedValue
	private long id;
	
	@ManyToOne
	private Client client;
	
	@ManyToOne
	private Entite entite;
	
			
	private int qte;
	
	private int qteLivre;
	
	private int qteEnCoursLivraison;
	
	private int qteNonLivre;
	
	@ManyToOne
	private Agence agence;
	
	@ManyToOne
	private Ville ville;
	
	@OneToOne
	private Produit produit;
	
	@OneToOne
	private Variante variante;
	
	
	public ProduitStockClient() {
		
	}
	
	
	public int getQte() {
		return qte;
	}

	public void setQte(int qte) {
		this.qte = qte;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}


	public int getQteLivre() {
		return qteLivre;
	}


	public void setQteLivre(int qteLivre) {
		this.qteLivre = qteLivre;
	}


	public int getQteEnCoursLivraison() {
		return qteEnCoursLivraison;
	}


	public void setQteEnCoursLivraison(int qteEnCoursLivraison) {
		this.qteEnCoursLivraison = qteEnCoursLivraison;
	}


	public int getQteNonLivre() {
		return qteNonLivre;
	}


	public void setQteNonLivre(int qteNonLivre) {
		this.qteNonLivre = qteNonLivre;
	}


	public Agence getAgence() {
		return agence;
	}


	public void setAgence(Agence agence) {
		this.agence = agence;
	}


	public Ville getVille() {
		return ville;
	}


	public void setVille(Ville ville) {
		this.ville = ville;
	}


	public Entite getEntite() {
		return entite;
	}


	public void setEntite(Entite entite) {
		this.entite = entite;
	}


}
