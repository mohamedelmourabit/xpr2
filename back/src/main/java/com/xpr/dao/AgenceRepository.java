package com.xpr.dao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.xpr.dao.helper.CustomJPARepository;
import com.xpr.entities.Agence;
import com.xpr.entities.BonExpedition;



@RepositoryRestResource(collectionResourceRel = "agences", path = "agences")
public interface AgenceRepository extends CustomJPARepository<Agence, Long>,JpaSpecificationExecutor<Agence>  {
	
	public Agence findByNom(String nomAgence);
		
	@Query("select a from Agence a where a.nom=:x and a.entite.id =:y ")
	public List<Agence> findByNomAndEntiteId(@Param("x") String nomAgence,@Param("y") Long entiteId);
}
