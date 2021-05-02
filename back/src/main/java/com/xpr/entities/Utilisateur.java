package com.xpr.entities;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonView;
import com.xpr.dao.core.view.ModelViews;


@Entity
public class Utilisateur implements Serializable {
	
	@Id
	@JsonView(ModelViews.SelectView.class)
	private String email;
	
	@JsonView(ModelViews.SelectView.class)
	private String cni;
	
	@JsonIgnore
	private String password;
	
	@JsonView(ModelViews.SelectView.class)
	private String nom;
	
	@JsonView(ModelViews.SelectView.class)
	private String prenom;
	
	@JsonView(ModelViews.SelectView.class)
	private String telephone;
	
	@ManyToOne
	@JsonView(ModelViews.SelectView.class)
	private Entite entite;
	
	@ManyToOne
	private Client client;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "utilisateurs_profiles",
			joinColumns = @JoinColumn(
					name = "Utilisateurs_email", referencedColumnName = "email"),
			inverseJoinColumns = @JoinColumn(
					name = "profile_id", referencedColumnName = "id"))
	@JsonView(ModelViews.ListView.class)
	@JsonIgnoreProperties({"autorisations"})
	private Set<Profile> profiles = new HashSet<>();
	
	
	private boolean disabled;
	
	@JsonView(ModelViews.SelectView.class)
	protected String typeUtilisateur;
	
	
	
	
		
	public Utilisateur(String email) {
		super();
		this.email = email;
	}

	public Utilisateur(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

		
	
	
	public Utilisateur() {
		this.typeUtilisateur="Utilisateur";
	}

	@JsonIgnore
	public String getPassword() {
		return password;
	}
	@JsonSetter
	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

	public String getCni() {
		return cni;
	}

	public void setCni(String cni) {
		this.cni = cni;
	}


	public String getTypeUtilisateur() {
		return typeUtilisateur;
	}

	public void setTypeUtilisateur(String typeUtilisateur) {
		this.typeUtilisateur = typeUtilisateur;
	}

	public Set<Profile> getProfiles() {
		return profiles;
	}

	public void setProfiles(Set<Profile> profiles) {
		this.profiles = profiles;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	
	public Entite getEntite() {
		return entite;
	}

	public void setEntite(Entite entite) {
		this.entite = entite;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	

	
	
	
	

}
