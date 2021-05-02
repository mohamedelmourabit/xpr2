package com.xpr.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ligneFactureClient")
public class LigneFactureClient {
	
	@Id @GeneratedValue
	private Long id;
	
	private String libelle;
	
	@ManyToOne
	private FactureClient factureClient;
	
	@ManyToOne
	private LigneColis ligneColis;
	
	private int qte;
	
	private double prixFacture;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	

	public FactureClient getFactureClient() {
		return factureClient;
	}

	public void setFactureClient(FactureClient factureClient) {
		this.factureClient = factureClient;
	}

	public LigneColis getLigneColis() {
		return ligneColis;
	}

	public void setLigneColis(LigneColis ligneColis) {
		this.ligneColis = ligneColis;
	}

	public int getQte() {
		return qte;
	}

	public void setQte(int qte) {
		this.qte = qte;
	}

	public double getPrixFacture() {
		return prixFacture;
	}

	public void setPrixFacture(double prixFacture) {
		this.prixFacture = prixFacture;
	}

	
	
	
	

}
