package com.xpr.dao;


import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.xpr.entities.Autorisation;
import com.xpr.entities.Profile;



public interface ProfileRepository extends JpaRepository<Profile, Long> {
	

	public Profile findByPrflName(String profileName);
	
	
	@Query(value="SELECT DISTINCT a.prfl_name FROM profile a " +
            "JOIN utilisateurs_profiles up ON up.profile_id = a.id " +
            "JOIN utilisateur u ON u.email = up.utilisateurs_email WHERE u.email=:email", nativeQuery=true)
	Set<String> findProfileByUser(@Param("email") String email);
	
	
	@Query("select p.autorisations from Profile p where p.prflName= :x")
	public List<Autorisation> findAuthoritiesByPrflName(@Param("x") String profileName);
	
	

	@Query("select p.autorisations from Profile p where p.prflName= :profile")
	public Page<Autorisation> findAuthoritiesByPrflName2(@Param("profile") String profile,Pageable pageable);

}
