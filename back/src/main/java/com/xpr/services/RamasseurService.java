package com.xpr.services;

import java.util.List;

import org.springframework.data.domain.Page;
import com.xpr.entities.Ramasseur;

public interface RamasseurService  {

	public Ramasseur saveRamasseur(Ramasseur livreur);
	
	public Ramasseur findRamasseurByCni(String cni);
	
	public Ramasseur findRamasseurByNomOrPrenom(String nom,String prenom);
	
	public Page<Ramasseur> findAllRamasseurByMc(String mc, int page, int size);

	public List<Ramasseur> findAll();

	public Ramasseur updateRamasseur(String cni, Ramasseur livreur);

	public void deleteRamasseur(String cni);
}
