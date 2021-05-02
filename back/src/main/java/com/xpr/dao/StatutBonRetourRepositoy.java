package com.xpr.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import com.xpr.entities.StatutBonRetour;


@RepositoryRestResource(collectionResourceRel = "statutBonRetour", path = "statutBonRetour")
public interface StatutBonRetourRepositoy extends JpaRepository<StatutBonRetour, Long> {
		

	@RestResource(path="all", rel="all")
	@Query("select s from StatutBonRetour s order by s.libelle ASC")
	public List<StatutBonRetour> getAllStatutBonRetour();
}
