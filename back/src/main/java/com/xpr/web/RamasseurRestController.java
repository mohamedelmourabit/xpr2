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

import com.xpr.entities.Ramasseur;
import com.xpr.services.RamasseurService;

@RestController
@RequestMapping(path="/ramasseur")
public class RamasseurRestController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RamasseurRestController.class);
	
	@Autowired
	private RamasseurService ramasseurService;
	
	@RequestMapping(value="/ramasseurs",method=RequestMethod.GET)
	public List<Ramasseur> getRamasseurs(){
		return ramasseurService.findAll();
	}
	
	@RequestMapping(value="/ramasseurs/{cni}",method=RequestMethod.GET)
	public Ramasseur getRamasseur(@PathVariable String cni) {
		return ramasseurService.findRamasseurByCni(cni);
	}
	
	@RequestMapping(value="/ramasseurs/{nom}",method=RequestMethod.PUT)
	public Ramasseur editRamasseur(@PathVariable String cni,@RequestBody Ramasseur ramasseur) {
		
		return ramasseurService.updateRamasseur(cni, ramasseur);
	}
	
	@PostMapping(value="/ramasseurs")
	public Ramasseur saveRamasseur(@RequestBody Ramasseur bl) {
		return ramasseurService.saveRamasseur(bl);
	}
	
	@RequestMapping(value="/ramasseurs",method=RequestMethod.DELETE)
	public boolean supprimerRamasseur(@RequestBody String cni) {
		 ramasseurService.deleteRamasseur(cni);
		 return true;
	}
	
	@RequestMapping(value="/chercherRamasseurs",method=RequestMethod.GET)
	public Page<Ramasseur> chercherRamasseur(@RequestParam(name="mc",defaultValue="") String mc,@RequestParam(name="page",defaultValue="0")int page,@RequestParam(name="size",defaultValue="5")int size) {
		return ramasseurService.findAllRamasseurByMc(mc, page, size);
	}
}
