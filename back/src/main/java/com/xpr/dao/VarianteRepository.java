package com.xpr.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.xpr.entities.Produit;
import com.xpr.entities.Variante;

@RepositoryRestResource(collectionResourceRel = "variantes", path = "variantes")
public interface VarianteRepository extends JpaRepository<Variante, Long>,JpaSpecificationExecutor<Variante>  {
	
	public Variante findBySku(String sku);
	
	/*@Query("SELECT v FROM Variante v WHERE v.produit.colis.client.nom =:c and v.produit.nomProduit=:p and v.sku=:x order v.qte DESC")
	public List<Variante> findVariante(@Param("c")String nomClient, @Param("p")String nomProduit,@Param("x")String sku);
	
	@Query("SELECT v FROM Variante v WHERE v.produit.colis.client.nom =:c and v.produit.nomProduit=:p and v.sku=:x order v.qte DESC")
	public Page<Variante> searchVarianteByClient(@Param("c")String nomClient, @Param("p")String nomProduit,@Param("x")String sku, Pageable pageable);
	
	@Query("select v from Variante v order by b.nom ASC")
	public Page<Variante> getAll( Pageable pageable);*/
	

}
