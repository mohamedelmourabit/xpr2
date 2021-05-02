package com.xpr.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.xpr.entities.StatutFactureClient;

@RepositoryRestResource(collectionResourceRel = "statutFactureClient", path = "statutFactureClient")
public interface StatutFactureRepositoy extends JpaRepository<StatutFactureClient, Long> {
		

	@RestResource(path="all", rel="all")
	@Query("select s from StatutFactureClient s order by s.libelle ASC")
	public List<StatutFactureClient> getAllStatutFactureClient();
}
