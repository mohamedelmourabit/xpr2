package com.xpr.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.xpr.dao.core.view.ModelViews;

@Entity
@Table(name = "ligneColis")
public class LigneColis implements Serializable {
	
	@Id @GeneratedValue
	 @JsonView(ModelViews.SelectView.class)
	private Long id;
	
	@ManyToOne
	@JsonIgnore
	private Colis colis;
	
	@ManyToOne
	@JsonView(ModelViews.SelectView.class)
	private Produit produit;
	
	@ManyToOne
	@JsonView(ModelViews.SelectView.class)
	private Variante variante;
	
	@OneToOne
	private ProduitStockClient stock;
	
	@JsonView(ModelViews.ListView.class)
	private int qte;
	
	@JsonView(ModelViews.ListView.class)
	private int qteLivre;
	
	@JsonView(ModelViews.ListView.class)
	private int qteRetourne;
	
	@ManyToOne
	@JsonIgnore
	private BonRetour bonRetour;
	
	@JsonView(ModelViews.SelectView.class)
	private Double prix;
	
	@ManyToOne
	@JsonIgnore
	private Business business;

	
	public LigneColis() {
		
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Colis getColis() {
		return colis;
	}


	public void setColis(Colis colis) {
		this.colis = colis;
	}


	public Produit getProduit() {
		return produit;
	}


	public void setProduit(Produit produit) {
		this.produit = produit;
	}


	public Variante getVariante() {
		return variante;
	}


	public void setVariante(Variante variante) {
		this.variante = variante;
	}



	public Integer getQte() {
		return qte;
	}


	public void setQte(Integer qte) {
		this.qte = qte;
	}


	public Integer getQteLivre() {
		return qteLivre;
	}


	public void setQteLivre(Integer qteLivre) {
		this.qteLivre = qteLivre;
	}


	public Integer getQteRetourne() {
		return qteRetourne;
	}


	public void setQteRetourne(Integer qteRetourne) {
		this.qteRetourne = qteRetourne;
	}


	public BonRetour getBonRetour() {
		return bonRetour;
	}


	public void setBonRetour(BonRetour bonRetour) {
		this.bonRetour = bonRetour;
	}


	public Double getPrix() {
		return prix;
	}


	public void setPrix(Double prix) {
		this.prix = prix;
	}


	public ProduitStockClient getStock() {
		return stock;
	}


	public void setStock(ProduitStockClient stock) {
		this.stock = stock;
	}

	
	

}
