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
import com.xpr.dto.ColisSearch;
import com.xpr.entities.Colis;
import com.xpr.utils.StringAttributeConverter;


public class ColisSpecification extends GenericSearchSpecification<Colis> implements Specification<Colis> {
	
	private ColisSearch colisSearch;
	
	private StringAttributeConverter stringAttributeConverter;
	
	
	public ColisSpecification(ColisSearch colisSearch) {
		super(null, null);
		this.colisSearch = colisSearch;
		try {
			stringAttributeConverter = new StringAttributeConverter();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Predicate toPredicate(Root<Colis> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		final List<Predicate> predicates = new ArrayList<Predicate>();
		
		//predicates.add(cb.equal(root.get("disabled"),false));
		
		
		if(colisSearch.getMc()!=null) {
			Predicate numCommande = cb.like(root.get("numCommande"), "%"+colisSearch.getMc()+"%");
			
			Predicate codeEnvoi = cb.like(root.get("codeEnvoi"), "%"+colisSearch.getMc()+"%");
			
			Predicate idIntern = cb.like(root.get("idIntern"), "%"+colisSearch.getMc()+"%");
		
			
			Predicate typeLivraison = cb.like(root.get("typeLivraison"), "%"+colisSearch.getMc()+"%");
			
			Predicate nomComplet = cb.like(root.get("nomComplet"), "%"+colisSearch.getMc()+"%");
			
			
		
			Predicate destinataire = cb.like(root.get("destinataire"), "%"+colisSearch.getMc()+"%");
			
			Predicate telephone = cb.like(root.get("telephone"), "%"+colisSearch.getMc()+"%");
			
			Predicate villeDestination = cb.like(root.join("villeDestination").get("nom"), "%"+colisSearch.getMc()+"%");
			
			Predicate secteur = cb.like(root.get("secteur"), "%"+colisSearch.getMc()+"%");
			
			Predicate adresse = cb.like(root.get("adresse"), "%"+colisSearch.getMc()+"%");
			
			Predicate remarque = cb.like(root.get("remarque"), "%"+colisSearch.getMc()+"%");
			
			Predicate clientName = cb.like(root.join("client").get("nom"), "%"+colisSearch.getMc()+"%");
			
			Predicate clientId = cb.like(root.join("client").get("ice"), "%"+colisSearch.getMc()+"%");
			
		
			Predicate statut = cb.like(root.join("statut").get("libelle"), "%"+colisSearch.getMc()+"%");
			
			Predicate produit = cb.like(root.join("ligneColis").join("produit",JoinType.LEFT).get("nom"), "%"+colisSearch.getMc()+"%");
			
			Predicate produitFromVariante = cb.like(root.join("ligneColis").join("variante",JoinType.LEFT).join("produit",JoinType.LEFT).get("nom"), "%"+colisSearch.getMc()+"%");
			
			
			Predicate varianteSku = cb.like(root.join("ligneColis").join("variante",JoinType.LEFT).get("sku"), "%"+colisSearch.getMc()+"%");
			
			Predicate prix = cb.like(root.join("ligneColis").get("prix").as(String.class), "%"+colisSearch.getMc()+"%");
			
			Predicate entiteName = cb.like(root.join("entite").get("nom"), "%"+colisSearch.getMc()+"%");
			
			Predicate entiteId = cb.like(root.join("entite").get("id").as(String.class), "%"+colisSearch.getMc()+"%");
			
			
			predicates.add(cb.or(numCommande,codeEnvoi,idIntern,typeLivraison,
					nomComplet,destinataire,telephone,villeDestination,secteur
					,adresse,clientName,clientId,statut,produit,produitFromVariante,varianteSku,prix,entiteName,entiteId,remarque));
	
			//predicates.add(cb.or(destinataire));	
		}
		
        if(colisSearch.getNumCommande() !=null) {
            predicates.add(cb.equal(root.get("numCommande"),colisSearch.getNumCommande()));
        }
        if(colisSearch.getCodeEnvoi()!=null) {
            predicates.add(cb.equal(root.get("numMarche"),colisSearch.getCodeEnvoi()));
        }
        
        if(colisSearch.getIdIntern()!=null) {
            predicates.add(cb.equal(root.get("idIntern"),colisSearch.getIdIntern()));
        }
        if(colisSearch.getTypeLivraison()!=null) {
            predicates.add(cb.equal(root.get("typeLivraison"),colisSearch.getTypeLivraison()));
        }
        
        if(colisSearch.getNomComplet() !=null) {
            predicates.add(cb.equal(root.get("nomComplet"),colisSearch.getNomComplet()));
        }
        
        if(colisSearch.getDestinataire() !=null) {
            predicates.add(cb.equal(root.get("destinataire"),colisSearch.getDestinataire()));
        }
        
        if(colisSearch.getTelephone() !=null) {
            predicates.add(cb.equal(root.get("nomComplet"),colisSearch.getNomComplet()));
        }
        
        if(colisSearch.getVilleDestination() !=null) {
        	if(colisSearch.getVilleDestination().getNom()!=null) {
        		predicates.add(cb.equal(root.join("villeDestination").get("nom"),colisSearch.getVilleDestination().getNom()));
        	}
        }
        
        if(colisSearch.getSecteur() !=null) {
            predicates.add(cb.equal(root.get("secteur"),colisSearch.getSecteur()));
        }
        
        if(colisSearch.getAdresse() !=null) {
            predicates.add(cb.equal(root.get("adresse"),colisSearch.getAdresse()));
        }
        
        if(colisSearch.getClient() !=null) {
        	
        	
        	if(colisSearch.getClient().getIce()!=null) {
        		 predicates.add(cb.equal(root.join("client").get("ice"),colisSearch.getClient().getIce()));
        	        
        	}
        	if(colisSearch.getClient().getNom()!=null) {
        		 predicates.add(cb.equal(root.join("client").get("nom"),colisSearch.getClient().getNom()));    
        	}
        }
        
        if(colisSearch.getStatutCode() !=null) {
        	
            predicates.add(cb.equal(root.join("statut").get("code"),colisSearch.getStatutCode()));
        }
        
        if(colisSearch.getStatutLibelle() !=null) {
        	
            predicates.add(cb.equal(root.join("statut").get("libelle"),colisSearch.getStatutLibelle()));
        }
        
        if(colisSearch.getProduitName()!=null) {
        	
        	
           predicates.add(cb.equal(root.join("ligneColis").join("produit").get("nom"),colisSearch.getProduitName()));
        		
           predicates.add(cb.equal(root.join("ligneColis").join("variante").join("produit").get("nom"),colisSearch.getProduitName()));
                  			
        }
        
        if(colisSearch.getVarianteName()!=null) {
        	
           predicates.add(cb.equal(root.join("ligneColis").join("variante").get("sku"),colisSearch.getVarianteName()));
               							 
        }
        
        if(colisSearch.getPrix() !=null) {
            predicates.add(cb.equal(root.join("ligneColis").get("prix").as(String.class),colisSearch.getPrix()));
        }
        
        			 
        if(colisSearch.getEntite()!=null) {
        	
        	if(colisSearch.getEntite().getId()!=null) {
       		 predicates.add(cb.equal(root.join("entite").get("id").as(String.class),colisSearch.getEntite().getId()));
                
        	}
        	
        	if(colisSearch.getEntite().getNom()!=null) {
        		 predicates.add(cb.equal(root.join("entite").get("nom").as(String.class),colisSearch.getEntite().getNom()));
                 
        	}
        	
        }
        
        if(colisSearch.getPeriode()!=null) {
        	String firstDate = colisSearch.getPeriode().toString().split("TO")[0];
          	String secondDate = colisSearch.getPeriode().toString().split("TO")[1];
          		
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
