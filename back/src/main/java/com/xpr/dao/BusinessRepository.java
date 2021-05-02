package com.xpr.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.xpr.entities.Business;


public interface BusinessRepository extends JpaRepository<Business, Long> {
	
	public Business findByNom(String nom);
	
	@Query("SELECT b FROM Business b where b.nom=:x")
	public List<Business> findBusinessByName(@Param("x")String nomBusiness);
	
	@Query("select b from Business b where b.client.nom=:client order by b.nom ASC")
	public Page<Business> searchBusinessByClient(@Param("client") String client, Pageable pageable);
	
	@Query("select b from Business b order by b.nom ASC")
	public Page<Business> getAll( Pageable pageable);
	

}
