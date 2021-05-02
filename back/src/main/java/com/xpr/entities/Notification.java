package com.xpr.entities;

import com.fasterxml.jackson.annotation.JsonView;
import com.xpr.dao.core.view.ModelViews;
import com.xpr.dao.helper.XprBaseModel;


import javax.persistence.*;

@Entity
public class Notification extends XprBaseModel {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @JsonView(ModelViews.SelectView.class)
    private Long id;

    @ManyToOne
    private Utilisateur receiver;

    @JsonView(ModelViews.ListView.class)
    private String url;

    @JsonView(ModelViews.ListView.class)
    private String description;

    @JsonView(ModelViews.ListView.class)
    private boolean isRead;

    @Transient
    private String utilisateurLogin;

  
    public String getUtilisateurLogin() {
		return utilisateurLogin;
	}

	public void setUtilisateurLogin(String utilisateurLogin) {
		this.utilisateurLogin = utilisateurLogin;
	}

	public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getIsRead() {
        return isRead;
    }

    public void setIsRead(boolean read) {
        this.isRead = read;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public Utilisateur getReceiver() {
		return receiver;
	}

	public void setReceiver(Utilisateur receiver) {
		this.receiver = receiver;
	}

	public void setRead(boolean isRead) {
		this.isRead = isRead;
	}
    
    
}
