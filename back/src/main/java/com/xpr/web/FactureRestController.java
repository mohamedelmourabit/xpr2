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
import com.xpr.entities.Facture;
import com.xpr.exceptions.FactureException;
import com.xpr.services.FactureService;

@RestController
@RequestMapping(path="/facture")
public class FactureRestController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FactureRestController.class);
	
	@Autowired
	private FactureService factureService;
	

	@RequestMapping(value="/factures",method=RequestMethod.GET)
	public List<Facture> getFactures(){
		return factureService.findAll();
	}
	
	@RequestMapping(value="/factures/{name}",method=RequestMethod.GET)
	public Facture getFacture(@PathVariable String name) {
		return factureService.findFacture(name);
	}
	
	@RequestMapping(value="/factures/{name}",method=RequestMethod.PUT)
	public Facture editFacture(@PathVariable String name,@RequestBody Facture facture) {
		
		try {
			return factureService.updateFacture(name, facture);
		} catch (FactureException e) {
			LOGGER.error(e.getMessage(),e);
		}
		return null;
	}
	
	@PostMapping(value="/factures")
	public Facture saveFacture(@RequestBody Facture bl) {
		return factureService.saveFacture(bl);
	}
	
	@RequestMapping(value="/factures/{nom}",method=RequestMethod.DELETE)
	public boolean supprimerFacture(@PathVariable String nom) {
		 factureService.deleteFacture(nom);
		 return true;
	}
	
	@RequestMapping(value="/chercherFactures",method=RequestMethod.GET)
	public Page<Facture> chercherFacture(@RequestParam(name="mc",defaultValue="") String mc,@RequestParam(name="page",defaultValue="0")int page,@RequestParam(name="size",defaultValue="5")int size) {
		return factureService.findAllFacturesByMc(mc, page, size);
	}
	
	@RequestMapping(value="/chercherFacturesByClient",method=RequestMethod.GET)
	public Page<Facture> findAllFacturesByClient(@RequestParam(name="email")String emailClient,@RequestParam(name="page",defaultValue="0") int page,@RequestParam(name="page",defaultValue="0") int size) {
		return factureService.findAllFacturesByClient(emailClient, page, size);
	}

	@RequestMapping(value="/chercherFacturesByUtilisateurs",method=RequestMethod.GET)
	public Page<Facture> findAllFacturesByUtilisateurs(@RequestParam(name="email")String emailUtilisateur,@RequestParam(name="page",defaultValue="0") int page,@RequestParam(name="page",defaultValue="0") int size) {
		return factureService.findAllFacturesByUtilisateurs(emailUtilisateur, page, size);
	}
}
