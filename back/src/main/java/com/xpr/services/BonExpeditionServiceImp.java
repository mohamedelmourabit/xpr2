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
import com.xpr.dao.BonExpeditionRepository;
import com.xpr.dao.HistoriqueRepository;
import com.xpr.entities.BonExpedition;
import com.xpr.entities.Client;
import com.xpr.entities.Colis;
import com.xpr.entities.Historique;
import com.xpr.exceptions.BonExpeditionException;
import com.xpr.exceptions.ColisException;
import com.xpr.utils.Constants;

@Service
public class BonExpeditionServiceImp implements BonExpeditionService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BonExpeditionServiceImp.class);
	
	@Autowired
	private BonExpeditionRepository bonExpeditionRepository;
	
	@Autowired
	private HistoriqueRepository historiqueRepository;

	
	@Override
	public BonExpedition saveBonExpedition(BonExpedition be) throws BonExpeditionException {
		LOGGER.info("Ajout d'un nouveau BE");
		
		if(be.getLigneBonExpeditions().isEmpty()) {
			throw new BonExpeditionException("Erreur création BE sans colis");
		}
		
		//be.setDateCreation(new Date());
		//be.setStatut(Constants.EN_ATTENTE_RAMASSAGE);
		
		be = bonExpeditionRepository.save(be);
		
		/*Historique h =Historique.getHistorique("Ajout nouveau BE: "+be.getNom(), be.getStatut(), "cniTest");
		h.setBonExpedition(be);
		be.getHistoriques().add(h);*/
		
		//historiqueRepository.save(h);
		
		return be;
	}

	@Override
	public BonExpedition findBonExpeditionByNom(String nom) {
		LOGGER.info("Récupération du BE {}",nom );
		return bonExpeditionRepository.findByNom(nom);
	}


	@Override
	public Page<BonExpedition> findAllBonExpeditionByMc(String mc, int page, int size) {
		return bonExpeditionRepository.findByNameStartsWith(mc, PageRequest.of(page, size));
	}

	@Override
	public List<BonExpedition> findAll() {
		return null;
	}

	@Override
	public BonExpedition updateBonExpedition(String nom, BonExpedition bonExpedition) throws BonExpeditionException {
		LOGGER.info("Modification du BR {} ",nom);
		
		BonExpedition bl = bonExpeditionRepository.findByNom(nom);
		bonExpedition.setNom(nom);
		//bonExpedition.setDateModification(new Date());
		if(!bonExpedition.getStatut().equals(Constants.NOUVEAU_BR) ) {
			throw new BonExpeditionException("Impossible de modifer un br après ramassage");
		}
	
		bonExpedition = bonExpeditionRepository.save(bonExpedition);
		//bonExpedition.setDateModification(new Date());
		/*Historique h =Historique.getHistorique("Modification BR: "+nom, bonExpedition.getStatut(), "cniTest");
		h.setBonExpedition(bonExpedition);
		bonExpedition.getHistoriques().add(h);
		
		historiqueRepository.save(h);*/
		return bonExpedition;
	}

	@Override
	public void deleteBonExpedition(String nom) throws BonExpeditionException {
		
		
		LOGGER.info("Suppression du BR {} ",nom);
		BonExpedition bl = bonExpeditionRepository.findByNom(nom);
		
		if(!bl.getStatut().equals(Constants.NOUVEAU_BR) ) {
			throw new BonExpeditionException("Impossible de supprimer un bl après ramassage");
		}
		//bl.setDateModification(new Date());
		//bl.setStatut(Constants.ANNULE);
		
		/*Historique h =Historique.getHistorique("Suppression BR: "+nom, bl.getStatut(), "cniTest");
		bl.getHistoriques().add(h);
		bl.setDisabled(true);
		
		if(bl!=null) {
			bonExpeditionRepository.save(bl);
			h.setBonExpedition(bl);
			historiqueRepository.save(h);
		}*/
	}

	@Override
	public BonExpedition generateBonExpedition(List<Colis> colis) {
		LOGGER.info("Generate nouveau BR avec {} colis ",colis.size());
		BonExpedition bl = new BonExpedition();
		//bl.setDateCreation(new Date());
		if(colis!=null && colis.get(0)!=null) {
			Client client = colis.get(0).getClient();
			//bl.setClient(client);
		}
		//bl.setColis(new HashSet<Colis>(colis));
		/*bl.setDateModification(new Date());
		bl = bonExpeditionRepository.save(bl);
		Historique h =Historique.getHistorique("Ajout nouveau BR: "+bl.getNom(), bl.getStatut(), "cniTest");
		h.setBonExpedition(bl);
		bl.getHistoriques().add(h);
		
		historiqueRepository.save(h);*/
		
		return bl;
	}


	
	
	@Override
	public int getCountBonExpeditions() {
		return bonExpeditionRepository.getCountBonExpeditions();
	}

	@Override
	public BonExpedition addColisToBonExpedition(String idBr, List<Colis> colis) throws BonExpeditionException {
		BonExpedition bl = findBonExpeditionByNom(idBr);
		//bl.setDateModification(new Date());
		if(!bl.getStatut().equals(Constants.NOUVEAU_BR) ) {
			throw new BonExpeditionException("Impossible de modifier un bl après ramassage");
		}
		
		/*Historique h =Historique.getHistorique("Ajout " + colis.size()+" colis to BR: "+bl.getNom(), bl.getStatut(), "cniTest");
		h.setBonExpedition(bl);
		*/
		///bl.getColis().addAll(colis);
		
		//historiqueRepository.save(h);
		return bl;
	}

	@Override
	public BonExpedition deleteColisFomBonExpedition(String idBr, List<Colis> colis) {
		
		/*BonExpedition bl = findBonExpeditionByNom(idBr);
		bl.setDateModification(new Date());
		Iterator<Colis> iterator = bl.getColis().iterator();
		while (iterator.hasNext()) {
		    Colis element = iterator.next();
		    for(Colis c : colis) {
		    	if(c.getNumCommande().equals(element.getNumCommande())) {
		    		iterator.remove();
		    	}
		    }
		}
		
		return bl;*/
		return null;
	}

	@Override
	public List<Colis> findColisFomBonExpedition(String idBl) {
		BonExpedition bl = findBonExpeditionByNom(idBl);
		//return new ArrayList<Colis>(bl.getColis());
		return null;
	}

	@Override
	public BonExpedition updateStatutBonExpedition(String nom, String statut) throws BonExpeditionException {
		LOGGER.info("Modification statut BR {} au statut {} ",nom,statut);
		
		BonExpedition br = findBonExpeditionByNom(nom);
		
		//br.setDateModification(new Date());
		if(!br.getStatut().equals(Constants.NOUVEAU_BR) ) {
			throw new BonExpeditionException("Impossible de modifier un br après ramassage!");
		}
		
		/*if(br.getStatut().equalsIgnoreCase(statut)) {
			throw new BonExpeditionException("Impossible de modifier un br avec le meme statut!");
		}*/
		
		
		return bonExpeditionRepository.save(br);
	}

	@Override
	public List<Historique> getHistoriqueBonExpedition(String nom) {
		return historiqueRepository.findHistoriqueBonExpeditionByNom(nom);
	}

	@Override
	public Page<Historique> getHistoriqueBonExpedition(String nom, int page, int size) {
		return historiqueRepository.findHistoriqueBonExpeditionByNom2(nom,PageRequest.of(page, size));
	}

	

	

}
