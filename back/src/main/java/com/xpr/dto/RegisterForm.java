package com.xpr.dto;


public class RegisterForm {
	
	private String cni;
	
	private String email;
	
	private String password;
	
	private String repassword;	
	
	private String nom;
	
	private String prenom;
	
	public RegisterForm() {
		
	}

	
	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getCni() {
		return cni;
	}


	public void setCni(String cni) {
		this.cni = cni;
	}
	
	
	
}
