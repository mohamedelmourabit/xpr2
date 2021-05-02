package com.xpr.services;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.xpr.dao.ProduitStockClientRepository;
import com.xpr.entities.ProduitStockClient;



@Service
public class StockServiceImp implements StockService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(StockServiceImp.class);
	
	@Autowired
	private ProduitStockClientRepository produitStockClientepository;


	@Override
	public ProduitStockClient saveStock(ProduitStockClient entity) {
		return produitStockClientepository.save(entity);
	}

	@Override
	public List<ProduitStockClient> findStockByClientAndVarianteSku(String iceClient, String sku) {
		return produitStockClientepository.findStockByClientAndVarianteSku(iceClient, sku);
	}

	@Override
	public List<ProduitStockClient> findStockByClientAndVarianteSkuAndVille(String iceClient, String sku, String ville) {
		return produitStockClientepository.findStockByClientAndVarianteSkuAndVille(iceClient, sku, ville);
	}

	@Override
	public Page<ProduitStockClient> findAll(Pageable pageable) {
		return produitStockClientepository.findAll(pageable);
	}

	@Override
	public List<ProduitStockClient> findStockVarianteSku(String sku) {
		return produitStockClientepository.findStockVarianteSku(sku);
	}
	@Override
	public List<ProduitStockClient> findStockByAgenceAndVarianteSku(Long idAgence, String sku) {
		return produitStockClientepository.findStockByAgenceAndVarianteSku(idAgence, sku);
	}

	
	@Override
	public Optional<ProduitStockClient> findById(Long id) {
		return produitStockClientepository.findById(id);
	}


	@Override
	public List<ProduitStockClient> findStockByClientAndProduitNature(String iceClient, String nature) {
		return produitStockClientepository.findStockByClientAndProduitNature(iceClient, nature);
	}

	
	@Override
	public List<ProduitStockClient> findStockByClientAndAgence(String iceClient, long agenceId) {
		return produitStockClientepository.findStockByClientAndAgence(iceClient, agenceId);
	}
	
	@Override
	public List<ProduitStockClient> findStockDisponibleByClient(String iceClient) {
		return null;// produitStockClientepository.findStockDisponibleByClient(iceClient);
	}
	
	@Override
	public List<ProduitStockClient> findStockDisponibleByAgence(long idAgence) {
		return produitStockClientepository.findStockDisponibleByAgence(idAgence);
	}
	@Override
	public List<ProduitStockClient> findStockByClient(String iceClient) {
		return produitStockClientepository.findStockByClient(iceClient);
	}
	
	@Override
	public List<ProduitStockClient> findStockByAgence(long idAgence) {
		return produitStockClientepository.findStockByAgence(idAgence);
	}
	
	@Override
	public List<ProduitStockClient> findStockDisponibleByClientAndAgence(String iceClient, long agenceId) {
		return produitStockClientepository.findStockDisponibleByClientAndAgence(iceClient, agenceId);
	}

	
	

	
	


}
