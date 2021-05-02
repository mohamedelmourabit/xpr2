package com.xpr.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonView;
import com.xpr.dao.core.view.ModelViews;
import com.xpr.dao.helper.XprBaseModel;

@Entity
public class News extends XprBaseModel {
	
	@Id @GeneratedValue
	private Long id;
	
	 @JsonView(ModelViews.SelectView.class)
	private String image;
	
	 @JsonView(ModelViews.SelectView.class)
	private String grandTitre;
	
	 @JsonView(ModelViews.SelectView.class)
	private String text;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getGrandTitre() {
		return grandTitre;
	}

	public void setGrandTitre(String grandTitre) {
		this.grandTitre = grandTitre;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	

}
