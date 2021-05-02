package com.xpr.entities;

import com.fasterxml.jackson.annotation.JsonView;
import com.xpr.dao.core.view.ModelViews;
import com.xpr.dao.helper.XprBaseModel;
import org.springframework.data.annotation.Immutable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Immutable
public class StatutFacture extends XprBaseModel {

	@Id
	@JsonView(ModelViews.SelectView.class)
	private String code;

	@JsonView(ModelViews.SelectView.class)
	private String libelle;
	
	

	public StatutFacture(String libelle) {
		super();
		this.libelle = libelle;
		this.code = this.libelle.toUpperCase();
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

}