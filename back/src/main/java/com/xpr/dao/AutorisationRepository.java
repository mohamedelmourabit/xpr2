package com.xpr.dao;

import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.xpr.dao.helper.CustomJPARepository;
import com.xpr.entities.Autorisation;

@RepositoryRestResource(collectionResourceRel = "autorisations", path = "autorisations")
public interface AutorisationRepository extends CustomJPARepository<Autorisation, Long> {
	
	public Autorisation findByAuthName(String authName);
	
	@Query("select a from Autorisation a order by id ASC")
	public Page<Autorisation> getAllAutorisations(Pageable pageable);

	
	
	Set<Autorisation> findByUri(String uri);

	@Query(value="SELECT DISTINCT a.auth_name FROM autorisations a " +
	            "JOIN profiles_autorisations pa ON pa.autorisation_id = a.id " +
	            "JOIN profiles p ON p.id = pa.profile_id " +
	            "JOIN utilisateurs_profiles up ON up.profile_id = p.id " +
	            "JOIN utilisateur u ON u.email = up.utilisateurs_email WHERE u.email=:email", nativeQuery=true)
	Set<String> findAutorisationByUser(@Param("email") String email);
}
