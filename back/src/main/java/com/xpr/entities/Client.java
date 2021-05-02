package com.xpr.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.xpr.dao.core.view.ModelViews;
import com.xpr.dao.helper.XprBaseModel;

@Entity
@Table(name = "clients")
public class Client extends XprBaseModel  implements Serializable {
	
	@Id 
	@JsonView(ModelViews.SelectView.class)
	private String ice;
	@JsonView(ModelViews.SelectView.class)
	private String nom;
	@JsonView(ModelViews.SelectView.class)
	private String contact;
	@JsonView(ModelViews.SelectView.class)
	private String telephone;
	@JsonView(ModelViews.SelectView.class)
	private String prefixCommande;
	@JsonView(ModelViews.SelectView.class)
	private String address;
	@JsonView(ModelViews.SelectView.class)
	private boolean disabled;
	
	//Particulier ou Entreprise
	@JsonView(ModelViews.SelectView.class)
	private String typeClient;
	
	@OneToOne
	@JsonView(ModelViews.ListView.class)
	private Contrat contrat;
	
	@OneToMany(mappedBy = "client",fetch = FetchType.LAZY)
	@JsonIgnore

	private Set<Colis> colis;
	
	
	
	@OneToMany(mappedBy = "client",fetch = FetchType.LAZY)
	@JsonIgnore
	private Set<BonRetour> bonRetours = new HashSet<BonRetour>();
	
	@OneToMany(mappedBy = "client",fetch = FetchType.LAZY)
	@JsonIgnore
	private Set<BonRamassage> bonRamassages;

	@OneToMany(mappedBy = "client",fetch = FetchType.LAZY)
	@JsonIgnore
	private Set<Business> bussiness = new HashSet<Business>();
	
	
	@OneToMany(mappedBy = "client",fetch = FetchType.LAZY)
	@JsonIgnore
	private Set<ProduitStockClient> stocks;
	
	@ManyToOne
	@JsonView(ModelViews.SelectView.class)
	private Entite entite;
	
	
	@ManyToOne
	@JsonView(ModelViews.SelectView.class)
	private Ville ville;

	public Client() {
		
	}



	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public String getContact() {
		return contact;
	}



	public void setContact(String contact) {
		this.contact = contact;
	}



	public String getTelephone() {
		return telephone;
	}



	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	public Set<Colis> getColis() {
		return colis;
	}



	public void setColis(Set<Colis> colis) {
		this.colis = colis;
	}





	public String getPrefixCommande() {
		return prefixCommande;
	}



	public void setPrefixCommande(String prefixCommande) {
		this.prefixCommande = prefixCommande;
	}




	public String getIce() {
		return ice;
	}



	public void setIce(String ice) {
		this.ice = ice;
	}



	public String getTypeClient() {
		return typeClient;
	}



	public void setTypeClient(String typeClient) {
		this.typeClient = typeClient;
	}



	public Set<Business> getBussiness() {
		return bussiness;
	}



	public void setBussiness(Set<Business> bussiness) {
		this.bussiness = bussiness;
	}


	public boolean isDisabled() {
		return disabled;
	}



	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public Set<BonRetour> getBonRetours() {
		return bonRetours;
	}



	public void setBonRetours(Set<BonRetour> bonRetours) {
		this.bonRetours = bonRetours;
	}



	public Set<BonRamassage> getBonRamassages() {
		return bonRamassages;
	}



	public void setBonRamassages(Set<BonRamassage> bonRamassages) {
		this.bonRamassages = bonRamassages;
	}



	public Ville getVille() {
		return ville;
	}



	public void setVille(Ville ville) {
		this.ville = ville;
	}



	public Contrat getContrat() {
		return contrat;
	}



	public void setContrat(Contrat contrat) {
		this.contrat = contrat;
	}



	public Entite getEntite() {
		return entite;
	}
	
	



	public void setEntite(Entite entite) {
		this.entite = entite;
	}


	
	
	
	

	
	
	
}
