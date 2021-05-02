package com.xpr.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.xpr.entities.Facture;
import com.xpr.entities.FactureClient;

@RepositoryRestResource(collectionResourceRel = "facturesClient", path = "facturesClient")
public interface FactureClientRepository extends JpaRepository<FactureClient, String>,JpaSpecificationExecutor<FactureClient>  {
		
	@Query("select f from FactureClient f where f.name like '%'+:name+'%' order by f.createdDate DESC ")
	public Page<FactureClient> getAllPageable( @Param("name") String name,Pageable pageable);
	
	@Query("select count(f) from FactureClient f")
	public int getCountFactureClients();
	
	@Query("select f from FactureClient f  where f.client.nom like '%'+:name+'%' and f.client.ice =:ice order by f.createdDate DESC ")
	public Page<FactureClient> findByClientAndNameFactureClients(@Param("ice") String ice,@Param("name") String name, Pageable pageable);
	
	@Query("select f from FactureClient f where f.disabled = false order by f.createdDate DESC ")
	public Page<FactureClient> getAll(Pageable pageable);
	
	@Query("select f from FactureClient f where f.client.ice =:ice and f.disabled=false order by f.createdDate DESC")
	public Page<FactureClient> getAllFactureClientsByClient(@Param("ice")String ice,Pageable pageable);
	
	@Query("select f from FactureClient f join f.creerPar l where l.email=:emailUtilisateur and f.disabled=false order by f.createdDate DESC")
	public Page<FactureClient> getAllFactureClientsUtilisateur(@Param("emailUtilisateur")String emailUtilisateur,Pageable pageable);


}
