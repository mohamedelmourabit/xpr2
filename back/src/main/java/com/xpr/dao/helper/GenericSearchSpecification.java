package com.xpr.dao.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import com.xpr.entities.Colis;
import com.xpr.utils.StringAttributeConverter;

import javax.persistence.criteria.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;


public class GenericSearchSpecification<T> implements Specification<T> {

    private final Map<String, Object> filters;
    private final Map<String, List<Object>> securityFilter;
    
    
    private StringAttributeConverter stringAttributeConverter;
    
    private List<String> colisColum = Arrays.asList("numCommande","idIntern","nomComplet","codeEnvoi","statut.libelle","destinataire","villeDestination.nom","adresse","telephone","secteur","remarque","ligneColis.prix");

    private List<String> cryptedColumn = Arrays.asList("destinataire","telephone","nomComplet");
    
    public GenericSearchSpecification(Map<String, Object> filters, Map<String, List<Object>> securityFilter) {
        this.filters = filters;
        this.securityFilter = securityFilter;
        try {
			this.stringAttributeConverter = new StringAttributeConverter();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();

        if (filters != null) {
        	
        	
        	
            for (String column : filters.keySet()) {
            	
            	if(column.equals("mc")) {
            		
            		Predicate[] predicateMC = new Predicate[colisColum.size()];
            		if(root.getModel().getName().equals("Colis")) {
            			 int i=0;
            			 for(String col : colisColum) {
            				 Expression<String> expression = buildExpression(col, root);
            				 Predicate predicate;
            				 if(cryptedColumn.contains(col)) {
            					 
            					 
            					 predicate = criteriaBuilder.like(criteriaBuilder.upper(expression), "%" + this.stringAttributeConverter.convertToDatabaseColumn(filters.get(column).toString())+"%"  );
                                 
            				 }else {
            					  predicate = criteriaBuilder.like(criteriaBuilder.upper(expression), "%" + filters.get(column) + "%");
                                 
            				 } 
            				 predicateMC[i] = predicate;
                             i++;
            			 }
            			 
            			
            			 
            			 predicates.add(criteriaBuilder.or(predicateMC)); 
            			
            		}
            		
            		
            	}else {
            	
            	
            	  if(column.equals("periode")) {
                  	
                  	Date dateBefore=null;
                  	Date dateAfter=null;
  					try {
  						
  						String firstDate = filters.get(column).toString().split("TO")[0];
  	                	String secondDate = filters.get(column).toString().split("TO")[1];
  	                	
  						dateBefore = new SimpleDateFormat("yyyy-MM-dd").parse(firstDate);
  					
  						dateAfter = new SimpleDateFormat("yyyy-MM-dd").parse(secondDate); 
  						
  	                	if(dateBefore!=null && dateAfter!=null) {
  	                		Predicate dateBeforePredicate =  criteriaBuilder.greaterThanOrEqualTo(root.<Date>get("createdDate"), dateBefore);
  		                    predicates.add(dateBeforePredicate);
  		                    
  		                    Predicate dateAfterPredicate =  criteriaBuilder.lessThanOrEqualTo(root.<Date>get("createdDate"), dateAfter);
  		                    predicates.add(dateAfterPredicate);
  	                	}
  	                	
  					} catch (ParseException e) {
  						// TODO Auto-generated catch block
  						e.printStackTrace();
  					}  
                  			
                  	
                  }else {
                	  Expression<String> expression = buildExpression(column, root);
                	  Predicate predicate;
                	  if(cryptedColumn.contains(column)) {

                		  predicate = criteriaBuilder.equal(criteriaBuilder.upper(expression),  this.stringAttributeConverter.convertToDatabaseColumn(filters.get(column).toString()));
                	  
                	  }else {
                	  
                		  predicate= criteriaBuilder.equal(criteriaBuilder.upper(expression), filters.get(column));
                     
                	  }
                	  predicates.add(predicate);
                  }

            	}
            }
        }

        if (this.securityFilter != null) {
            for (String column : securityFilter.keySet()) {
                Expression<String> expression = buildExpression(column, root);
                Predicate predicate = expression.in(securityFilter.get(column));
                predicates.add(predicate);
            }
        }

        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }

    private Expression<String> buildExpression(String column, Path<T> path) {
        if (!column.contains("."))
            return path.get(column);

        String[] parts = column.split("\\.");
        int i = 0;
        for (; i < parts.length - 1; i++) {
            path = path.get(parts[i]);
        }

        return path.get(parts[i]);
    }
    
    
}

