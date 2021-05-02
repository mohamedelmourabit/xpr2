package com.xpr.web;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xpr.dao.BonRamassageRepository;
import com.xpr.dao.ColisRepository;
import com.xpr.dao.StatutBonRamassageRepositoy;
import com.xpr.dao.annotation.XprRole;
import com.xpr.dao.core.controller.SecuredCRUDController;
import com.xpr.dao.helper.CustomJPARepository;
import com.xpr.dao.specification.BonRamassageSpecification;
import com.xpr.dao.specification.ColisSpecification;
import com.xpr.dto.BonRamassageSearch;
import com.xpr.dto.ColisSearch;
import com.xpr.entities.BonRamassage;
import com.xpr.entities.Client;
import com.xpr.entities.Colis;
import com.xpr.entities.Entite;
import com.xpr.entities.Historique;
import com.xpr.entities.Livreur;
import com.xpr.entities.StatutBonRamassage;
import com.xpr.entities.StatutColis;
import com.xpr.entities.Utilisateur;
import com.xpr.entities.Ville;
import com.xpr.exceptions.BonRamassageException;
import com.xpr.services.BonRamassageService;

@RestController
@RequestMapping(path="/bonRamassage")
public class BonRamassageRestController extends SecuredCRUDController<BonRamassage, String> {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BonRamassageRestController.class);
	
	@Autowired
	private BonRamassageService bonRamassageService;
	
	
	
	@Autowired
	private StatutBonRamassageRepositoy statutBonRamassageRepositoy;
	
	@Autowired
    public void setRepository(BonRamassageRepository repository) {
        this.repository = (CustomJPARepository<BonRamassage, String>) repository;
    }
	
	@RequestMapping(value="/getHistoriqueBonRamassage/{nom}",method=RequestMethod.GET)
	public List<Historique> getHistoriqueBonRamassage(String nom) {
		return bonRamassageService.getHistoriqueBonRamassage(nom);
	}
	@RequestMapping(value="/getHistoriqueBonRamassagePagination/{nom}",method=RequestMethod.GET)
	public Page<Historique> getHistoriqueBonRamassage(String nom, @RequestParam(name="page",defaultValue="0")int page,@RequestParam(name="size",defaultValue="5")int size) {
		return bonRamassageService.getHistoriqueBonRamassage(nom, page, size);
	}
	@RequestMapping(value="/addColisToBonRamassage/{blId}",method=RequestMethod.PUT)
	public BonRamassage addColisToBonRamassage(@PathVariable String blId,@RequestBody  List<Colis> colis) throws BonRamassageException {
		return bonRamassageService.addColisToBonRamassage(blId, colis);
	}
	@RequestMapping(value="/deleteColisFomBonRamassage/{blId}",method=RequestMethod.DELETE)
	public BonRamassage deleteColisFomBonRamassage(@PathVariable String blId,@RequestBody  List<Colis> colis) {
		return bonRamassageService.deleteColisFomBonRamassage(blId, colis);
	}
	@RequestMapping(value="/findBonRamassageById/{nom}",method=RequestMethod.GET)
	public BonRamassage findBonRamassageByNom(@PathVariable String nom) {
		return bonRamassageService.findBonRamassageByNom(nom);
	}
	@RequestMapping(value="/findMyBonRamassageByMc",method=RequestMethod.GET)
	public Page<BonRamassage> findMyBonRamassageByMc(@RequestParam(name="cni")String cni, @RequestParam(name="mc") String mc, @RequestParam(name="page",defaultValue="0")int page,@RequestParam(name="size",defaultValue="5")int size) {
		return bonRamassageService.findMyBonRamassageByMc(cni, mc, page, size);
	}

	@RequestMapping(value="/findAllBonRamassageByMc",method=RequestMethod.GET)
	public Page<BonRamassage> findAllBonRamassageByMc(@RequestParam(name="mc")String mc, @RequestParam(name="page",defaultValue="0")int page,@RequestParam(name="size",defaultValue="5")int size) {
		return bonRamassageService.findAllBonRamassageByMc(mc, page, size);
	}

	@RequestMapping(value="/updateStatutBonRamassage/{nom}",method=RequestMethod.PUT)
	public BonRamassage updateStatutBonRamassage(@PathVariable String nom,@RequestBody String statut) throws BonRamassageException {
		return bonRamassageService.updateStatutBonRamassage(nom, statut);
	}

	@RequestMapping(value="/deleteBonRamassage/{nom}",method=RequestMethod.DELETE)
	public void deleteBonRamassage(@PathVariable String nom) throws BonRamassageException {
		bonRamassageService.deleteBonRamassage(nom);
	}


	@RequestMapping(value="/generateBonRamassage",method=RequestMethod.POST)
	public BonRamassage generateBonRamassage(@RequestBody List<Colis> colis) {
		return bonRamassageService.generateBonRamassage(colis);
	}

	@RequestMapping(value="/getBonRamassages",method=RequestMethod.GET)
	public List<BonRamassage> getBonRamassages(){
		return bonRamassageService.findAll();
	}
	
	@RequestMapping(value="/bonRamassages/{nom}",method=RequestMethod.GET)
	public BonRamassage getBonRamassage(@PathVariable String nom) {
		return bonRamassageService.findBonRamassageByNom(nom);
	}
	
	@RequestMapping(value="/editBonRamassage/{nom}",method=RequestMethod.PUT)
	public BonRamassage editBonRamassage(@PathVariable String nom,@RequestBody BonRamassage c) throws BonRamassageException {
		return bonRamassageService.updateBonRamassage(nom, c);
	}
	
	@PostMapping(value="/bonRamassages")
	public BonRamassage saveBonRamassage(@RequestBody BonRamassage bl) throws BonRamassageException {
		return bonRamassageService.saveBonRamassage(bl);
	}
	
	@RequestMapping(value="/supprimerBonRamassage/{nom}",method=RequestMethod.DELETE)
	public boolean supprimerBonRamassage(@PathVariable String nom) throws BonRamassageException {
		 bonRamassageService.deleteBonRamassage(nom);
		 return true;
	}
	
	@RequestMapping(value="/chercherBonRamassages",method=RequestMethod.GET)
	public Page<BonRamassage> chercherBonRamassage(@RequestParam(name="mc",defaultValue="") String mc,@RequestParam(name="page",defaultValue="0")int page,@RequestParam(name="size",defaultValue="5")int size) {
		return bonRamassageService.findAllBonRamassageByMc(mc, page, size);
	}
	
	@RequestMapping(value="/chercherBonRamassagesByClient",method=RequestMethod.GET)
	public Page<BonRamassage> findAllBonRamassagesByClient(@RequestParam(name="email")String emailClient, int page, int size) {
		return bonRamassageService.findAllBonRamassagesByClient(emailClient, page, size);
	}
	@RequestMapping(value="/chercherBonRamassagesByUtilisateur",method=RequestMethod.GET)
	public Page<BonRamassage> findAllBonRamassagesByUtilisateurs(@RequestParam(name="email")String emailUtilisateur, int page, int size) {
		return bonRamassageService.findAllBonRamassagesByUtilisateurs(emailUtilisateur, page, size);
	}
	
	@RequestMapping(value="/getAllStatutsBonRamassage",method=RequestMethod.GET)
	@XprRole(role = XprRole.Role.LIST, view= "ModelViews.SelectView")
	public List<StatutBonRamassage> getAllStatusColis() {
		return statutBonRamassageRepositoy.getAllStatutBonRamassage();
	}
	
	
	@RequestMapping(value="/listBonRamassages",method=RequestMethod.GET)
	@XprRole(role = XprRole.Role.LIST, view= "ModelViews.FullView")
	public ResponseEntity<Page<BonRamassage>>  getListBonRamassages(@RequestParam(defaultValue="{}", required = false) Map<String,String> params){
		boolean authorized = this.checkEligibility();
		Optional<HttpServletRequest> request = this.getCurrentHttpRequest();
        String role = request.get().getAttribute("role").toString();
        
        Utilisateur user = (Utilisateur) request.get().getAttribute("user");
        
        if(authorized) {
        	
        	 if("CLIENT".equals(role)){
		       	 	params.put("client.ice",user.getClient().getIce());
		       }
	        
		       if("ENTITE".equals(role)){
		    	   params.put("entite.id",user.getEntite().getId()+"");
		       }
		       if("LIVREUR".equals(role)) {
		    	   params.put("livreur.cni",user.getCni());
		       }
		       
		      if("RAMASSEUR".equals(role)) {
		    	   params.put("ramasseur.cni",user.getCni());
		       }
        	
        }else {
			
        	throw new AccessDeniedException("Unauthorized operation");
       
		}
        
        
   		
        BonRamassageSearch bRS = new BonRamassageSearch();
        
        StatutBonRamassage statutBonRamassage = new StatutBonRamassage();
		
		
		if(params.get("statut.code")!=null) {
			
			
			statutBonRamassage.setCode(params.get("statut.code"));
		}
		
		if(params.get("statut.libelle")!=null) {
			
			
			statutBonRamassage.setLibelle(params.get("statut.libelle"));
		}
			
		BonRamassageSpecification bonRamassageSpecification = new BonRamassageSpecification(bRS);
		
        
        
        
		return this.list(params,bonRamassageSpecification);
	}
	@Override
	public void setIdentifier(String id, BonRamassage object) {
		object.setNom(id);
		
	}
	
}
