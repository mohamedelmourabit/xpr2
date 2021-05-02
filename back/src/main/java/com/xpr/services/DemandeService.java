package com.xpr.services;

import java.util.List;
import org.springframework.data.domain.Page;
import com.xpr.entities.Demande;

public interface DemandeService {
	
	public Demande saveDemande(Demande demande);

	public Demande findDemandeByNomDemande(String nomDemande);

	public Page<Demande> findAllDemandesByMc(String mc, int page, int size);

	public List<Demande> findAll();

	public Demande updateDemande(String nomDemande, Demande demande);

	public void deleteDemande(String nomDemande);
	
	public Page<Demande> findAllDemandesByClient(String emailClient, int page, int size);
	
	public Page<Demande> findAllDemandesByUtilisateurs(String emailUtilisateur, int page, int size);
	
	public int getCountDemandes();

}
