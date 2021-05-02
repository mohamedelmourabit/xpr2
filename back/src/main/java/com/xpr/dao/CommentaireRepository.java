package com.xpr.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.xpr.entities.Commentaire;

@RepositoryRestResource(collectionResourceRel = "commentaires", path = "commentaires")
public interface CommentaireRepository extends JpaRepository<Commentaire, Long> {
	
	
	@Query("SELECT b FROM Commentaire b  WHERE b.colis.numCommande=:x order by b.dateCreation DESC")
	public List<Commentaire> findCommentaireByColis(@Param("x")String numCommande);
	
	
	@Query("SELECT b FROM Commentaire b  WHERE b.colis.numCommande=:x order by b.dateCreation DESC")
	public Page<Commentaire> findCommentaireByColis2(@Param("x")String numCommande,Pageable pageable);

	

}
