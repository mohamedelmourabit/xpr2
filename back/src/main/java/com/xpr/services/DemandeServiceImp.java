package com.xpr.services;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.xpr.dao.DemandeRepository;
import com.xpr.entities.Demande;

@Service
public class DemandeServiceImp implements DemandeService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DemandeServiceImp.class);
	
	@Autowired
	private DemandeRepository demandeRepository;

	
	@Override
	public Demande saveDemande(Demande demande) {
		LOGGER.info("Ajout nouvelle demande {}",demande.getNom());
		return demandeRepository.save(demande);
	}

	@Override
	public Page<Demande> findAllDemandesByMc(String mc, int page, int size) {
		LOGGER.info("Récuperation des demandes par mot clés {} ",mc);
		return demandeRepository.findByNameStartsWith(mc, PageRequest.of(page, size));
	}

	@Override
	public List<Demande> findAll() {
		LOGGER.info("Récuperation des demandes");
		return demandeRepository.findAll();
	}

	@Override
	public Demande updateDemande(String nomDemande, Demande demande) {
		LOGGER.info("Modification  demande {}",nomDemande);
		demande.setNom(nomDemande);
		return demandeRepository.save(demande);
	}

	@Override
	public void deleteDemande(String nomDemande) {
		LOGGER.info("Suppression  demande {}",nomDemande);
		Demande demande = demandeRepository.findById(nomDemande).orElse(null);
		if(demande!=null) {
			demandeRepository.delete(demande);
		}
		
	}

	@Override
	public Demande findDemandeByNomDemande(String nomDemande) {
		LOGGER.info("Search demande {}",nomDemande);
		return demandeRepository.findById(nomDemande).orElse(null);
	}

	@Override
	public Page<Demande> findAllDemandesByClient(String emailClient, int page, int size) {
		return demandeRepository.getAllDemandesByClient(emailClient, PageRequest.of(page, size));
	}

	@Override
	public Page<Demande> findAllDemandesByUtilisateurs(String emailUtilisateur, int page, int size) {
		return demandeRepository.getAllDemandesUtilisateur(emailUtilisateur, PageRequest.of(page, size));
	}
	
	public int getCountDemandes() {
		return demandeRepository.getCountDemandes();
	}

}
