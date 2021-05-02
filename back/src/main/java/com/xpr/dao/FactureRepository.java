package com.xpr.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.xpr.entities.BonRetour;
import com.xpr.entities.Facture;

@RepositoryRestResource(collectionResourceRel = "factures", path = "factures")
public interface FactureRepository extends JpaRepository<Facture, String>,JpaSpecificationExecutor<Facture> {
		
	@Query("select f from Facture f where f.name like '%'+:name+'%' order by f.createdDate DESC ")
	public Page<Facture> getAllPageable( @Param("name") String name,Pageable pageable);
	
	@Query("select count(f) from Facture f")
	public int getCountFactures();
	
	@Query("select f from Facture f join f.clients c where f.name like '%'+:name+'%' and c.ice =:ice order by f.createdDate DESC ")
	public Page<Facture> findByClientAndNameFactures(@Param("ice") String ice,@Param("name") String name, Pageable pageable);
	
	@Query("select f from Facture f where f.disabled = false order by f.createdDate DESC ")
	public Page<Facture> getAll(Pageable pageable);
	
	@Query("select f from Facture f join f.clients l where l.ice =:ice and f.disabled=false order by f.dateCreation DESC")
	public Page<Facture> getAllFacturesByClient(@Param("ice")String ice,Pageable pageable);
	
	@Query("select f from Facture f join f.creerPar l where l.email=:emailUtilisateur and f.disabled=false order by f.dateCreation DESC")
	public Page<Facture> getAllFacturesUtilisateur(@Param("emailUtilisateur")String emailUtilisateur,Pageable pageable);


}
