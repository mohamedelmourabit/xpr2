package com.xpr.dto;

import com.xpr.entities.BonRamassage;

public class BonRamassageSearch extends BonRamassage {
	
	private String mc;
	
	private String periode;

	public BonRamassageSearch() {
		super();
		
	}

	public String getMc() {
		return mc;
	}

	public void setMc(String mc) {
		this.mc = mc;
	}

	public String getPeriode() {
		return periode;
	}

	public void setPeriode(String periode) {
		this.periode = periode;
	}
	
	
	
	

}
