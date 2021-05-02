package com.xpr.web;

import java.util.List;
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

import com.xpr.entities.Demande;
import com.xpr.services.DemandeService;

@RestController
@RequestMapping(path="/demande")
public class DemandeRestController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DemandeRestController.class);
	
	@Autowired
	private DemandeService demandeService;
	
	

	@RequestMapping(value="/demandes",method=RequestMethod.GET)
	public List<Demande> getDemandes(){
		return demandeService.findAll();
	}
	
	@RequestMapping(value="/demandes/{nom}",method=RequestMethod.GET)
	public Demande getDemande(@PathVariable String nom) {
		return demandeService.findDemandeByNomDemande(nom);
	}
	
	@RequestMapping(value="/demandes/{nom}",method=RequestMethod.PUT)
	public Demande editDemande(@PathVariable String nom,@RequestBody Demande c) {
		
		return demandeService.updateDemande(nom, c);
	}
	
	@PostMapping(value="/demandes")
	public Demande saveDemande(@RequestBody Demande bl) {
		return demandeService.saveDemande(bl);
	}
	
	@RequestMapping(value="/demandes/{nom}",method=RequestMethod.DELETE)
	public boolean supprimerDemande(@PathVariable String nom) {
		 demandeService.deleteDemande(nom);
		 return true;
	}
	
	@RequestMapping(value="/chercherDemandes",method=RequestMethod.GET)
	public Page<Demande> chercherDemande(@RequestParam(name="mc",defaultValue="") String mc,@RequestParam(name="page",defaultValue="0")int page,@RequestParam(name="size",defaultValue="5")int size) {
		return demandeService.findAllDemandesByMc(mc, page, size);
	}
	@RequestMapping(value="/chercherDemandesByClient",method=RequestMethod.GET)
	public Page<Demande> findAllDemandesByClient(@RequestParam(name="email") String emailClient,@RequestParam(name="page",defaultValue="0") int page,@RequestParam(name="size",defaultValue="5") int size) {
		return demandeService.findAllDemandesByClient(emailClient, page, size);
	}

	@RequestMapping(value="/chercherDemandesByUtilisateurs",method=RequestMethod.GET)
	public Page<Demande> findAllDemandesByUtilisateurs(@RequestParam(name="email") String emailUtilisateur,@RequestParam(name="page",defaultValue="0") int page,@RequestParam(name="size",defaultValue="5") int size) {
		return demandeService.findAllDemandesByUtilisateurs(emailUtilisateur, page, size);
	}
}
