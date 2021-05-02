package com.xpr.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="ligneBonExpeditions")
public class LigneBonExpedition  implements Serializable {
	
	@Id @GeneratedValue
	private long id;
	
	@ManyToOne
	private Colis colis;
	
	@ManyToOne
	private BonExpedition bonExpedition;
	
	@ManyToOne
	private LigneColis ligneColis;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Colis getColis() {
		return colis;
	}

	public void setColis(Colis colis) {
		this.colis = colis;
	}

	public LigneColis getLigneColis() {
		return ligneColis;
	}

	public void setLigneColis(LigneColis ligneColis) {
		this.ligneColis = ligneColis;
	}

	public BonExpedition getBonExpedition() {
		return bonExpedition;
	}

	public void setBonExpedition(BonExpedition bonExpedition) {
		this.bonExpedition = bonExpedition;
	}
	
	
	

}
