package com.xpr.dao;

import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.xpr.dao.helper.CustomJPARepository;
import com.xpr.entities.Utilisateur;




public interface UtilisateurRepository extends CustomJPARepository<Utilisateur, String> {
	
	
	@Query("SELECT u FROM Utilisateur u LEFT JOIN FETCH u.profiles p LEFT JOIN FETCH p.autorisations a WHERE u.email=:email")
	Utilisateur findUserWithAuthorisationsByUsername(@Param("email") String email);
	
	@Query("select u from Utilisateur u where u.email = :email")
	public Utilisateur findByEmail(@Param("email") String email);
		
	public Utilisateur findByCni(String cni);
	

	@Query("select u from Utilisateur u where u.email like :text")
	public Page<Utilisateur> searchUser(@Param("text") String text, Pageable pageable);
	
	@Query("select u from Utilisateur u order by u.email ASC")
	public Page<Utilisateur> getAll( Pageable pageable);
	
	@Query(
	        "SELECT u.email FROM Utilisateur u  LEFT JOIN u.client c WHERE c.ice IN " +
	        "(SELECT c.ice from Utilisateur u LEFT JOIN u.client c WHERE u.email=:email)"
	    )
	    Set<String> getAllUsersForClient(String email);
	
	@Query(
	        "SELECT u.email FROM Utilisateur u  LEFT JOIN u.entite c WHERE c.id IN " +
	        "(SELECT c.id from Utilisateur u LEFT JOIN u.entite c WHERE u.email=:email)"
	    )
	    Set<String> getAllUsersForEntite(String email);
	
	
	
	
	

}
