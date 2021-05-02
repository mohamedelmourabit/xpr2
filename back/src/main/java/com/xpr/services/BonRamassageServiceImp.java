package com.xpr.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.xpr.dao.BonRamassageRepository;
import com.xpr.dao.HistoriqueRepository;
import com.xpr.entities.BonRamassage;
import com.xpr.entities.Client;
import com.xpr.entities.Colis;
import com.xpr.entities.Historique;
import com.xpr.exceptions.BonRamassageException;
import com.xpr.exceptions.ColisException;
import com.xpr.utils.Constants;

@Service
public class BonRamassageServiceImp implements BonRamassageService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BonRamassageServiceImp.class);
	
	@Autowired
	private BonRamassageRepository bonRamassageRepository;
	
	@Autowired
	private HistoriqueRepository historiqueRepository;

	
	@Override
	public BonRamassage saveBonRamassage(BonRamassage br) throws BonRamassageException {
		LOGGER.info("Ajout d'un nouveau BR");
		
		if(br.getColis().isEmpty()) {
			throw new BonRamassageException("Erreur création BR sans colis");
		}
		
		/*br.setDateCreation(new Date());
		br.setStatut(Constants.EN_ATTENTE_RAMASSAGE);
		
		br = bonRamassageRepository.save(br);*/
		
		/*Historique h =Historique.getHistorique("Ajout nouveau BR: "+br.getNom(), br.getStatut(), "cniTest");
		h.setBonRamassage(br);
		br.getHistoriques().add(h);*/
		//historiqueRepository.save(h);
		
		return br;
	}

	@Override
	public BonRamassage findBonRamassageByNom(String nom) {
		LOGGER.info("Récupération du BR {}",nom );
		return bonRamassageRepository.findByNom(nom);
	}

	@Override
	public Page<BonRamassage> findMyBonRamassageByMc(String email, String mc, int page, int size) {
		LOGGER.info("Récupération du BR par mail= {} , mc= {}",email,mc );
		return bonRamassageRepository.findByCniAndNomStartsWith(email,mc, PageRequest.of(page, size));
	}

	@Override
	public Page<BonRamassage> findAllBonRamassageByMc(String mc, int page, int size) {
		return bonRamassageRepository.findByNameStartsWith(mc, PageRequest.of(page, size));
	}

	@Override
	public List<BonRamassage> findAll() {
		List<BonRamassage> list = new ArrayList<BonRamassage>();
		bonRamassageRepository.findAll().iterator().forEachRemaining(list::add);
		return  list;
	}

	@Override
	public BonRamassage updateBonRamassage(String nom, BonRamassage bonRamassage) throws BonRamassageException {
		LOGGER.info("Modification du BR {} ",nom);
		
		BonRamassage bl = bonRamassageRepository.findByNom(nom);
		bonRamassage.setNom(nom);
		//bonRamassage.setDateModification(new Date());
		if(!bonRamassage.getStatut().equals(Constants.NOUVEAU_BR) ) {
			throw new BonRamassageException("Impossible de modifer un br après ramassage");
		}
		
		/*if(bl.getStatut().equalsIgnoreCase(bonRamassage.getStatut())) {
			throw new BonRamassageException("Impossible de modifier un br avec le meme statut!");
		}
		
		bonRamassage = bonRamassageRepository.save(bonRamassage);
		bonRamassage.setDateModification(new Date());
		Historique h =Historique.getHistorique("Modification BR: "+nom, bonRamassage.getStatut(), "cniTest");
		h.setBonRamassage(bonRamassage);
		bonRamassage.getHistoriques().add(h);
		
		historiqueRepository.save(h);*/
		return bonRamassage;
	}

	@Override
	public void deleteBonRamassage(String nom) throws BonRamassageException {
		
		
		LOGGER.info("Suppression du BR {} ",nom);
		BonRamassage bl = bonRamassageRepository.findByNom(nom);
		
		if(!bl.getStatut().equals(Constants.NOUVEAU_BR) ) {
			throw new BonRamassageException("Impossible de supprimer un bl après ramassage");
		}
		//bl.setDateModification(new Date());
		//bl.setStatut(Constants.ANNULE);
		
		/*Historique h =Historique.getHistorique("Suppression BR: "+nom, bl.getStatut(), "cniTest");
		h.setBonRamassage(bl);
		bl.getHistoriques().add(h);*/
		bl.setDisabled(true);
		//historiqueRepository.save(h);
		
		if(bl!=null) {
			bonRamassageRepository.save(bl);
		}
	}

	@Override
	public BonRamassage generateBonRamassage(List<Colis> colis) {
		LOGGER.info("Generate nouveau BR avec {} colis ",colis.size());
		BonRamassage bl = new BonRamassage();
		//bl.setDateCreation(new Date());
		if(colis!=null && colis.get(0)!=null) {
			Client client = colis.get(0).getClient();
			bl.setClient(client);
		}
		bl.setColis(new HashSet<Colis>(colis));
		//bl.setDateModification(new Date());
		bl = bonRamassageRepository.save(bl);
		/*Historique h =Historique.getHistorique("Ajout nouveau BR: "+bl.getNom(), bl.getStatut(), "cniTest");
		h.setBonRamassage(bl);
		bl.getHistoriques().add(h);*/
		//historiqueRepository.save(h);
		
		return bl;
	}

	@Override
	public Page<BonRamassage> findAllBonRamassagesByClient(String emailClient, int page, int size) {
		
		return bonRamassageRepository.getAllBonRamassageByClient(emailClient, PageRequest.of(page, size));
	}

	@Override
	public Page<BonRamassage> findAllBonRamassagesByUtilisateurs(String emailUtilisateur, int page, int size) {
		
		return bonRamassageRepository.getAllBonRamassagesUtilisateur(emailUtilisateur, PageRequest.of(page, size));
	}
	
	@Override
	public int getCountBonRamassages() {
		return bonRamassageRepository.getCountBonRamassages();
	}

	@Override
	public BonRamassage addColisToBonRamassage(String idBr, List<Colis> colis) throws BonRamassageException {
		BonRamassage bl = findBonRamassageByNom(idBr);
		//bl.setDateModification(new Date());
		if(!bl.getStatut().equals(Constants.NOUVEAU_BR) ) {
			throw new BonRamassageException("Impossible de modifier un bl après ramassage");
		}
		
		/*Historique h =Historique.getHistorique("Ajout " + colis.size()+" colis to BR: "+bl.getNom(), bl.getStatut(), "cniTest");
		h.setBonRamassage(bl);
		historiqueRepository.save(h);*/
		
		bl.getColis().addAll(colis);
		return bl;
	}

	@Override
	public BonRamassage deleteColisFomBonRamassage(String idBr, List<Colis> colis) {
		
		BonRamassage bl = findBonRamassageByNom(idBr);
		//bl.setDateModification(new Date());
		Iterator<Colis> iterator = bl.getColis().iterator();
		while (iterator.hasNext()) {
		    Colis element = iterator.next();
		    for(Colis c : colis) {
		    	if(c.getNumCommande().equals(element.getNumCommande())) {
		    		iterator.remove();
		    	}
		    }
		}
		
		return bl;
	}

	@Override
	public List<Colis> findColisFomBonRamassage(String idBl) {
		BonRamassage bl = findBonRamassageByNom(idBl);
		return new ArrayList<Colis>(bl.getColis());
	}

	@Override
	public BonRamassage updateStatutBonRamassage(String nom, String statut) throws BonRamassageException {
		LOGGER.info("Modification statut BR {} au statut {} ",nom,statut);
		
		BonRamassage br = findBonRamassageByNom(nom);
		
		//br.setDateModification(new Date());
		if(!br.getStatut().equals(Constants.NOUVEAU_BR) ) {
			throw new BonRamassageException("Impossible de modifier un br après ramassage!");
		}
		
		/*if(br.getStatut().equalsIgnoreCase(statut)) {
			throw new BonRamassageException("Impossible de modifier un br avec le meme statut!");
		}*/
		
		
		return bonRamassageRepository.save(br);
	}

	@Override
	public List<Historique> getHistoriqueBonRamassage(String nom) {
		return historiqueRepository.findHistoriqueBonRamassageByNom(nom);
	}

	@Override
	public Page<Historique> getHistoriqueBonRamassage(String nom, int page, int size) {
		return historiqueRepository.findHistoriqueBonRamassageByNom2(nom,PageRequest.of(page, size));
	}

	

}
