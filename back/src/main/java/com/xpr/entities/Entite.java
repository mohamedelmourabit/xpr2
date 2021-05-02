package com.xpr.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;
import com.xpr.dao.core.view.ModelViews;
import com.xpr.dao.helper.XprBaseModel;


@Entity
@Table(name="entite")
public class Entite extends XprBaseModel implements Serializable {
	
	@Id @GeneratedValue
	@JsonView(ModelViews.SelectView.class)
	private Long id;
	
	 @JsonView(ModelViews.SelectView.class)
	private String nom;
	
	@OneToMany(mappedBy = "entite",fetch = FetchType.LAZY)
	@JsonIgnore
	private Set<Client> clients;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnoreProperties({"entiteParent","clients"})
	private Entite entiteParent;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Set<Client> getClients() {
		return clients;
	}

	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}

	public Entite getEntiteParent() {
		return entiteParent;
	}

	public void setEntiteParent(Entite entiteParent) {
		this.entiteParent = entiteParent;
	} 
	
	
	

}
