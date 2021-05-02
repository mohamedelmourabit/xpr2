package com.xpr.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Ramasseurs")
public class Ramasseur  extends Utilisateur implements Serializable {
		

	
	@OneToMany(mappedBy="ramasseur",fetch=FetchType.LAZY )
	@JsonIgnore
	private Set<Colis> colis = new HashSet<Colis>();
	
	@OneToMany(mappedBy="ramasseur",fetch=FetchType.LAZY )
	@JsonIgnore
	private Set<BonRamassage> bonRamassages=new HashSet<BonRamassage>();
	

	@ManyToMany(fetch=FetchType.LAZY )
	private Set<Ville> villes = new HashSet<Ville>();
	
	
	
	
	public Ramasseur() {
		
		this.typeUtilisateur="Ramasseur";
		
		
	}

	

	
	public Set<Colis> getColis() {
		return colis;
	}

	public void setColis(Set<Colis> colis) {
		this.colis = colis;
	}

	public Set<BonRamassage> getBonRamassages() {
		return bonRamassages;
	}

	public void setBonRamassages(Set<BonRamassage> bonRamassages) {
		this.bonRamassages = bonRamassages;
	}


	public Set<Ville> getVilles() {
		return villes;
	}

	public void setVilles(Set<Ville> villes) {
		this.villes = villes;
	}

	
	
	
	

}
