package com.xpr.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import com.xpr.entities.StatutBonExpedition;


@RepositoryRestResource(collectionResourceRel = "statutBonExpedition", path = "statutBonExpedition")
public interface StatutBonExpeditionRepositoy extends JpaRepository<StatutBonExpedition, Long> {
		

	@RestResource(path="all", rel="all")
	@Query("select s from StatutBonExpedition s order by s.libelle ASC")
	public List<StatutBonExpedition> getAllStatutBonExpedition();
}
