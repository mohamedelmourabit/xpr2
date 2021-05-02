package com.xpr.dao;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.xpr.dao.helper.CustomJPARepository;
import com.xpr.entities.BonExpedition;
import com.xpr.entities.BonRamassage;



public interface BonExpeditionRepository extends CustomJPARepository<BonExpedition, String>,JpaSpecificationExecutor<BonExpedition> {
	
	public BonExpedition findByNom(String nom);
	
	@Query("select count(b) from BonExpedition b")
	public int getCountBonExpeditions();
	
	@Query("select b from BonExpedition b order by b.createdDate DESC")
	public Page<BonExpedition> getAll(Pageable pageable);
	
	@Query("select b from BonExpedition b where b.createdBy =:emailUtilisateur and b.disabled=false order by b.createdDate DESC")
	public Page<BonExpedition> getAllBonExpeditionsUtilisateur(@Param("emailUtilisateur")String emailUtilisateur,Pageable pageable);


	@Query("select b from BonExpedition b where b.nom like '%'+:nom+'%' order by b.createdDate DESC")
	public Page<BonExpedition> findByNameStartsWith(@Param("nom") String nom, Pageable pageable);
	

	
}
