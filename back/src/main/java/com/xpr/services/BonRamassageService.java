package com.xpr.services;

import java.util.List;
import org.springframework.data.domain.Page;
import com.xpr.entities.BonRamassage;
import com.xpr.entities.Colis;
import com.xpr.entities.Historique;
import com.xpr.exceptions.BonRamassageException;


public interface BonRamassageService {
	
	public BonRamassage saveBonRamassage(BonRamassage bl) throws BonRamassageException;
	
	public BonRamassage addColisToBonRamassage(String blId,List<Colis> colis) throws BonRamassageException;
	
	public BonRamassage deleteColisFomBonRamassage(String blId,List<Colis> colis);
	
	public List<Colis> findColisFomBonRamassage(String blId);

	public BonRamassage findBonRamassageByNom(String nom);

	public Page<BonRamassage> findMyBonRamassageByMc(String cni, String mc, int page, int size);

	public Page<BonRamassage> findAllBonRamassageByMc(String mc, int page, int size);

	public List<BonRamassage> findAll();

	public BonRamassage updateBonRamassage(String nom, BonRamassage bonRamassage) throws BonRamassageException;

	public BonRamassage updateStatutBonRamassage(String nom, String staut) throws BonRamassageException;
	
	public void deleteBonRamassage(String nom) throws BonRamassageException;
	
	public BonRamassage generateBonRamassage(List<Colis> colis);
	
	public Page<BonRamassage> findAllBonRamassagesByClient(String cnilient, int page, int size);
	
	public Page<BonRamassage> findAllBonRamassagesByUtilisateurs(String cniUtilisateur, int page, int size);

	public int getCountBonRamassages();
	
	public List<Historique> getHistoriqueBonRamassage(String nom);
	
	public Page<Historique> getHistoriqueBonRamassage(String nom, int page,int size);
}
