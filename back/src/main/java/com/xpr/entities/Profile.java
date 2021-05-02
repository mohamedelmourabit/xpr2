package com.xpr.entities;


import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.xpr.dao.core.view.ModelViews;
import com.xpr.dao.helper.XprBaseModel;



import javax.persistence.JoinColumn;

@Entity
@Table(name = "profiles")
public class Profile extends XprBaseModel implements Serializable  {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(ModelViews.SelectView.class)
	private Long id;
	
	@JsonView(ModelViews.SelectView.class)
	private String prflName;

	
	@ManyToMany(mappedBy = "profiles")
	@JsonIgnore
	private Collection<Utilisateur> utilisateurs;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "profiles_autorisations",
			joinColumns = @JoinColumn(
					name = "profile_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(
					name = "autorisation_id", referencedColumnName = "id"))
	@JsonView(ModelViews.ListView.class)
	private Set<Autorisation> autorisations = new HashSet<>();
	
	
	public Profile() {
		
	}
	
	

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getPrflName() {
		return prflName;
	}



	public void setPrflName(String prflName) {
		this.prflName = prflName;
	}



	public Collection<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}



	public void setUtilisateurs(Collection<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}



	public Set<Autorisation> getAutorisations() {
		return autorisations;
	}



	public void setAutorisations(Set<Autorisation> autorisations) {
		this.autorisations = autorisations;
	}

	


	
}
