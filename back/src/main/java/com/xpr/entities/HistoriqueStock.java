package com.xpr.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "historiqueStock")
public class HistoriqueStock extends Historique  implements Serializable{
	
	@Id @GeneratedValue
	private Long id;
	
	@ManyToOne
	private ProduitStockClient stock;
	
	
	
	
	public HistoriqueStock() {
		
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public ProduitStockClient getStock() {
		return stock;
	}


	public void setStock(ProduitStockClient stock) {
		this.stock = stock;
	}

	
	

}
