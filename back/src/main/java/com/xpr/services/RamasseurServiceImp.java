package com.xpr.services;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.xpr.dao.RamasseurRepository;
import com.xpr.entities.Ramasseur;

@Service
public class RamasseurServiceImp implements RamasseurService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RamasseurServiceImp.class);
	
	@Autowired
	private RamasseurRepository ramaseurRepository;
	

	@Override
	public Ramasseur saveRamasseur(Ramasseur ramaseur) {
		LOGGER.info("Ajout ramaseur {}",ramaseur.getNom()+ " "+ramaseur.getPrenom());
		return ramaseurRepository.save(ramaseur);
	}

	@Override
	public Ramasseur findRamasseurByCni(String cni) {
		LOGGER.info("Récuperation du ramaseur cni= {} ",cni);
		return ramaseurRepository.findById(cni).orElse(null);
	}

	@Override
	public Ramasseur findRamasseurByNomOrPrenom(String nom,String prenom) {
		LOGGER.info("Récuperation du ramaseur Nom {} or Prenom {} ",nom,prenom);
		return ramaseurRepository.getRamasseurByNomOrPernom(nom,prenom);
	}

	@Override
	public Page<Ramasseur> findAllRamasseurByMc(String mc, int page, int size) {
		LOGGER.info("Récupere des ramaseur par Nom {} ",mc);
		return ramaseurRepository.findByNameStartsWith(mc,  PageRequest.of(page, size,Sort.by("nom").ascending()));
	}

	@Override
	public List<Ramasseur> findAll() {
		LOGGER.info("Récupere tous les ramaseur avec pagination");
		return ramaseurRepository.findAll();
	}

	@Override
	public Ramasseur updateRamasseur(String cni, Ramasseur ramaseur) {
		LOGGER.info("Modification ramaseur {}",ramaseur.getNom()+ " "+ramaseur.getPrenom());
		ramaseur.setCni(cni);
		return ramaseurRepository.save(ramaseur);
	}

	@Override
	public void deleteRamasseur(String cni) {
		LOGGER.info("Suppression du ramaseur cni= {}",cni);
		
		Ramasseur ramaseur = ramaseurRepository.findById(cni).orElse(null);
		if(ramaseur!=null)
		ramaseurRepository.delete(ramaseur);
		
	}

}
