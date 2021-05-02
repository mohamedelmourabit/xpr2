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
import com.xpr.entities.BonRetour;
import com.xpr.entities.Colis;
import com.xpr.entities.Historique;
import com.xpr.entities.LigneColis;
import com.xpr.exceptions.BonRetourException;
import com.xpr.services.BonRetourService;

@RestController
@RequestMapping(path="/bonRetour")
public class BonRetourRestController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BonRetourRestController.class);
	
	@Autowired
	private BonRetourService bonRetourService;
	
	@RequestMapping(value="/getHistoriqueBonRetour/{nom}",method=RequestMethod.GET)
	public List<Historique> getHistoriqueBonRetour(String nom) {
		return bonRetourService.getHistoriqueBonRetour(nom);
	}
	@RequestMapping(value="/getHistoriqueBonRetourPagination/{nom}",method=RequestMethod.GET)
	public Page<Historique> getHistoriqueBonRetour(String nom, @RequestParam(name="page",defaultValue="0")int page,@RequestParam(name="size",defaultValue="5")int size) {
		return bonRetourService.getHistoriqueBonRetour(nom, page, size);
	}
	@RequestMapping(value="/addColisToBonRetour/{blId}",method=RequestMethod.PUT)
	public BonRetour addColisToBonRetour(@PathVariable String blId,@RequestBody  List<LigneColis> ligneColisRetourne) throws BonRetourException {
		return bonRetourService.addLigneColisToBonRetour(blId, ligneColisRetourne);
	}
	@RequestMapping(value="/deleteColisFomBonRetour/{blId}",method=RequestMethod.DELETE)
	public BonRetour deleteColisFomBonRetour(@PathVariable String blId,@RequestBody  List<LigneColis> ligneColisRetourne) {
		return bonRetourService.deleteLigneColisFomBonRetour(blId, ligneColisRetourne);
	}
	@RequestMapping(value="/findBonRetourById/{nom}",method=RequestMethod.GET)
	public BonRetour findBonRetourByNom(@PathVariable String nom) {
		return bonRetourService.findBonRetourByNom(nom);
	}
	@RequestMapping(value="/findMyBonRetourByMc",method=RequestMethod.GET)
	public Page<BonRetour> findMyBonRetourByMc(@RequestParam(name="cni")String cni, @RequestParam(name="mc") String mc, @RequestParam(name="page",defaultValue="0")int page,@RequestParam(name="size",defaultValue="5")int size) {
		return bonRetourService.findMyBonRetourByMc(cni, mc, page, size);
	}

	@RequestMapping(value="/findAllBonRetourByMc",method=RequestMethod.GET)
	public Page<BonRetour> findAllBonRetourByMc(@RequestParam(name="mc")String mc, @RequestParam(name="page",defaultValue="0")int page,@RequestParam(name="size",defaultValue="5")int size) {
		return bonRetourService.findAllBonRetourByMc(mc, page, size);
	}

	@RequestMapping(value="/updateStatutBonRetour/{nom}",method=RequestMethod.PUT)
	public BonRetour updateStatutBonRetour(@PathVariable String nom,@RequestBody String statut) throws BonRetourException {
		return bonRetourService.updateStatutBonRetour(nom, statut);
	}

	@RequestMapping(value="/deleteBonRetour/{nom}",method=RequestMethod.DELETE)
	public void deleteBonRetour(@PathVariable String nom) throws BonRetourException {
		bonRetourService.deleteBonRetour(nom);
	}


	@RequestMapping(value="/generateBonRetour",method=RequestMethod.POST)
	public BonRetour generateBonRetour(@RequestBody List<LigneColis> LigneColisRetourne) {
		return bonRetourService.generateBonRetour(LigneColisRetourne);
	}

	@RequestMapping(value="/getBonRetours",method=RequestMethod.GET)
	public List<BonRetour> getBonRetours(){
		return bonRetourService.findAll();
	}
	
	@RequestMapping(value="/bonRetours/{nom}",method=RequestMethod.GET)
	public BonRetour getBonRetour(@PathVariable String nom) {
		return bonRetourService.findBonRetourByNom(nom);
	}
	
	@RequestMapping(value="/editBonRetour/{nom}",method=RequestMethod.PUT)
	public BonRetour editBonRetour(@PathVariable String nom,@RequestBody BonRetour c) throws BonRetourException {
		return bonRetourService.updateBonRetour(nom, c);
	}
	
	@PostMapping(value="/bonRetours")
	public BonRetour saveBonRetour(@RequestBody BonRetour bl) throws BonRetourException {
		return bonRetourService.saveBonRetour(bl);
	}
	
	@RequestMapping(value="/supprimerBonRetour/{nom}",method=RequestMethod.DELETE)
	public boolean supprimerBonRetour(@PathVariable String nom) throws BonRetourException {
		 bonRetourService.deleteBonRetour(nom);
		 return true;
	}
	
	@RequestMapping(value="/chercherBonRetours",method=RequestMethod.GET)
	public Page<BonRetour> chercherBonRetour(@RequestParam(name="mc",defaultValue="") String mc,@RequestParam(name="page",defaultValue="0")int page,@RequestParam(name="size",defaultValue="5")int size) {
		return bonRetourService.findAllBonRetourByMc(mc, page, size);
	}
	
	@RequestMapping(value="/chercherBonRetoursByClient",method=RequestMethod.GET)
	public Page<BonRetour> findAllBonRetoursByClient(@RequestParam(name="email")String emailClient, int page, int size) {
		return bonRetourService.findAllBonRetoursByClient(emailClient, page, size);
	}
	@RequestMapping(value="/chercherBonRetoursByUtilisateur",method=RequestMethod.GET)
	public Page<BonRetour> findAllBonRetoursByUtilisateurs(@RequestParam(name="email")String emailUtilisateur, int page, int size) {
		return bonRetourService.findAllBonRetoursByUtilisateurs(emailUtilisateur, page, size);
	}
}
