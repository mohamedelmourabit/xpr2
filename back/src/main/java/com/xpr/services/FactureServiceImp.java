package com.xpr.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.xpr.dao.FactureRepository;
import com.xpr.entities.Colis;
import com.xpr.entities.Facture;
import com.xpr.entities.LigneFacture;
import com.xpr.exceptions.FactureException;
import com.xpr.utils.Constants;

@Service
public class FactureServiceImp implements FactureService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FactureServiceImp.class);
	
	@Autowired
	private FactureRepository factureRepository;

	
	@Override
	public Facture saveFacture(Facture facture) {
		
		LOGGER.info("Ajout nouvelle facture ");
		
		double montantTotalNet=0.0;
		
		if(facture.getType().equals(Constants.RETOURNE)) {
			facture.setTotalCrbt(0);
			facture.setTotalFrais(0);
			facture.setTotalNet(0);
		}
		
		if(facture.getLigneFactures()!=null) {
		
		
			int qte=0;
		for(LigneFacture c : facture.getLigneFactures()) {
			double prix=0.0;
			
			if(c.getLigneColis().getProduit()!=null) {
				 prix = c.getLigneColis().getProduit().getPrixVente();
				
			}else {
				prix = c.getLigneColis().getVariante().getPrixVente();
				
			}
			 qte = qte + c.getLigneColis().getQteLivre();
			
			montantTotalNet = montantTotalNet + prix;
		}
		facture.setTotalNet(montantTotalNet);
		
			facture.setNbrColis(qte);
		}else {
			facture.setTotalCrbt(0);
			facture.setTotalFrais(0);
			facture.setTotalNet(0);
			facture.setNbrColis(0);
		}
		
		
		return factureRepository.save(facture);
	}

	@Override
	public Page<Facture> findMyFactureByMc(String email, String mc, int page, int size) {
		LOGGER.info("Récuperation des factures par email {} et mot clé {}",email,mc);
		return factureRepository.findByClientAndNameFactures(email, mc, PageRequest.of(page, size));
	}

	@Override
	public Page<Facture> findAllFacturesByMc(String mc, int page, int size) {
		LOGGER.info("Récuperation des factures par  mot clé {}",mc);
		return factureRepository.getAllPageable(mc,PageRequest.of(page, size));
	}

	@Override
	public List<Facture> findAll() {
		LOGGER.info("Récuperation des factures");
		return factureRepository.findAll();
	}

	@Override
	public Facture updateFacture(String name, Facture facture) throws FactureException {
		LOGGER.info("Modification de la facture {} ",name);
		Facture f = factureRepository.findById(name).orElse(null);
		
		if(f!=null) {
			double montantTotalNet=0.0;
			
			if(facture.getType().equals(Constants.RETOURNE)) {
				facture.setTotalCrbt(0);
				facture.setTotalFrais(0);
				facture.setTotalNet(0);
			}
			

			if(facture.getLigneFactures()!=null) {
			
			
				int qte=0;
			for(LigneFacture c : facture.getLigneFactures()) {
				double prix=0.0;
				
				if(c.getLigneColis().getProduit()!=null) {
					 prix = c.getLigneColis().getProduit().getPrixVente();
					
				}else {
					prix = c.getLigneColis().getVariante().getPrixVente();
					
				}
				 qte = qte + c.getLigneColis().getQteLivre();
				
				montantTotalNet = montantTotalNet + prix;
			}
			facture.setTotalNet(montantTotalNet);
			
				facture.setNbrColis(qte);
			}else {
				facture.setTotalCrbt(0);
				facture.setTotalFrais(0);
				facture.setTotalNet(0);
				facture.setNbrColis(0);
			}
		}else {
			throw new FactureException("Facture "+name+" introuvable ");
		}
		
		facture.setName(name);
		
		
		return factureRepository.save(facture);
	}

	@Override
	public void deleteFacture(String name) {
		LOGGER.info("Suppression de la facture {} ",name);
		Facture facture = factureRepository.findById(name).orElse(null);
		if(facture!=null) {
			factureRepository.delete(facture);
		}
		
		
	}

	@Override
	public Facture findFacture(String name) {
		
		return factureRepository.findById(name).orElse(null);
	}

	@Override
	public Page<Facture> findAllFacturesByClient(String emailClient, int page, int size) {
		return factureRepository.getAllFacturesByClient(emailClient, PageRequest.of(page, size));
	}

	@Override
	public Page<Facture> findAllFacturesByUtilisateurs(String emailUtilisateur, int page, int size) {
		return factureRepository.getAllFacturesUtilisateur(emailUtilisateur, PageRequest.of(page, size));
	}
	
	@Override
	public int getCountFactures() {
		return factureRepository.getCountFactures();
	}


}
