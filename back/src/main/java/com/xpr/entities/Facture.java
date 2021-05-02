package com.xpr.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.xpr.dao.helper.XprBaseModel;

@Entity
@Table(name = "factures")
public class Facture extends XprBaseModel implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id 
	@GenericGenerator(name = "facture_name", strategy = "com.xpr.generator.FactureGenerator")
    @GeneratedValue(generator = "facture_name")  
	private String name;
	
	private double totalCrbt;
	
	// colis > 1000dh  + 15DH sur frais originale
	private double totalFrais;
	
	private double totalNet;
	
	private int nbrColis;
	
	private String type;
	
	private String statut;
	
	private Date dateCreation;
	
	@OneToMany(mappedBy = "facture",fetch = FetchType.EAGER)
	private Set<LigneFacture> ligneFactures=new HashSet<LigneFacture>();
	
	private boolean disabled;
	
	@ManyToOne
	private Utilisateur creerPar;
	
	@ManyToOne
	private Livreur livreur;
	
	private String typeReglement;
	
	private String statutAvecAgence;
	
	@ManyToMany
	@JsonIgnore
	private List<Client> clients;
	
	@ManyToOne
	private Entite entite;
	
	
	
	public Facture() {
		
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getTotalCrbt() {
		return totalCrbt;
	}


	public void setTotalCrbt(double totalCrbt) {
		this.totalCrbt = totalCrbt;
	}


	public double getTotalFrais() {
		return totalFrais;
	}


	public void setTotalFrais(double totalFrais) {
		this.totalFrais = totalFrais;
	}


	public double getTotalNet() {
		return totalNet;
	}


	public void setTotalNet(double totalNet) {
		this.totalNet = totalNet;
	}


	public int getNbrColis() {
		return nbrColis;
	}


	public void setNbrColis(int nbrColis) {
		this.nbrColis = nbrColis;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateCreation == null) ? 0 : dateCreation.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + nbrColis;
		result = prime * result + ((statut == null) ? 0 : statut.hashCode());
		long temp;
		temp = Double.doubleToLongBits(totalCrbt);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(totalFrais);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(totalNet);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Facture other = (Facture) obj;
		if (dateCreation == null) {
			if (other.dateCreation != null)
				return false;
		} else if (!dateCreation.equals(other.dateCreation))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (nbrColis != other.nbrColis)
			return false;
		if (statut == null) {
			if (other.statut != null)
				return false;
		} else if (!statut.equals(other.statut))
			return false;
		if (Double.doubleToLongBits(totalCrbt) != Double.doubleToLongBits(other.totalCrbt))
			return false;
		if (Double.doubleToLongBits(totalFrais) != Double.doubleToLongBits(other.totalFrais))
			return false;
		if (Double.doubleToLongBits(totalNet) != Double.doubleToLongBits(other.totalNet))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Facture [name=" + name + ", totalCrbt=" + totalCrbt + ", totalFrais=" + totalFrais + ", totalNet="
				+ totalNet + ", nbrColis=" + nbrColis + ", type=" + type + ", statut=" + statut + ", dateCreation="
				+ dateCreation + "]";
	}


	public boolean isDisabled() {
		return disabled;
	}


	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}


	


	public Utilisateur getCreerPar() {
		return creerPar;
	}


	public void setCreerPar(Utilisateur creerPar) {
		this.creerPar = creerPar;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public Livreur getLivreur() {
		return livreur;
	}


	public void setLivreur(Livreur livreur) {
		this.livreur = livreur;
	}


	public Set<LigneFacture> getLigneFactures() {
		return ligneFactures;
	}


	public void setLigneFactures(Set<LigneFacture> ligneFactures) {
		this.ligneFactures = ligneFactures;
	}


	public String getTypeReglement() {
		return typeReglement;
	}


	public void setTypeReglement(String typeReglement) {
		this.typeReglement = typeReglement;
	}


	public String getStatutAvecAgence() {
		return statutAvecAgence;
	}


	public void setStatutAvecAgence(String statutAvecAgence) {
		this.statutAvecAgence = statutAvecAgence;
	}


	public List<Client> getClients() {
		return clients;
	}


	public void setClients(List<Client> clients) {
		this.clients = clients;
	}


	public Entite getEntite() {
		return entite;
	}


	public void setEntite(Entite entite) {
		this.entite = entite;
	}

	
	
	
	

}
