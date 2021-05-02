package com.xpr.services;

import java.util.List;
import org.springframework.data.domain.Page;
import com.xpr.entities.BonRetour;
import com.xpr.entities.Colis;
import com.xpr.entities.Historique;
import com.xpr.entities.LigneBonRetour;
import com.xpr.entities.LigneColis;
import com.xpr.exceptions.BonRetourException;


public interface BonRetourService {
	
	public BonRetour saveBonRetour(BonRetour bl) throws BonRetourException;
	
	public BonRetour addLigneColisToBonRetour(String blId,List<LigneColis> ligneColisRetourne) throws BonRetourException;
	
	public BonRetour deleteLigneColisFomBonRetour(String blId,List<LigneColis> ligneColisRetourne);
	
	List<LigneBonRetour> findLigneBonRetourFomBonRetour(String idBl);
	public BonRetour findBonRetourByNom(String nom);

	public Page<BonRetour> findMyBonRetourByMc(String cni, String mc, int page, int size);

	public Page<BonRetour> findAllBonRetourByMc(String mc, int page, int size);

	public List<BonRetour> findAll();

	public BonRetour updateBonRetour(String nom, BonRetour bonRetour) throws BonRetourException;

	public BonRetour updateStatutBonRetour(String nom, String staut) throws BonRetourException;
	
	public void deleteBonRetour(String nom) throws BonRetourException;
	
	public BonRetour generateBonRetour(List<LigneColis> ligneColisRetourne);
	
	public Page<BonRetour> findAllBonRetoursByClient(String cnilient, int page, int size);
	
	public Page<BonRetour> findAllBonRetoursByUtilisateurs(String cniUtilisateur, int page, int size);

	public int getCountBonRetours();
	
	public List<Historique> getHistoriqueBonRetour(String nom);
	
	public Page<Historique> getHistoriqueBonRetour(String nom, int page,int size);
}
