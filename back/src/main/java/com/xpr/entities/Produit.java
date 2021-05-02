package com.xpr.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonView;
import com.xpr.dao.core.view.ModelViews;
import com.xpr.dao.helper.XprBaseModel;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

@Entity
@Table(name = "produits")
public class Produit extends XprBaseModel implements Serializable  {
	
	@Id @GeneratedValue
	@JsonView(ModelViews.SelectView.class)
	private Long id;
	
	@JsonView(ModelViews.SelectView.class)
	private String idIntern;
	
	@JsonView(ModelViews.SelectView.class)
	private String nom;
	
	@JsonView(ModelViews.SelectView.class)
	private String reference;
	
	@JsonView(ModelViews.SelectView.class)
	private String nature;
	
	@JsonView(ModelViews.SelectView.class)
	private String dimension;
	
	@JsonView(ModelViews.SelectView.class)
	private Double prixOriginale;
	
	@JsonView(ModelViews.SelectView.class)
	private Double prixVente;
	
	@JsonView(ModelViews.SelectView.class)
	private int qte;
	
	@JsonView(ModelViews.SelectView.class)
	private boolean emballer;
	
	@JsonView(ModelViews.SelectView.class)
	private String photo;
	
	@JsonView(ModelViews.SelectView.class)
	private String marque;
	
	@ManyToOne
	@JsonIgnore
	private Client client;
	
	@OneToMany(mappedBy = "produit",fetch = FetchType.LAZY)
	@JsonIgnore
	private Set<Variante> variantes;
	
	
	@OneToMany(mappedBy = "produit",fetch = FetchType.LAZY)
	@JsonIgnore
	private Set<ProduitStockClient> stocks;
		

	 public Produit() {
		
	 }


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}





	public String getIdIntern() {
		return idIntern;
	}


	public void setIdIntern(String idIntern) {
		this.idIntern = idIntern;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getReference() {
		return reference;
	}


	public void setReference(String reference) {
		this.reference = reference;
	}


	public String getDimension() {
		return dimension;
	}


	public void setDimension(String dimension) {
		this.dimension = dimension;
	}


	public double getPrixOriginale() {
		return prixOriginale;
	}



	public double getPrixVente() {
		return prixVente;
	}


	public int getQte() {
		return qte;
	}


	public void setQte(int qte) {
		this.qte = qte;
	}


	public boolean isEmballer() {
		return emballer;
	}


	public void setEmballer(boolean emballer) {
		this.emballer = emballer;
	}


	public String getPhoto() {
		return photo;
	}


	public void setPhoto(String photo) {
		this.photo = photo;
	}



	public void setPrixOriginale(Double prixOriginale) {
		this.prixOriginale = prixOriginale;
	}


	public void setPrixVente(Double prixVente) {
		this.prixVente = prixVente;
	}


	public void setQte(Integer qte) {
		this.qte = qte;
	}

	public String getNature() {
		return nature;
	}


	public void setNature(String nature) {
		this.nature = nature;
	}



	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}


	public String getMarque() {
		return marque;
	}


	public void setMarque(String marque) {
		this.marque = marque;
	}


	public Set<Variante> getVariantes() {
		return variantes;
	}


	public void setVariantes(Set<Variante> variantes) {
		this.variantes = variantes;
	}


	public Set<ProduitStockClient> getStocks() {
		return stocks;
	}


	public void setStocks(Set<ProduitStockClient> stocks) {
		this.stocks = stocks;
	}
	
	


}
