package com.xpr.services;

import java.util.List;
import org.springframework.data.domain.Page;
import com.xpr.entities.Facture;
import com.xpr.exceptions.FactureException;

public interface FactureService {
	
	public Facture saveFacture(Facture facture);
	
	public Facture findFacture(String name);

	public Page<Facture> findMyFactureByMc(String email,String mc, int page, int size);
	
	public Page<Facture> findAllFacturesByMc(String mc, int page, int size);

	public List<Facture> findAll();

	public Facture updateFacture(String name, Facture facture) throws FactureException;

	public void deleteFacture(String name);
	
	public Page<Facture> findAllFacturesByClient(String emailClient, int page, int size);
	
	public Page<Facture> findAllFacturesByUtilisateurs(String emailUtilisateur, int page, int size);
	
	public int getCountFactures();

}
