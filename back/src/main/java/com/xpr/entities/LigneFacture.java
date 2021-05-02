package com.xpr.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ligneFacture")
public class LigneFacture {
	
	@Id @GeneratedValue
	private Long id;
	
	private String libelle;
	
	@ManyToOne
	private Facture facture;
	
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

	public Facture getFacture() {
		return facture;
	}

	public void setFacture(Facture facture) {
		this.facture = facture;
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
