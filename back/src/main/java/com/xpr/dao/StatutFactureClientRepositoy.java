package com.xpr.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.xpr.entities.StatutFacture;
import com.xpr.entities.StatutFactureClient;

@RepositoryRestResource(collectionResourceRel = "statutFacture", path = "statutFacture")
public interface StatutFactureClientRepositoy extends JpaRepository<StatutFacture, Long> {
		

	@RestResource(path="all", rel="all")
	@Query("select s from StatutFacture s order by s.libelle ASC")
	public List<StatutFacture> getAllStatutFactureClient();
}
