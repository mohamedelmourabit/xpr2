package com.xpr.services;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.xpr.dao.LivreurRepository;
import com.xpr.entities.Livreur;

@Service
public class LivreurServiceImp implements LivreurService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LivreurServiceImp.class);
	
	@Autowired
	private LivreurRepository livreurRepository;
	

	@Override
	public Livreur saveLivreur(Livreur livreur) {
		LOGGER.info("Ajout livreur {}",livreur.getNom()+ " "+livreur.getPrenom());
		return livreurRepository.save(livreur);
	}

	@Override
	public Livreur findLivreurByEmail(String cni) {
		LOGGER.info("Récuperation du livreur cni= {} ",cni);
		return livreurRepository.findById(cni).orElse(null);
	}

	@Override
	public Livreur findLivreurByNomOrPrenom(String nom,String prenom) {
		LOGGER.info("Récuperation du livreur Nom {} or Prenom {} ",nom,prenom);
		return livreurRepository.getLivreurByNomOrPernom(nom,prenom);
	}

	@Override
	public Page<Livreur> findAllLivreurByMc(String mc, int page, int size) {
		LOGGER.info("Récupere des livreur par Nom {} ",mc);
		return livreurRepository.findByNameStartsWith(mc,  PageRequest.of(page, size,Sort.by("nom").ascending()));
	}

	@Override
	public List<Livreur> findAll() {
		LOGGER.info("Récupere tous les livreur avec pagination");
		return livreurRepository.findAll();
	}

	@Override
	public Livreur updateLivreur(String cni, Livreur livreur) {
		LOGGER.info("Modification livreur {}",livreur.getNom()+ " "+livreur.getPrenom());
		livreur.setCni(cni);
		return livreurRepository.save(livreur);
	}

	@Override
	public void deleteLivreur(String cni) {
		LOGGER.info("Suppression du livreur {}",cni);
		
		Livreur livreur = livreurRepository.findById(cni).orElse(null);
		if(livreur!=null)
		livreurRepository.delete(livreur);
		
	}

}
