package com.xpr.services;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.xpr.entities.ProduitStockClient;


public interface StockService {

	public ProduitStockClient  saveStock(ProduitStockClient entity);

	public List<ProduitStockClient> findStockByClientAndVarianteSku(String iceClient, String sku);

	public List<ProduitStockClient> findStockByClientAndVarianteSkuAndVille(String iceClient, String sku, String ville) ;

	public Page<ProduitStockClient> findAll(Pageable pageable) ;

	public List<ProduitStockClient> findStockVarianteSku(String sku);

	public List<ProduitStockClient> findStockByAgenceAndVarianteSku(Long idAgence, String sku);

	//public List<Stock> findStockByLivreurAndVarianteSku(String cniLivreur, String sku) ;

	public Optional<ProduitStockClient> findById(Long id);

	//public List<Stock> findStockByClientAndLivreurAndVille(String iceClient, String ville);

	public List<ProduitStockClient> findStockByClientAndProduitNature(String iceClient, String nature);

	//public List<Stock> findStockByClientAndLivreur(String iceClient, String livreur);

	public List<ProduitStockClient> findStockByClientAndAgence(String iceClient, long agenceId);

	//public List<Stock> findStockByProduitId(long produitId) ;

	public List<ProduitStockClient> findStockDisponibleByClient(String iceClient);

//	public List<Stock> findStockDisponibleByLivreur(String cniLivreur);

	public List<ProduitStockClient> findStockDisponibleByAgence(long idAgence);

	public List<ProduitStockClient> findStockByClient(String iceClient);

	//public List<Stock> findStockByLivreur(String cniLivreur);

	public List<ProduitStockClient> findStockByAgence(long idAgence);

	//public List<Stock> findStockDisponibleByClientAndLivreur(String iceClient, String livreur);

	public List<ProduitStockClient> findStockDisponibleByClientAndAgence(String iceClient, long agenceId);

}
