package com.xpr.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ligneBonRetours")
public class LigneBonRetour implements Serializable {
	
	@Id @GeneratedValue
	private Long id;
	
	@ManyToOne
	private BonRetour bonRetour;
	
	@ManyToOne
	private LigneColis ligneColis;
	
	
	@ManyToOne
	private Colis colis;
	
	private int qteRetourne;
	
	
	public LigneBonRetour() {
		
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public BonRetour getBonRetour() {
		return bonRetour;
	}


	public void setBonRetour(BonRetour bonRetour) {
		this.bonRetour = bonRetour;
	}


	public LigneColis getLigneColis() {
		return ligneColis;
	}


	public void setLigneColis(LigneColis ligneColis) {
		this.ligneColis = ligneColis;
	}


	public Colis getColis() {
		return colis;
	}


	public void setColis(Colis colis) {
		this.colis = colis;
	}


	public int getQteRetourne() {
		return qteRetourne;
	}


	public void setQteRetourne(int qteRetourne) {
		this.qteRetourne = qteRetourne;
	}
	
	
	
	
}
