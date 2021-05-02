package com.xpr.services;

import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Page;

import com.xpr.entities.Autorisation;
import com.xpr.entities.Profile;
import com.xpr.entities.Utilisateur;



public interface AccountService {
	
	public Utilisateur saveUtilisateur(Utilisateur appUser);
	
	public Utilisateur findUtilisateurByEmail(String email);
	
	public Utilisateur findUtilisateurByCni(String cni);
	
	public Profile addAuthorisationToProfile(String authorisation,String profileName);
	
	
	
	public Utilisateur addProfileToUtilisateur(String cni,long profileId);
	
	public Utilisateur removeProfileToUtilisateur(String cni,long profileId);
	
	public Set<Profile> findProfilesByUsers(String cni);
	
	public List<Profile> getAllProfiles();
	
	public List<Autorisation> getAllAutorisations();
	
	public Page<Autorisation> getAllAutorisations(int page,int size);
	
	public Page<Autorisation> findAutorisationByProfile(String profile,int page,int size);
	
	public Profile addProfile(Profile profile);
	
	public Autorisation saveAuthorisation(String authorisationName);
	
	public List<Autorisation> findAutorisationUtilisateur(String cni);
	
	public List<Autorisation> findAutorisationByProfile(String profile);
	
	
	
	
	
	

}
