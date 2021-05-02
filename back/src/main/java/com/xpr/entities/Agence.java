package com.xpr.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.xpr.dao.helper.XprBaseModel;

@Entity
@Table(name = "agences")
public class Agence extends XprBaseModel implements Serializable  {
	
	@Id @GeneratedValue
	private long id;
	
	private String nom;
	
	
	@ManyToOne
	private Ville ville;
	
	@OneToMany(mappedBy="agence",fetch=FetchType.LAZY )
	@JsonIgnore
	private Set<ProduitStockClient> stocks;
	
	@ManyToOne
	private Entite entite;
	
	
	public Agence() {
		
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public Ville getVille() {
		return ville;
	}


	public void setVille(Ville ville) {
		this.ville = ville;
	}


	


	public Set<ProduitStockClient> getStocks() {
		return stocks;
	}


	public void setStocks(Set<ProduitStockClient> stocks) {
		this.stocks = stocks;
	}


	public Entite getEntite() {
		return entite;
	}


	public void setEntite(Entite entite) {
		this.entite = entite;
	}
	
	
	

}
