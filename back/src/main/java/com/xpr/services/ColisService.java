package com.xpr.services;

import java.io.File;
import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.xpr.dto.ColisSearch;
import com.xpr.entities.Colis;
import com.xpr.entities.Commentaire;
import com.xpr.entities.Historique;
import com.xpr.entities.LigneColis;
import com.xpr.exceptions.ColisException;
import com.xpr.exceptions.LivreurException;

public interface ColisService {
	
	public Colis saveColis(Colis colis);
	
	public List<Colis> saveColisFromFile(File excelFile,long entiteId,String clientId);

	public Colis findColisById(String numCommande);
	
	public Page<Colis> findAllColisByColisSearch(ColisSearch colisSearch, int page, int size,String sortBy,String sortType);

	public List<Colis> findAll();

	public Colis updateColis(String numCommande, Colis colis) throws ColisException;
	
	public Colis updateStatutColis(String numCommande, String statut) throws ColisException;

	public void deleteColis(String numCommande) throws ColisException;
	
	public List<Colis> affectationColisToLivreur(String cniAffecteur,String emailLivreur,List<Colis> colis) throws LivreurException;
	

	public List<Colis> desaffectationColisToLivreur(String cniAffecteur,String emailLivreur,List<Colis> colis) throws LivreurException;
	

	public List<Colis> affectationColisToRamasseur(String cniAffecteur,String emailLivreur,List<Colis> colis) throws LivreurException;
	
	
	public String generateCodeEnvoie();
	
	
	public Page<Colis> findAllColisByLivreur(String emailLivreur, int page, int size);
	
	public Page<Colis> findAllColisByClient(String ice, int page, int size);
	
	public Page<Colis> findAllColisByUtilisateurs(String emailUtilisateur, int page, int size);
	
	public int getCountColisByStatut(String statut);
	
	public int getCountColis();
	
	public int getColisByStatutAndDate(String statut, Date dateDebut, Date dateFin);
	
	public Page<Colis> getAll(Pageable pageable) ;

	public Page<Colis> getAllColisByLivreur(String emailLivreur, Pageable pageable);

	public Page<Colis> getAllColisByClient(String emailClient, Pageable pageable) ;

	public Page<Colis> getAllColisUtilisateur(Pageable pageable) ;

	public List<Colis> getAllColisWithoutBonRamassage() ;

	public List<Colis> getAllColisWithoutBonExpedition() ;

	public List<Colis> getAllColisWithBonRetour() ;

	public Page<Colis> getAllColisByStatut(String statut, Pageable pageable);
		
	public List<Historique> getHistoriqueColis(String numCommande);
	
	public Page<Historique> getHistoriqueColis(String numCommande, int page,int size);
	
	public List<Commentaire> getCommentairesColis(String numCommande);
	
	public Page<Commentaire> getCommentairesColis(String numCommande, int page,int size);
	
	public Commentaire addCommentaireToColis(String numCommande,Commentaire commentaire);
	
	public void deleteCommentaireToColis(long idCommentaire);
	
	
	public Colis addLignesColisToColis(String nummCommande, List<LigneColis> lignesColis) throws ColisException;
	
	public Colis deleteLignesColisToColis(String nummCommande, List<LigneColis> lignesColis) throws ColisException;

	
	
	
}
