package com.xpr.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.xpr.entities.StatutBonRamassage;
import com.xpr.entities.StatutColis;
import com.xpr.entities.Ville;

@RepositoryRestResource(collectionResourceRel = "statutBonRamassage", path = "statutBonRamassage")
public interface StatutBonRamassageRepositoy extends JpaRepository<StatutBonRamassage, Long> {
		

	@RestResource(path="all", rel="all")
	@Query("select s from StatutBonRamassage s order by s.libelle ASC")
	public List<StatutBonRamassage> getAllStatutBonRamassage();
}
