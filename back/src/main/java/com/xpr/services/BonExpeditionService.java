package com.xpr.services;

import java.util.List;
import org.springframework.data.domain.Page;
import com.xpr.entities.BonExpedition;
import com.xpr.entities.Colis;
import com.xpr.entities.Historique;
import com.xpr.exceptions.BonExpeditionException;


public interface BonExpeditionService {
	
	public BonExpedition saveBonExpedition(BonExpedition bl) throws BonExpeditionException;
	
	public BonExpedition addColisToBonExpedition(String blId,List<Colis> colis) throws BonExpeditionException;
	
	public BonExpedition deleteColisFomBonExpedition(String blId,List<Colis> colis);
	
	public List<Colis> findColisFomBonExpedition(String blId);

	public BonExpedition findBonExpeditionByNom(String nom);

	public Page<BonExpedition> findAllBonExpeditionByMc(String mc, int page, int size);

	public List<BonExpedition> findAll();

	public BonExpedition updateBonExpedition(String nom, BonExpedition bonRamassage) throws BonExpeditionException;

	public BonExpedition updateStatutBonExpedition(String nom, String staut) throws BonExpeditionException;
	
	public void deleteBonExpedition(String nom) throws BonExpeditionException;
	
	public BonExpedition generateBonExpedition(List<Colis> colis);
	
	//public Page<BonExpedition> findAllBonExpeditionsByUtilisateurs(String cniUtilisateur, int page, int size);

	public int getCountBonExpeditions();
	
	public List<Historique> getHistoriqueBonExpedition(String nom);
	
	public Page<Historique> getHistoriqueBonExpedition(String nom, int page,int size);
}
