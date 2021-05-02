package com.xpr.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.xpr.dao.core.view.ModelViews;
import com.xpr.dao.helper.XprBaseModel;


@Entity
public class Variante extends XprBaseModel implements Serializable  {
	
	@Id @GeneratedValue
	@JsonView(ModelViews.SelectView.class)
	private Long id;
	
	@JsonView(ModelViews.SelectView.class)
	private String sku;
	
	@ManyToOne
	@JsonView(ModelViews.SelectView.class)
	private Produit produit;
		
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
	private Integer qte;
	
	@JsonView(ModelViews.SelectView.class)
	private boolean emballer;
	
	@JsonView(ModelViews.SelectView.class)
	private String photo;
	
	@JsonView(ModelViews.SelectView.class)
	private String marque;
	
	@OneToMany(mappedBy = "variante",fetch = FetchType.LAZY)
	@JsonIgnore
	private Set<ProduitStockClient> stocks;
	
	public Variante() {
		
		
	}


	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}


	public Produit getProduit() {
		return produit;
	}


	public void setProduit(Produit produit) {
		this.produit = produit;
	}


	


	public double getPrixVente() {
		return prixVente;
	}


	public void setPrixVente(double prixVente) {
		this.prixVente = prixVente;
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


	public String getNature() {
		return nature;
	}


	public void setNature(String nature) {
		this.nature = nature;
	}


	public String getDimension() {
		return dimension;
	}


	public void setDimension(String dimension) {
		this.dimension = dimension;
	}


	public Double getPrixOriginale() {
		return prixOriginale;
	}


	public void setPrixOriginale(Double prixOriginale) {
		this.prixOriginale = prixOriginale;
	}


	public Integer getQte() {
		return qte;
	}


	public void setQte(Integer qte) {
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


	public String getMarque() {
		return marque;
	}


	public void setMarque(String marque) {
		this.marque = marque;
	}


	public void setPrixVente(Double prixVente) {
		this.prixVente = prixVente;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Set<ProduitStockClient> getStocks() {
		return stocks;
	}


	public void setStocks(Set<ProduitStockClient> stocks) {
		this.stocks = stocks;
	}
	
	
	
	
	
	
	
	
	
}
