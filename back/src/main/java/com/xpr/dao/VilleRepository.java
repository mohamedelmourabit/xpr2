package com.xpr.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.xpr.entities.Ville;

@RepositoryRestResource(collectionResourceRel = "villes", path = "villes")
public interface VilleRepository extends JpaRepository<Ville, String> {
		

	@RestResource(path="all", rel="all")
	@Query("select v from Ville v order by v.nom ASC")
	public List<Ville> getAllVilles();
}
