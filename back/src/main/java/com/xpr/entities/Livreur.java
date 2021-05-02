package com.xpr.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.xpr.dao.core.view.ModelViews;

@Entity
@Table(name = "livreurs")
public class Livreur extends Utilisateur implements Serializable {
		
	
	@ManyToMany(fetch=FetchType.LAZY )
	 @JsonView(ModelViews.SelectView.class)
	private Set<Ville> villes;
	
	@OneToMany(mappedBy="livreur",fetch=FetchType.LAZY )
	@JsonIgnore
	private Set<Colis> colis;

		
	@OneToMany(mappedBy="livreur",fetch=FetchType.LAZY )
	@JsonIgnore
	private Set<Facture> factures;
	
	
	
	public Livreur() {
		
		this.typeUtilisateur="Livreur";
		
		
	}


	public Set<Facture> getFactures() {
		return factures;
	}

	public void setFactures(Set<Facture> factures) {
		this.factures = factures;
	}

	public Set<Ville> getVilles() {
		return villes;
	}

	public void setVilles(Set<Ville> villes) {
		this.villes = villes;
	}

	public Set<Colis> getColis() {
		return colis;
	}

	public void setColis(Set<Colis> colis) {
		this.colis = colis;
	}
	
	

}
