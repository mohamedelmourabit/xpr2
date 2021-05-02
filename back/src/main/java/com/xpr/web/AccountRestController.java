package com.xpr.web;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xpr.dao.UtilisateurRepository;
import com.xpr.dao.annotation.XprRole;
import com.xpr.dao.core.controller.SecuredCRUDController;
import com.xpr.dto.RegisterForm;
import com.xpr.entities.Autorisation;
import com.xpr.entities.Profile;
import com.xpr.entities.Utilisateur;
import com.xpr.services.AccountService;


@RestController
@RequestMapping(path="/account")
public class AccountRestController extends SecuredCRUDController<Utilisateur, String> {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AccountRestController.class);
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
    public void setRepository(UtilisateurRepository repository) {
        this.repository = repository;
    }
	
	@Override
	public void setIdentifier(String id, Utilisateur object) {
		object.setEmail(id);
		
	}

   
	
	@RequestMapping(value="/getAllProfiles",method=RequestMethod.GET)
	 @XprRole(role = XprRole.Role.LIST, view= "ModelViews.FullView")
	public List<Profile> getAllProfiles() {
		return accountService.getAllProfiles();
	}

	@RequestMapping(value="/getAllAutorisations",method=RequestMethod.GET)
	 @XprRole(role = XprRole.Role.LIST, view= "ModelViews.FullView")
	public List<Autorisation> getAllAutorisations() {
		return accountService.getAllAutorisations();
	}

	@RequestMapping(value="/getAllAutorisationsByProfile/{profile}",method=RequestMethod.GET)
	 @XprRole(role = XprRole.Role.LIST, view= "ModelViews.FullView")
	public Page<Autorisation> findAutorisationByProfile(@PathVariable String profile, @RequestParam(name="page",defaultValue="0")int page,@RequestParam(name="size",defaultValue="5")int size) {
		return accountService.findAutorisationByProfile(profile, page, size);
	}

	@RequestMapping(value="/saveProfile",method=RequestMethod.POST)
	 @XprRole(role = XprRole.Role.LIST, view= "ModelViews.FullView")
	public Profile addProfile(@RequestBody Profile profile) {
		return accountService.addProfile(profile);
	}

	@PostMapping("/saveUtilisateur")
	 @XprRole(role = XprRole.Role.LIST, view= "ModelViews.FullView")
	public Utilisateur saveUtilisateur(@RequestBody Utilisateur appUser) {
		return accountService.saveUtilisateur(appUser);
	}
	
	@RequestMapping(value="/findUtilisateurByEmail",method=RequestMethod.GET)
	 @XprRole(role = XprRole.Role.LIST, view= "ModelViews.FullView")
	public Utilisateur findUtilisateurByEmail(@RequestParam(name="email")String email) {
		return accountService.findUtilisateurByEmail(email);
	}
	@RequestMapping(value="/findUtilisateurByCni",method=RequestMethod.GET)
	 @XprRole(role = XprRole.Role.LIST, view= "ModelViews.FullView")
	public Utilisateur findUtilisateurByCni(@RequestParam(name="cni")String cni) {
		return accountService.findUtilisateurByCni(cni);
	}

	@RequestMapping(value="/addAutorisationToProfile",method=RequestMethod.PUT)
	 @XprRole(role = XprRole.Role.LIST, view= "ModelViews.FullView")
	public Profile addAutorisationToProfile(@RequestParam(name="authorisationName")String authorisation, @RequestParam(name="profileName")String profileName) {
		return accountService.addAuthorisationToProfile(authorisation, profileName);
	}

	

	@RequestMapping(value="/addProfileToUtilisateur",method=RequestMethod.PUT)
	 @XprRole(role = XprRole.Role.LIST, view= "ModelViews.FullView")
	public Utilisateur addProfileToUtilisateur(@RequestParam(name="cni")String cni,@RequestParam(name="profileId") long profileId) {
		return accountService.addProfileToUtilisateur(cni, profileId);
	}
	
	@RequestMapping(value="/removeProfileToUtilisateur",method=RequestMethod.PUT)
	 @XprRole(role = XprRole.Role.LIST, view= "ModelViews.FullView")
	public Utilisateur removeProfileToUtilisateur(@RequestParam(name="cni")String cni,@RequestParam(name="profileId") long profileId) {
		return accountService.removeProfileToUtilisateur(cni, profileId);
	}

	@RequestMapping(value="/findProfilesByUtilisateur",method=RequestMethod.GET)
	 @XprRole(role = XprRole.Role.LIST, view= "ModelViews.FullView")
	public Set<Profile> findProfilesByUsers(@RequestParam(name="cni")String cni) {
		return accountService.findProfilesByUsers(cni);
	}

	@RequestMapping(value="/saveAutorisation",method=RequestMethod.POST)
	 @XprRole(role = XprRole.Role.LIST, view= "ModelViews.FullView")
	public Autorisation saveAutorisation(String authorisationName) {
		return accountService.saveAuthorisation(authorisationName);
	}



	@RequestMapping(value="/findAutorisationUtilisateur",method=RequestMethod.GET)
	public List<Autorisation> findAutorisationUtilisateur(@RequestParam(name="cni")String cni) {
		return accountService.findAutorisationUtilisateur(cni);
	}

	@RequestMapping(value="/findAutorisationByProfile",method=RequestMethod.GET)
	public List<Autorisation> findAutorisationByProfile(@RequestParam(name="profile")String profile) {
		return accountService.findAutorisationByProfile(profile);
	}


	@PostMapping("/register")
	public Utilisateur register(@RequestBody RegisterForm userForm) {
		if(!userForm.getPassword().equals(userForm.getRepassword())) throw new RuntimeException("You must confirm your password");
		
		Utilisateur user = accountService.findUtilisateurByCni(userForm.getCni());
		if(user !=null) throw new RuntimeException("Invalid CNI un utilisateur existant dispose déjà de ce numéro CNI");
		
		Utilisateur user2 = accountService.findUtilisateurByEmail(userForm.getEmail());
		if(user2 !=null) throw new RuntimeException("Invalid Email un utilisateur existant dispose déjà de cet email");
		
		if(userForm.getCni()==null || userForm.getCni().isEmpty()) {
			throw new RuntimeException("Veuillez saisir la carte d'identité obligatoirement !");	
		}
		
		if(userForm.getCni()==null || userForm.getEmail().isEmpty()) {
			throw new RuntimeException("Veuillez saisir l'addresse mail obligatoirement !");	
		}
		if(userForm.getCni()==null || !userForm.getPassword().equals(userForm.getRepassword())) {
			throw new RuntimeException("les mots de passe saisie ne sont pas correspondant !");	
		}
		
		Utilisateur utilisateur = new Utilisateur(userForm.getEmail(),userForm.getPassword());
		utilisateur.setCni(userForm.getCni());
		accountService.saveUtilisateur(utilisateur);
		//accountService.addProfileToUser(utilisateur.getEmail(),"");
		return utilisateur;
	}
	
	@PostMapping("/autorisation")
	public Autorisation addAutorisation(@RequestBody String autorisationName) {
		
		return accountService.saveAuthorisation(autorisationName);
		
	}
	
	
	
	
	@PostMapping("/profileToUser")
	public Utilisateur addProfileToUser(@RequestParam(name="cni") String cni,@RequestParam(name="profileId") Long profileId) {
		
		Utilisateur user = accountService.findUtilisateurByCni(cni);
	
			if(user!=null) {
				accountService.addProfileToUtilisateur(cni, profileId);
				
		}else {
			throw new RuntimeException("Utilisateur introuvable !");
		}
		
		return user;
		
	}
	
	@PostMapping("/loginByCni")
	public Utilisateur checkConnection(@RequestParam(name="cni") String cni,@RequestParam(name="password") String password) {
		
		Utilisateur user = accountService.findUtilisateurByCni(cni);
		
		if(user!=null && user.getPassword().equals(password)) {
			return user;
		}else {
			throw new RuntimeException("Email où Mot de passe incorrecte !");
		}
		
	}
	
	@PostMapping("/loginByEmail")
	public Utilisateur checkConnectionByEmail(@RequestParam(name="email") String email,@RequestParam(name="password") String password) {
		
		Utilisateur user = accountService.findUtilisateurByEmail(email);
		
		return user;
		
	}
	
	@PostMapping("/authorisations")
	public List<Autorisation> getAuthorisation(@RequestParam(name="cni") String cni) {
		
		Set<Autorisation> autorisations = new HashSet<Autorisation>();
		
		Utilisateur user = accountService.findUtilisateurByCni(cni);
		
		if(user!=null) {
			
			autorisations.addAll(accountService.findAutorisationUtilisateur(cni));
			
			return new ArrayList<Autorisation>(autorisations);
		}else {
			throw new RuntimeException("Utilisateur introuvable !");
		}
		
		
		
	}
	
	@PostMapping("/authorisationsByProfile")
	public List<Autorisation> getAuthorisationByProfile(@RequestParam(name="profile") String profile) {
		
		return accountService.findAutorisationByProfile(profile);
		
		
		
	}

	
	
	
	

}
