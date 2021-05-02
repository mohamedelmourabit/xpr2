package com.xpr.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.xpr.dao.core.view.ModelViews;
import com.xpr.dao.helper.XprBaseModel;



@Entity
@Table(name = "autorisations")
public class Autorisation extends XprBaseModel  implements Serializable {
	
	@Id @GeneratedValue
	 @JsonView(ModelViews.SelectView.class)
	private Long id;
	
	@Column(unique=true)
	@JsonView(ModelViews.SelectView.class)
	private String authName;

	 @JsonView(ModelViews.SelectView.class)
	private String uri;

	@ManyToMany(mappedBy = "autorisations")
	@JsonIgnore
	private Collection<Profile> profiles;
	
	public Autorisation() {
		
	}
	
	

	public Autorisation(Object object, String authorisationName) {
		this.authName=authorisationName;
	}



	



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getAuthName() {
		return authName;
	}



	public void setAuthName(String authName) {
		this.authName = authName;
	}
	
	



	public String getUri() {
		return uri;
	}



	public void setUri(String uri) {
		this.uri = uri;
	}



	public Collection<Profile> getProfiles() {
		return profiles;
	}



	public void setProfiles(Collection<Profile> profiles) {
		this.profiles = profiles;
	}




	
	
	
}
