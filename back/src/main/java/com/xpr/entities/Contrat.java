package com.xpr.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.xpr.dao.helper.XprBaseModel;

@Entity
@Table(name="contrats")
public class Contrat extends XprBaseModel implements Serializable {
	
	@Id @GeneratedValue
	private long id;
	
	@OneToOne
	private Client client;
	
	@OneToOne
	private Entite entite;
	
	
	private Date dateDebut;
	
	private Date dateFin;
	
	private double prixLivraison;
	
	private double prixAnnulation;
	
	
	public Contrat() {
		
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

	

	public double getPrixLivraison() {
		return prixLivraison;
	}

	public void setPrixLivraison(double prixLivraison) {
		this.prixLivraison = prixLivraison;
	}

	public double getPrixAnnulation() {
		return prixAnnulation;
	}

	public void setPrixAnnulation(double prixAnnulation) {
		this.prixAnnulation = prixAnnulation;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public Entite getEntite() {
		return entite;
	}

	public void setEntite(Entite entite) {
		this.entite = entite;
	}
	
	
	

}
