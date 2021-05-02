package com.xpr.dao.helper;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import com.fasterxml.jackson.annotation.JsonView;
import com.xpr.dao.core.view.ModelViews;




@MappedSuperclass
@EntityListeners({AuditingEntityListener.class, EntityListener.class})
public class XprBaseModel {
	

    @CreatedBy
    @JsonView(ModelViews.FullView.class)
    @Column(updatable = false)
    private String createdBy;

    @CreatedDate
    @JsonView(ModelViews.SelectView.class)
    @Column(updatable = false)
    private Date createdDate;

    @LastModifiedBy
    @JsonView(ModelViews.FullView.class)
    private String lastModifiedBy;

    @LastModifiedDate
    @JsonView(ModelViews.FullView.class)
    private Date lastModifiedDate;

    @Transient
    private transient XprBaseModel savedState;
    
    @Transient
    private String identifiant;
    
	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public XprBaseModel getSavedState() {
		return savedState;
	}

	public void setSavedState(XprBaseModel savedState) {
		this.savedState = savedState;
	}

	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	
    
    
}
