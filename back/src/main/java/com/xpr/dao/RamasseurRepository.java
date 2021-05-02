package com.xpr.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.xpr.entities.Livreur;
import com.xpr.entities.Ramasseur;

public interface RamasseurRepository extends JpaRepository<Ramasseur, String>,JpaSpecificationExecutor<Ramasseur> {
	
	
	@Query("select r from Ramasseur r where r.disabled=false and r.email like '%'+:email+'%'")
	public Page<Ramasseur> findByNameStartsWith(@Param("email") String email, Pageable pageable);
	
	@Query("select r from Ramasseur r where r.disabled = false order by r.nom DESC ")
	public Page<Ramasseur> getAll(Pageable pageable);
	
	@Query("select r from Ramasseur r where r.nom =:nom or r.prenom=:prenom order by r.nom ASC ")
	public Ramasseur getRamasseurByNomOrPernom(@Param("nom") String nom ,@Param("prenom") String prenom);
	
	@Query("select count(r) from Ramasseur r")
	public int getCountBonRamasseurs();
	
	@Query("select l from Ramasseur l join l.villes v  on v.nom=:ville where l.disabled = false order by l.nom DESC ")
	public Page<Ramasseur> getRamasseurByVille(@Param("ville") String ville,Pageable pageable);

}
