package com.xpr.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;
import com.xpr.dao.core.view.ModelViews;
import com.xpr.dao.helper.XprBaseModel;

@Entity
@Table(name = "ville")
public class Ville  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@JsonView(ModelViews.SelectView.class)
	private String nom;
	
	private String id;
	
	private String region;
	
	public Ville() {
		
	}
	
	

	public Ville(String nom, String id, String region) {
		super();
		this.nom = nom;
		this.id = id;
		this.region = region;
	}



	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}



	public String getRegion() {
		return region;
	}



	public void setRegion(String region) {
		this.region = region;
	}

	

	

	
	

}
