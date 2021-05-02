package com.xpr.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.xpr.entities.Contrat;


@RepositoryRestResource(collectionResourceRel = "contrats", path = "contrats")
public interface ContratRepository extends JpaRepository<Contrat, Long>,JpaSpecificationExecutor<Contrat> {
		

}
