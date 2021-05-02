package com.xpr.dao;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.xpr.entities.Historique;



public interface HistoriqueRepository extends JpaRepository<Historique, Long> {
	
	
	@Query("SELECT h FROM Historique h  WHERE h.utilisateur.cni=:x order by h.dateCreation ASC")
	public List<Historique> findHistoriqueUtilisateurByCNI(@Param("x")String cni);
	
	@Query("SELECT h FROM Historique h  WHERE h.utilisateur.cni=:x order by h.dateCreation ASC")
	public Page<Historique> findHistoriqueUtilisateurByCNI2(@Param("x")String cni, Pageable pageable);
	
	@Query("SELECT h FROM Historique h  WHERE h.colis.numCommande=:x and h.disabled=false order by h.id ASC")
	public List<Historique> findHistoriqueColisByNom(@Param("x")String numCommande);
	
	
	@Query("SELECT h FROM Historique h WHERE h.colis.numCommande=:x order by h.id ASC")
	public List<Historique> getHistoriqueColisByNumCommande(@Param("x")String numCommande);
	
	
	@Query("SELECT h FROM Historique h  WHERE h.colis.numCommande=:x order by h.id DESC" )
	public Page<Historique> findHistoriqueColisByNumCommande(@Param("x")String numCommande, Pageable pageable);
	
	
	@Query("SELECT h FROM Historique h WHERE h.bonRamassage.nom=:x order by h.id DESC")
	public List<Historique> findHistoriqueBonRamassageByNom(@Param("x")String nomBonRamassage);
	
	@Query("SELECT h FROM Historique h WHERE h.bonRamassage.nom=:x order by h.id DESC")
	public Page<Historique> findHistoriqueBonRamassageByNom2(@Param("x")String nomBonRamassage,Pageable pageable);

	@Query("SELECT h FROM Historique h WHERE h.demande.nom=:x order by h.id DESC")
	public List<Historique> findHistoriqueDemandeByNom(@Param("x")String nomDemande);
	
	@Query("SELECT h FROM Historique h WHERE h.demande.nom=:x order by h.id DESC")
	public Page<Historique> findHistoriqueDemandeByNom2(@Param("x")String nomDemande, Pageable pageable);
	
	
	@Query("SELECT h FROM Historique h WHERE h.bonExpedition.nom=:x")
	public List<Historique> findHistoriqueBonExpeditionByNom(@Param("x")String nomBonRamassage);
	
	@Query("SELECT h FROM Historique h WHERE h.bonExpedition.nom=:x")
	public Page<Historique> findHistoriqueBonExpeditionByNom2(@Param("x")String nomBonRamassage, Pageable pageable);
	
	
	@Query("SELECT h FROM Historique h WHERE h.bonRetour.nom=:x")
	public List<Historique> findHistoriqueBonRetourByNom(@Param("x")String nomBonRetour);
	
	@Query("SELECT h FROM Historique h WHERE h.bonRetour.nom=:x")
	public Page<Historique> findHistoriqueBonRetourByNom2(@Param("x")String nomBonRetour, Pageable pageable);
	
	
	

}
