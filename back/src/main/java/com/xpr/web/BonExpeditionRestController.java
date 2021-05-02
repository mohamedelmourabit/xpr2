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

import com.xpr.dao.BonExpeditionRepository;
import com.xpr.dao.BonRamassageRepository;
import com.xpr.dao.core.controller.SecuredCRUDController;
import com.xpr.dao.helper.CustomJPARepository;
import com.xpr.entities.BonExpedition;
import com.xpr.entities.BonRamassage;
import com.xpr.entities.Colis;
import com.xpr.entities.Historique;
import com.xpr.exceptions.BonExpeditionException;
import com.xpr.services.BonExpeditionService;

@RestController
@RequestMapping(path="/bonExpedition")
public class BonExpeditionRestController extends SecuredCRUDController<BonExpedition, String> {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BonExpeditionRestController.class);
	
	@Autowired
	private BonExpeditionService bonExpeditionService;
	
	@Autowired
    public void setRepository(BonExpeditionRepository repository) {
        this.repository = (CustomJPARepository<BonExpedition, String>) repository;
    }
	
	@RequestMapping(value="/getHistoriqueBonExpedition/{nom}",method=RequestMethod.GET)
	public List<Historique> getHistoriqueBonExpedition(String nom) {
		return bonExpeditionService.getHistoriqueBonExpedition(nom);
	}
	@RequestMapping(value="/getHistoriqueBonExpeditionPagination/{nom}",method=RequestMethod.GET)
	public Page<Historique> getHistoriqueBonExpedition(String nom, @RequestParam(name="page",defaultValue="0")int page,@RequestParam(name="size",defaultValue="5")int size) {
		return bonExpeditionService.getHistoriqueBonExpedition(nom, page, size);
	}
	@RequestMapping(value="/addColisToBonExpedition/{blId}",method=RequestMethod.PUT)
	public BonExpedition addColisToBonExpedition(@PathVariable String blId,@RequestBody  List<Colis> colis) throws BonExpeditionException {
		return bonExpeditionService.addColisToBonExpedition(blId, colis);
	}
	@RequestMapping(value="/deleteColisFomBonExpedition/{blId}",method=RequestMethod.DELETE)
	public BonExpedition deleteColisFomBonExpedition(@PathVariable String blId,@RequestBody  List<Colis> colis) {
		return bonExpeditionService.deleteColisFomBonExpedition(blId, colis);
	}
	@RequestMapping(value="/findBonExpeditionById/{nom}",method=RequestMethod.GET)
	public BonExpedition findBonExpeditionByNom(@PathVariable String nom) {
		return bonExpeditionService.findBonExpeditionByNom(nom);
	}
	

	@RequestMapping(value="/findAllBonExpeditionByMc",method=RequestMethod.GET)
	public Page<BonExpedition> findAllBonExpeditionByMc(@RequestParam(name="mc")String mc, @RequestParam(name="page",defaultValue="0")int page,@RequestParam(name="size",defaultValue="5")int size) {
		return bonExpeditionService.findAllBonExpeditionByMc(mc, page, size);
	}

	@RequestMapping(value="/updateStatutBonExpedition/{nom}",method=RequestMethod.PUT)
	public BonExpedition updateStatutBonExpedition(@PathVariable String nom,@RequestBody String statut) throws BonExpeditionException {
		return bonExpeditionService.updateStatutBonExpedition(nom, statut);
	}

	@RequestMapping(value="/deleteBonExpedition/{nom}",method=RequestMethod.DELETE)
	public void deleteBonExpedition(@PathVariable String nom) throws BonExpeditionException {
		bonExpeditionService.deleteBonExpedition(nom);
	}


	@RequestMapping(value="/generateBonExpedition",method=RequestMethod.POST)
	public BonExpedition generateBonExpedition(@RequestBody List<Colis> colis) {
		return bonExpeditionService.generateBonExpedition(colis);
	}

	@RequestMapping(value="/getBonExpeditions",method=RequestMethod.GET)
	public List<BonExpedition> getBonExpeditions(){
		return bonExpeditionService.findAll();
	}
	
	@RequestMapping(value="/bonExpeditions/{nom}",method=RequestMethod.GET)
	public BonExpedition getBonExpedition(@PathVariable String nom) {
		return bonExpeditionService.findBonExpeditionByNom(nom);
	}
	
	@RequestMapping(value="/editBonExpedition/{nom}",method=RequestMethod.PUT)
	public BonExpedition editBonExpedition(@PathVariable String nom,@RequestBody BonExpedition c) throws BonExpeditionException {
		return bonExpeditionService.updateBonExpedition(nom, c);
	}
	
	@PostMapping(value="/bonExpeditions")
	public BonExpedition saveBonExpedition(@RequestBody BonExpedition bl) throws BonExpeditionException {
		return bonExpeditionService.saveBonExpedition(bl);
	}
	
	@RequestMapping(value="/supprimerBonExpedition/{nom}",method=RequestMethod.DELETE)
	public boolean supprimerBonExpedition(@PathVariable String nom) throws BonExpeditionException {
		 bonExpeditionService.deleteBonExpedition(nom);
		 return true;
	}
	
	@RequestMapping(value="/chercherBonExpeditions",method=RequestMethod.GET)
	public Page<BonExpedition> chercherBonExpedition(@RequestParam(name="mc",defaultValue="") String mc,@RequestParam(name="page",defaultValue="0")int page,@RequestParam(name="size",defaultValue="5")int size) {
		return bonExpeditionService.findAllBonExpeditionByMc(mc, page, size);
	}

	@Override
	public void setIdentifier(String id, BonExpedition object) {
		object.setNom(id);
		
	}
	


}
