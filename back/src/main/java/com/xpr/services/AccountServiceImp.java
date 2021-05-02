package com.xpr.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.xpr.dao.AutorisationRepository;
import com.xpr.dao.ProfileRepository;
import com.xpr.dao.UtilisateurRepository;
import com.xpr.entities.Autorisation;
import com.xpr.entities.Profile;
import com.xpr.entities.Utilisateur;
import com.xpr.sec.UserAuthorityService;

@Service
@Transactional
public class AccountServiceImp implements AccountService, UserDetailsService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AccountServiceImp.class);
	
	@Autowired
	private UtilisateurRepository userRepository;
	
	@Autowired
	private AutorisationRepository authRepository;
	
	@Autowired
	private ProfileRepository profileRepository;
	
	@Autowired
	private  UserAuthorityService userAuthorityService;
	

	@Override
	public Utilisateur findUtilisateurByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public Utilisateur saveUtilisateur(Utilisateur appUser) {
		appUser.setPassword(bCryptPasswordEncoder()
		           .encode(appUser.getPassword()));
		return userRepository.save(appUser);
	}


	@Override
	public Autorisation saveAuthorisation(String authorisationName) {
		return authRepository.save(new Autorisation(null,authorisationName));
	}

	
	
	
	@Override
	public List<Autorisation> findAutorisationUtilisateur(String cni) {
		Utilisateur user = userRepository.findByCni(cni);
		Set<Autorisation> autorisations = new HashSet<Autorisation>();
		
	
		for(Profile profile : findProfilesByUsers(cni)) {
        	for(Autorisation auth : findAutorisationByProfile(profile.getPrflName())) {
        		autorisations.add(auth);
        	}
        }
        
        
		return new ArrayList<Autorisation>(autorisations);
	}

	@Override
	public Utilisateur findUtilisateurByCni(String cni) {
		
		return userRepository.findByCni(cni);
	}

	@Override
	public Profile addAuthorisationToProfile(String authorisation, String profileName) {
		
		Profile p = profileRepository.findByPrflName(profileName);
		Autorisation auth=authRepository.findByAuthName(authorisation);
		p.getAutorisations().add(auth);
		return p;
		
	}

	@Override
	public Set<Profile> findProfilesByUsers(String cni) {
		
		//Set<Profile> profiles = userRepository.findProfilesBy(cni);
		return null;
	}

	@Override
	public Utilisateur addProfileToUtilisateur(String cni, long profileId) {
		
		Utilisateur user = userRepository.findByCni(cni);
		Profile p = new Profile();
		p.setId(profileId);
		user.getProfiles().add(p);
		
		return user;
		
	}

	@Override
	public List<Autorisation> findAutorisationByProfile(String profile) {
		
		return profileRepository.findAuthoritiesByPrflName(profile);

	}

	

	@Override
	public Utilisateur removeProfileToUtilisateur(String cni, long profileId) {
		Utilisateur user = userRepository.findByCni(cni);
		
		user.getProfiles().removeIf(prfl->prfl.getId()==profileId);
		
		return user;

		
	}

	
	@Override
	public List<Profile> getAllProfiles() {
		return profileRepository.findAll();
	}

	@Override
	public List<Autorisation> getAllAutorisations() {
		return (List<Autorisation>) authRepository.findAll();
	}

	@Override
	public Profile addProfile(Profile profile) {
		return profileRepository.save(profile);
	}

	@Override
	public Page<Autorisation> getAllAutorisations(int page, int size) {

		return authRepository.getAllAutorisations(PageRequest.of(page, size));
	}

	@Override
	public Page<Autorisation> findAutorisationByProfile(String profile, int page, int size) {
		return profileRepository.findAuthoritiesByPrflName2(profile, PageRequest.of(page, size));
	}
	
	
	@Bean public BCryptPasswordEncoder bCryptPasswordEncoder() {
	    return new BCryptPasswordEncoder(); 
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Utilisateur user =userRepository.findUserWithAuthorisationsByUsername(username);
		
		
		if (user==null) {
				throw new UsernameNotFoundException("Utilisateur introuvable avec email: " + username);
		}
	
		
		Collection<? extends GrantedAuthority> authorities = this.userAuthorityService.getGrantedAuthorities(username);
		
		
		return new User(user.getCni(),user.getPassword(),authorities);
		
	}
	
	
	

}
