package com.xpr.dao;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.xpr.dao.helper.CustomJPARepository;
import com.xpr.entities.BonRamassage;
import com.xpr.entities.Colis;




public interface BonRamassageRepository extends CustomJPARepository<BonRamassage, String>,JpaSpecificationExecutor<BonRamassage>  {
	
	public BonRamassage findByNom(String nom);
	
	@Query("SELECT b FROM BonRamassage b WHERE b.nom=:x")
	public List<BonRamassage> findBonRamassage(@Param("x")String nomBonRamassage);
	
	@Query("select b from BonRamassage b where b.client.nom=:client order by b.nom ASC")
	public Page<BonRamassage> searchBonRamassageByClient(@Param("client") String client, Pageable pageable);
	
	@Query("select b from BonRamassage b order by b.nom ASC")
	public Page<BonRamassage> getAll( Pageable pageable);
	
	@Query("select b from BonRamassage b join b.client l where l.ice =:ice and b.disabled=false order by b.createdDate DESC")
	public Page<BonRamassage> getAllBonRamassageByClient(@Param("ice")String ice,Pageable pageable);
	
	@Query("select b from BonRamassage b where b.createdBy =:emailUtilisateur and b.disabled=false order by b.createdDate DESC")
	public Page<BonRamassage> getAllBonRamassagesUtilisateur(@Param("emailUtilisateur")String cniUtilisateur,Pageable pageable);

	
	@Query("select b from BonRamassage b where b.nom like '%'+:nom+'%' order by b.createdDate DESC")
	public Page<BonRamassage> findByNameStartsWith(@Param("nom") String nom, Pageable pageable);
	
	@Query("select b from BonRamassage b where b.nom like '%'+:nom+'%' and b.client.ice=:ice order by b.createdDate DESC")
	public Page<BonRamassage> findByCniAndNomStartsWith(@Param("nom") String nom,@Param("ice") String ice, Pageable pageable);
	
	@Query("SELECT b.colis FROM BonRamassage b WHERE b.nom=:x")
	public List<Colis> findColisInBonRamassage(@Param("x")String nomBonRamassage);
	
	@Query("select count(b) from BonRamassage b")
	public int getCountBonRamassages();
	
}
