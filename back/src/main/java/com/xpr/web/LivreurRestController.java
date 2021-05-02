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

import com.xpr.entities.Livreur;
import com.xpr.services.LivreurService;

@RestController
@RequestMapping(path="/livreur")
public class LivreurRestController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LivreurRestController.class);
	
	@Autowired
	private LivreurService livreurService;
	
	@RequestMapping(value="/livreurs",method=RequestMethod.GET)
	public List<Livreur> getLivreurs(){
		return livreurService.findAll();
	}
	
	@RequestMapping(value="/livreurs/{email}",method=RequestMethod.GET)
	public Livreur getLivreur(@PathVariable String email) {
		return livreurService.findLivreurByEmail(email);
	}
	
	@RequestMapping(value="/livreurs/{nom}",method=RequestMethod.PUT)
	public Livreur editLivreur(@PathVariable String nom,@RequestBody Livreur livreur) {
		
		return livreurService.updateLivreur(nom, livreur);
	}
	
	@PostMapping(value="/livreurs")
	public Livreur saveLivreur(@RequestBody Livreur bl) {
		return livreurService.saveLivreur(bl);
	}
	
	@RequestMapping(value="/livreurs/{nom}",method=RequestMethod.DELETE)
	public boolean supprimerLivreur(@PathVariable String nom) {
		 livreurService.deleteLivreur(nom);
		 return true;
	}
	
	@RequestMapping(value="/chercherLivreurs",method=RequestMethod.GET)
	public Page<Livreur> chercherLivreur(@RequestParam(name="mc",defaultValue="") String mc,@RequestParam(name="page",defaultValue="0")int page,@RequestParam(name="size",defaultValue="5")int size) {
		return livreurService.findAllLivreurByMc(mc, page, size);
	}
}
