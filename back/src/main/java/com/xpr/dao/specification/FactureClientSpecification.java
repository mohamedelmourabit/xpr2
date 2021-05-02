package com.xpr.dao.specification;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import com.xpr.dto.BonRamassageSearch;
import com.xpr.dto.BonRetourSearch;
import com.xpr.dto.ClientSearch;
import com.xpr.dto.ColisSearch;
import com.xpr.dto.FactureClientSearch;
import com.xpr.dto.LivreurSearch;
import com.xpr.dto.RamasseurSearch;
import com.xpr.entities.BonRamassage;
import com.xpr.entities.BonRetour;
import com.xpr.entities.Client;
import com.xpr.entities.Colis;
import com.xpr.entities.FactureClient;
import com.xpr.entities.Livreur;
import com.xpr.entities.Ramasseur;


public class FactureClientSpecification implements Specification<FactureClient> {
	
	private FactureClientSearch factureClientSearch;
	
	
	public FactureClientSpecification(FactureClientSearch factureClientSearch) {
		this.factureClientSearch = factureClientSearch;
	}

	@Override
	public Predicate toPredicate(Root<FactureClient> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		final List<Predicate> predicates = new ArrayList<Predicate>();
		
		predicates.add(cb.equal(root.get("disabled"),false));
		
		
           
		
		return cb.and(predicates.toArray(new Predicate[predicates.size()]));
	}

	
}
