package com.xpr.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.xpr.entities.BonRetour;
import com.xpr.entities.Client;

@RepositoryRestResource(collectionResourceRel = "clients", path = "clients")
public interface ClientRepository extends JpaRepository<Client, String>,JpaSpecificationExecutor<Client> {
	
	
	@Query("select c from Client c where c.disabled=false and c.nom like '%'+:nom+'%'")
	public Page<Client> findClientByNom(@Param("nom") String nom, Pageable pageable);
	
	@Query("select c from Client c where c.disabled=false and c.nom  like '%'+:nom+'%' and c.entite.id=:entiteId")
	public Page<Client> findClientByNomAndEntite(@Param("nom") String nom,@Param("entiteId") Long entiteId, Pageable pageable);
	


}
