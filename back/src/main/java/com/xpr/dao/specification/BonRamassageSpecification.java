package com.xpr.dao.specification;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import com.xpr.dao.helper.GenericSearchSpecification;
import com.xpr.dto.BonRamassageSearch;
import com.xpr.dto.ColisSearch;
import com.xpr.entities.BonRamassage;
import com.xpr.entities.Colis;


public class BonRamassageSpecification extends GenericSearchSpecification<BonRamassage> implements Specification<BonRamassage>  {
	
	private BonRamassageSearch bonRamassageSearch;
	
	
	public BonRamassageSpecification(BonRamassageSearch bonRamassageSearch) {
		super(null, null);
		this.bonRamassageSearch = bonRamassageSearch;
	}

	@Override
	public Predicate toPredicate(Root<BonRamassage> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		final List<Predicate> predicates = new ArrayList<Predicate>();
		

		if(bonRamassageSearch.getMc()!=null) {
			Predicate idBon = cb.like(root.get("nom"), "%"+bonRamassageSearch.getMc()+"%");
			
			Predicate statut = cb.like(root.join("statut").get("libelle"), "%"+bonRamassageSearch.getMc()+"%");
			
			
			predicates.add(cb.or(idBon,statut));
	
			//predicates.add(cb.or(destinataire));	
		}
		
		 if(bonRamassageSearch.getStatut() !=null) {
			 
			 if(bonRamassageSearch.getStatut().getCode()!=null) {
				 predicates.add(cb.equal(root.join("statut").get("code"),bonRamassageSearch.getStatut().getCode()));
			 }
	        	
			 if(bonRamassageSearch.getStatut().getLibelle()!=null) {
				 predicates.add(cb.equal(root.join("statut").get("libelle"),bonRamassageSearch.getStatut().getLibelle()));
			 }
	        	
	            
	        }
        
        
        
       
        if(bonRamassageSearch.getPeriode()!=null) {
        	String firstDate = bonRamassageSearch.getPeriode().toString().split("TO")[0];
          	String secondDate = bonRamassageSearch.getPeriode().toString().split("TO")[1];
          		
				try {
					Date dateBefore = new SimpleDateFormat("yyyy-MM-dd").parse(firstDate);
					Date dateAfter = new SimpleDateFormat("yyyy-MM-dd").parse(secondDate); 
					
		          	if(dateBefore!=null && dateAfter!=null) {
		          		Predicate dateBeforePredicate =  cb.greaterThanOrEqualTo(root.<Date>get("createdDate"), dateBefore);
		                  predicates.add(dateBeforePredicate);
		                  
		                  Predicate dateAfterPredicate =  cb.lessThanOrEqualTo(root.<Date>get("createdDate"), dateAfter);
		                  predicates.add(dateAfterPredicate);
		          	}
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
				
        }
           
		
		return cb.and(predicates.toArray(new Predicate[predicates.size()]));
	}
	
}
