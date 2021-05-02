package com.xpr.dao;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.xpr.entities.BonExpedition;
import com.xpr.entities.BonRetour;
import com.xpr.entities.Colis;
import com.xpr.entities.LigneColis;

public interface BonRetourRepository extends JpaRepository<BonRetour, String>,JpaSpecificationExecutor<BonRetour>  {
	
	public BonRetour findByNom(String nom);
	
	@Query("select count(b) from BonRetour b")
	public int getCountBonRetours();
	
	@Query("select b from BonRetour b where b.nom like '%'+:nom+'%' order by b.createdDate DESC")
	public Page<BonRetour> findByNameStartsWith(@Param("nom") String nom, Pageable pageable);
	
	@Query("select b from BonRetour b where b.nom like '%'+:nom+'%' and b.client.ice=:ice order by b.createdDate DESC")
	public Page<BonRetour> findByCniAndNomStartsWith(@Param("nom") String nom,@Param("ice") String ice, Pageable pageable);
	
	
	@Query("select b from BonRetour b order by b.createdDate DESC")
	public Page<BonRetour> getAll(Pageable pageable);
	
	@Query("select b from BonRetour b join b.client l where l.ice =:ice and b.disabled=false order by b.createdDate DESC")
	public Page<BonRetour> getAllBonRetourByClient(@Param("ice")String ice,Pageable pageable);
	
	@Query("select b from BonRetour b where b.createdBy =:emailUtilisateur and b.disabled=false order by b.createdDate DESC")
	public Page<BonRetour> getAllBonRetoursUtilisateur(@Param("emailUtilisateur")String emailUtilisateur,Pageable pageable);

	
	@Query("select b from BonRetour b join b.client l where l.ice =:ice and b.disabled=false order by b.createdDate DESC")
	public Page<BonRetour> getAllBonExpeditionByClient(@Param("ice")String ice,Pageable pageable);
	
	
	

}
