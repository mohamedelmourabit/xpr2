package com.xpr.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.xpr.entities.ProduitStockClient;



public interface ProduitStockClientRepository extends JpaRepository<ProduitStockClient, Long> {
		
/*	@Query("SELECT s FROM Stock s WHERE s.client.ice=:ice  and s.variante.produit.nom=:x")
	public List<Stock> findStockByClientAndProduitNom(@Param("ice")String iceClient,@Param("x")String nomProduit);
	
	@Query("SELECT s FROM Stock s WHERE s.client.ice=:ice and s.variante.produit.nom=:x and s.ville.nom =:v")
	public List<Stock> findStockByClientAndNomProditAndVille(@Param("ice")String iceClient,@Param("x")String nomProduit,@Param("v")String ville);
	
	@Query("SELECT s FROM Stock s WHERE s.client.ice=:ice  and s.variante.produit.reference=:x")
	public List<Stock> findStockByClientAndProduitReference(@Param("ice")String iceClient,@Param("x")String reference);*/
	
	@Query("SELECT s FROM ProduitStockClient s  WHERE s.client.ice=:ice  and s.variante.sku=:x")
	public List<ProduitStockClient> findStockByClientAndVarianteSku(@Param("ice")String iceClient,@Param("x")String sku);
	
	@Query("SELECT s FROM ProduitStockClient s WHERE s.client.ice=:ice and s.variante.sku=:x and s.ville.nom =:v")
	public List<ProduitStockClient> findStockByClientAndVarianteSkuAndVille(@Param("ice")String iceClient,@Param("x")String sku,@Param("v")String ville);
	

	@Query("SELECT s FROM ProduitStockClient s WHERE s.variante.sku=:x")
	public List<ProduitStockClient> findStockVarianteSku(@Param("x")String sku);
	
	@Query("SELECT s FROM ProduitStockClient s WHERE s.agence.id=:idAgence  and s.variante.sku=:x")
	public List<ProduitStockClient> findStockByAgenceAndVarianteSku(@Param("idAgence")Long idAgence,@Param("x")String sku);
	

	@Query("SELECT s FROM ProduitStockClient s WHERE s.client.ice=:ice  and s.produit.nature=:x")
	public List<ProduitStockClient> findStockByClientAndProduitNature(@Param("ice")String iceClient,@Param("x")String nature);
	
	
	@Query("SELECT s FROM ProduitStockClient s WHERE s.client.ice=:ice and s.agence.id=:id")
	public List<ProduitStockClient> findStockByClientAndAgence(@Param("ice")String iceClient,@Param("id")long agenceId);
	
	
	//@Query("SELECT s FROM Stock s WHERE s.produit.id=:id")
	//public List<Stock> findStockByProduitId(@Param("id")long produitId);
	
	
	@Query("SELECT s FROM ProduitStockClient s WHERE s.agence.id=:idAgence and s.qteNonLivre>0")
	public List<ProduitStockClient> findStockDisponibleByAgence(@Param("idAgence")long idAgence);
	
	@Query("SELECT s FROM ProduitStockClient s WHERE s.client.ice=:ice ")
	public List<ProduitStockClient> findStockByClient(@Param("ice")String iceClient);
	
	
	
	@Query("SELECT s FROM ProduitStockClient s WHERE s.agence.id=:idAgence")
	public List<ProduitStockClient> findStockByAgence(@Param("idAgence")long idAgence);

	@Query("SELECT s FROM ProduitStockClient s WHERE s.client.ice=:ice and s.agence.id=:x and s.qteNonLivre>0")
	public List<ProduitStockClient> findStockDisponibleByClientAndAgence(@Param("ice")String iceClient,@Param("x")long agenceId);
	
	
	
	
	
}
