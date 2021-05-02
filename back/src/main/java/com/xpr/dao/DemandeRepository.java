package com.xpr.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.xpr.entities.Contrat;
import com.xpr.entities.Demande;

@RepositoryRestResource(collectionResourceRel = "demandes", path = "demandes")
public interface DemandeRepository extends JpaRepository<Demande, String>,JpaSpecificationExecutor<Demande> {
	
	
	@Query("select d from Demande d where  d.nom like '%'+:nom+'%' order by d.dateCreation DESC")
	public Page<Demande> findByNameStartsWith(@Param("nom") String nom, Pageable pageable);
	
	@Query("select count(d) from Demande d where d.disabled = false")
	public int getCountDemandes();
	
	@Query("select d from Demande d where d.disabled=false  order by d.dateCreation DESC")
	public Page<Demande> getAll(Pageable pageable);
	
	@Query("select d from Demande d join d.client l where l.ice =:ice and d.disabled=false order by d.dateCreation DESC")
	public Page<Demande> getAllDemandesByClient(@Param("ice")String ice,Pageable pageable);
	
	@Query("select d from Demande d join d.creerPar l where l.email=:emailUtilisateur and d.disabled=false order by d.dateCreation DESC")
	public Page<Demande> getAllDemandesUtilisateur(@Param("emailUtilisateur")String emailUtilisateur,Pageable pageable);

	


}
