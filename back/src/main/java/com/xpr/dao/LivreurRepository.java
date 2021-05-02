package com.xpr.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.xpr.entities.FactureClient;
import com.xpr.entities.Livreur;

public interface LivreurRepository extends JpaRepository<Livreur, String>,JpaSpecificationExecutor<Livreur> {
	
	
	@Query("select l from Livreur l where l.disabled=false and l.email like '%'+:email+'%'")
	public Page<Livreur> findByNameStartsWith(@Param("email") String email, Pageable pageable);
	
	@Query("select l from Livreur l where l.disabled = false order by l.nom DESC ")
	public Page<Livreur> getAll(Pageable pageable);
	
	@Query("select l from Livreur l where l.nom =:nom or l.prenom=:prenom order by l.nom ASC ")
	public Livreur getLivreurByNomOrPernom(@Param("nom") String nom ,@Param("prenom") String prenom);
	
	@Query("select count(l) from Livreur l")
	public int getCountBonLivreurs();
	
	@Query("select l from Livreur l join l.villes v  on v.nom=:ville where l.disabled = false order by l.nom DESC ")
	public Page<Livreur> getLivreurByVille(@Param("ville") String ville,Pageable pageable);

}
