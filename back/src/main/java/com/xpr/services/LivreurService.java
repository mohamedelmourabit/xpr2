package com.xpr.services;

import java.util.List;

import org.springframework.data.domain.Page;
import com.xpr.entities.Livreur;

public interface LivreurService  {

	public Livreur saveLivreur(Livreur livreur);
	
	public Livreur findLivreurByEmail(String cni);
	
	public Livreur findLivreurByNomOrPrenom(String nom,String prenom);
	
	public Page<Livreur> findAllLivreurByMc(String mc, int page, int size);

	public List<Livreur> findAll();

	public Livreur updateLivreur(String cni, Livreur livreur);

	public void deleteLivreur(String cni);
}
