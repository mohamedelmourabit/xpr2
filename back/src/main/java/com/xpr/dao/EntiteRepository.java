package com.xpr.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.xpr.entities.Entite;


@RepositoryRestResource(collectionResourceRel = "entites", path = "entites")
public interface EntiteRepository extends JpaRepository<Entite, Long>,JpaSpecificationExecutor<Entite> {
		

}
