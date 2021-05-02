package com.xpr.dao.specification;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import com.xpr.dao.helper.GenericSearchSpecification;
import com.xpr.dto.BonExpeditionSearch;
import com.xpr.dto.BonRamassageSearch;
import com.xpr.dto.BonRetourSearch;
import com.xpr.dto.ColisSearch;
import com.xpr.entities.BonExpedition;
import com.xpr.entities.BonRamassage;
import com.xpr.entities.BonRetour;
import com.xpr.entities.Colis;


public class BonExpeditionSpecification extends GenericSearchSpecification<BonExpedition> {
	
	private BonExpeditionSearch bonExpeditionSearch;
	
	
	public BonExpeditionSpecification(BonExpeditionSearch bonExpeditionSearch) {
		super(null, null);
		this.bonExpeditionSearch = bonExpeditionSearch;
	}

	@Override
	public Predicate toPredicate(Root<BonExpedition> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		final List<Predicate> predicates = new ArrayList<Predicate>();
		
		predicates.add(cb.equal(root.get("disabled"),false));
		
		
           
		
		return cb.and(predicates.toArray(new Predicate[predicates.size()]));
	}

	
}
