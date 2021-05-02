package com.xpr.web;

import java.io.File;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.NotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.multipart.MultipartFile;

import com.xpr.dao.ColisRepository;
import com.xpr.dao.StatutColisRepositoy;
import com.xpr.dao.UtilisateurRepository;
import com.xpr.dao.annotation.XprRole;
import com.xpr.dao.core.controller.SecuredCRUDController;
import com.xpr.dao.helper.CustomJPARepository;
import com.xpr.dao.specification.ColisSpecification;
import com.xpr.dto.ColisSearch;
import com.xpr.entities.Client;
import com.xpr.entities.Colis;
import com.xpr.entities.Commentaire;
import com.xpr.entities.Entite;
import com.xpr.entities.Historique;
import com.xpr.entities.Livreur;
import com.xpr.entities.Ramasseur;
import com.xpr.entities.StatutColis;
import com.xpr.entities.Utilisateur;
import com.xpr.entities.Ville;
import com.xpr.exceptions.ColisException;
import com.xpr.exceptions.LivreurException;
import com.xpr.services.ColisService;

@RestController
@RequestMapping(path="/colis")
public class ColisRestController extends SecuredCRUDController<Colis, String> {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ColisRestController.class);
	
	@Autowired
	private ColisService colisService;
	
	@Autowired
	private ColisRepository colisRepository;
	
	@Autowired
	private StatutColisRepositoy statutColisRepositoy;
	
	@Autowired
    public void setRepository(ColisRepository repository) {
        this.repository = (CustomJPARepository<Colis, String>) repository;
    }
	
	@Override
	public void setIdentifier(String id, Colis object) {
		object.setNumCommande(id);
		
	}
	
	@RequestMapping(value="/getCommentairesColis/{numCommande}",method=RequestMethod.GET)
	public List<Commentaire> getCommentairesColis(String numCommande) {
		return colisService.getCommentairesColis(numCommande);
	}
	
	@RequestMapping(value="/getCommentairesColisPagination/{numCommande}",method=RequestMethod.GET)
	public Page<Commentaire> getCommentairesColis(String numCommande, @RequestParam(name="page",defaultValue="0")int page,@RequestParam(name="size",defaultValue="5")int size) {
		return colisService.getCommentairesColis(numCommande, page, size);
	}
	@RequestMapping(value="/getHistoriqueColis/{numCommande}",method=RequestMethod.GET)
	public List<Historique> getHistoriqueColis(@PathVariable String numCommande) {
		return colisService.getHistoriqueColis(numCommande);
	}
	@RequestMapping(value="/getHistoriqueColisPagination/{numCommande}",method=RequestMethod.GET)
	public Page<Historique> getHistoriqueColis(@PathVariable String numCommande, @RequestParam(name="page",defaultValue="0")int page,@RequestParam(name="size",defaultValue="5")int size) {
		return colisService.getHistoriqueColis(numCommande, page, size);
	}

	@RequestMapping(value="/addCommentaireToColis/{numCommande}",method=RequestMethod.POST)
	public Commentaire addCommentaireToColis(@PathVariable String numCommande,@RequestBody Commentaire commentaire) {
		return colisService.addCommentaireToColis(numCommande, commentaire);
	}

	@RequestMapping(value="/deleteCommentaireToColis/{idCommentaire}",method=RequestMethod.DELETE)
	public void deleteCommentaireToColis(@PathVariable long idCommentaire) {
		colisService.deleteCommentaireToColis(idCommentaire);
	}

	@RequestMapping(value="/updateStatutColis",method=RequestMethod.PUT)
	public Colis updateStatutColis(@RequestParam(name="numCommande") String numCommande, @RequestParam(name="statutId")Long statutId) {
		
		if(isSuperSuperAdmin() || isAdmin() || isSuperAdmin()) {
				   StatutColis statut =  statutColisRepositoy.findById(statutId).orElse(null);
				   if(statut!=null) {
					   		  Colis colis = colisRepository.findById(numCommande).orElse(null);
					   		  if(colis!=null) {
					   			 this.preUpdate(colis);
					   			  colis.setStatut(statut);
					   			  return colisRepository.save(colis);
					   		  }else {
					   			throw new NotFoundException("Not found colis");
					   		  }
					   		  
					   
				   }else {
					   throw new NotFoundException("Not found statut");
				   }
			
		}else {
        	throw new AccessDeniedException("Unauthorized operation");
 	       
		}
		
		
	}

	@RequestMapping(value="/deleteColis/{numCommande}",method=RequestMethod.DELETE)
	public void deleteColis(@PathVariable String numCommande) throws ColisException {
		colisService.deleteColis(numCommande);
	}

	@RequestMapping(value="/affectationMultipleColisAuLivreur/{cniAffecteur}/{cniLivreur}",method=RequestMethod.PUT)
	public List<Colis> affectationColisToLivreur(@PathVariable String cniAffecteur,@PathVariable String cniLivreur,@RequestBody List<Colis> colis) throws LivreurException {
		return colisService.affectationColisToLivreur( cniAffecteur,cniLivreur, colis);
	}
	
	
	@RequestMapping(value="/desaffectationMultipleColisAuLivreur/{cniAffecteur}/{cniLivreur}",method=RequestMethod.PUT)
	public List<Colis> desaffectationColisToLivreur(@PathVariable String cniAffecteur,@PathVariable String cniLivreur,@RequestBody List<Colis> colis) throws LivreurException {
		return colisService.desaffectationColisToLivreur(cniAffecteur,cniLivreur, colis);
	}


	
	@RequestMapping(value="/getAllColisByLivreur/{cniLivreur}",method=RequestMethod.GET)
	public Page<Colis> getAllColisByLivreur(@PathVariable String cniLivreur, @RequestParam(name="page",defaultValue="0")int page,@RequestParam(name="size",defaultValue="5")int size) {
		return colisService.getAllColisByLivreur(cniLivreur, PageRequest.of(page, size));
	}

	@RequestMapping(value="/getAllColisByClient/{cniClient}",method=RequestMethod.GET)
	public Page<Colis> getAllColisByClient(@PathVariable String cniClient, @RequestParam(name="page",defaultValue="0")int page,@RequestParam(name="size",defaultValue="5")int size) {
		return colisService.getAllColisByClient(cniClient, PageRequest.of(page, size));
	}
	@RequestMapping(value="/getAllColis",method=RequestMethod.GET)
	public Page<Colis> getAllColisUtilisateur(@RequestParam(name="page",defaultValue="0")int page,@RequestParam(name="size",defaultValue="5")int size) {
		return colisService.getAllColisUtilisateur(PageRequest.of(page, size));
	}

	public List<Colis> getAllColisWithoutBonRamassage() {
		return colisService.getAllColisWithoutBonRamassage();
	}


	public List<Colis> getAllColisWithoutBonExpedition() {
		return colisService.getAllColisWithoutBonExpedition();
	}

	public List<Colis> getAllColisWithBonRetour() {
		return colisService.getAllColisWithBonRetour();
	}

	@RequestMapping(value="/colisByStatut",method=RequestMethod.GET)
	public Page<Colis> getAllColisByStatut(String statut, @RequestParam(name="page",defaultValue="0")int page,@RequestParam(name="size",defaultValue="5")int size) {
		return colisService.getAllColisByStatut(statut, PageRequest.of(page, size));
	}

	@RequestMapping(value="/listFull",method=RequestMethod.GET)
	@XprRole(role = XprRole.Role.LIST, view= "ModelViews.FullView")
	public List<Colis> getColis(){
		List<Colis> colis=null;
		this.checkEligibility();
		Optional<HttpServletRequest> request = this.getCurrentHttpRequest();
        String permissionType = request.get().getAttribute("role").toString();
        Utilisateur user= (Utilisateur) request.get().getAttribute("user");
        
        if (!this.isSuperSuperAdmin()) {
			if(this.checkEligibility()){
				if("ALL".equals(permissionType)){
		        	colis = (List<Colis>) this.colisRepository.findAll(Sort.by("createdDate").descending());
		        }
		        
		        if("ENTITE".equals(permissionType)){
		        	 Long entite = user.getEntite().getId();
		        	 colis = this.colisRepository.getColisbyEntiteOrderbyCreatedDate(entite);
		        }
		        
		        if( "CLIENT".equals(permissionType)){
		       	 	String ice = user.getClient().getIce();
		       	 	colis = this.colisRepository.getColisbyClientOrderbyCreatedDate(ice);
		       }
			}
        }else {
        	colis = (List<Colis>) this.colisRepository.findAll(Sort.by("createdDate").descending());
        }
        
		return colis;
	}
	
	@RequestMapping(value="/listColis",method=RequestMethod.GET)
	@XprRole(role = XprRole.Role.LIST, view= "ModelViews.FullView")
	public ResponseEntity<Page<Colis>>  getListColis(@RequestParam(defaultValue="{}", required = false) Map<String,String> params){
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
        
        
   		
        ColisSearch cs = new ColisSearch();
        if(params.get("numCommande")!=null)
        cs.setNumCommande(params.get("numCommande"));
        if(params.get("idIntern")!=null)
        cs.setIdIntern(params.get("idIntern"));
        if(params.get("codeEnvoi")!=null)
        cs.setCodeEnvoi(params.get("codeEnvoi"));
        if(params.get("telephone")!=null)
        cs.setTelephone(params.get("telephone"));
        if(params.get("typeLivraison")!=null)
        cs.setTypeLivraison(params.get("typeLivraison"));
        
		Entite entite = new Entite();
		if(params.get("entite.id")!=null)
		entite.setId(Long.parseLong(params.get("entite.id")));
		if(params.get("entite.nom")!=null)
		entite.setNom(params.get("entite.nom"));
		Client client = new Client();
		if(params.get("client.ice")!=null)
		client.setIce(params.get("client.ice"));
		if(params.get("client.ice")!=null)
		client.setNom(params.get("client.nom"));
		Ville v = new Ville();
		if(params.get("villeDestination.nom")!=null)
		v.setNom(params.get("villeDestination.nom"));
		Livreur livreur = new Livreur();
		if(params.get("livreur.cni")!=null)
		livreur.setCni(params.get("livreur.cni"));
		
		cs.setLivreur(livreur);
		cs.setEntite(entite);
		cs.setClient(client);
		cs.setVilleDestination(v);
		if(params.get("mc")!=null)
		cs.setMc(params.get("mc"));
		if(params.get("destinataire")!=null)
		cs.setDestinataire(params.get("destinataire"));
		
		
		if(params.get("statut.code")!=null)
		cs.setStatutCode(params.get("statut.code"));
		
		if(params.get("statut.libelle")!=null)
			cs.setStatutLibelle(params.get("statut.libelle"));
		
		if(params.get("periode")!=null)
	        cs.setPeriode(params.get("periode"));
        
        ColisSpecification colisSpecification = new ColisSpecification(cs);
        
        
        
		return this.list(params,colisSpecification);
	}
	
	@RequestMapping(value="/colis/{numCommande}",method=RequestMethod.GET)
	public Colis getColis(@PathVariable String numCommande) {
		return colisService.findColisById(numCommande);
	}
	
	@RequestMapping(value="/update/{numCommande}",method=RequestMethod.PUT)
	public Colis editColis(@PathVariable String numCommande,@RequestBody Colis c) throws ColisException {
		
		
		
		
		return colisService.updateColis(numCommande, c);
	}
	
	@PostMapping(value="/saveColis")
	public Colis saveColisService(@RequestBody Colis colis) {
		
		if(isSuperSuperAdmin() || isAdmin() || isSuperAdmin() ) {
				return colisService.saveColis(colis);
		   
			}else {
	        	throw new AccessDeniedException("Unauthorized operation");
	       
			}
		
		
	}
	
	@Override
	public void preCreate(Colis object) {
		
		Utilisateur user = getCurrentUser();
		
		object.setCreatedBy(user.getEmail());
		object.setCreatedDate(new Date());
		object.setClient(user.getClient());
		object.setEntite(user.getEntite());
		
		
	}
	
	@Override
	public void preUpdate(Colis object) {
		Utilisateur user = getCurrentUser();
		
		object.setLastModifiedBy(user.getEmail());
		object.setLastModifiedDate(new Date());
	}
	
	@RequestMapping(value="/colis/{numCommande}",method=RequestMethod.DELETE)
	public boolean supprimerColis(@PathVariable String numCommande) throws ColisException {
		 colisService.deleteColis(numCommande); 
		 return true;
	}
	
	@RequestMapping(value="/historiques/{numCommande}",method=RequestMethod.GET)
	public List<Historique> getHistoriques(@PathVariable String numCommande) {
		return colisService.getHistoriqueColis(numCommande);
	}
	
	@RequestMapping(value="/commentaires/{numCommande}",method=RequestMethod.GET)
	public List<Commentaire> getCommentaires(@PathVariable String numCommande) {
		return colisService.getCommentairesColis(numCommande);
	}
	
	@RequestMapping(value="/addCommentaire/{numCommande}",method=RequestMethod.POST)
	public Commentaire getCommentaires(@PathVariable String numCommande,@RequestBody Commentaire commentaire) {
		
		return colisService.addCommentaireToColis(numCommande, commentaire);
	}
	
	@RequestMapping(value="/deleteCommentaire/{idCommentaire}",method=RequestMethod.DELETE)
	public void deleteCommentaires(@PathVariable Long idCommentaire) {
		
		 colisService.deleteCommentaireToColis(idCommentaire);
	}
	
	
	@RequestMapping(value="/getColis",method=RequestMethod.GET)
	public Page<Colis> chercherColisService(@RequestParam(name="mc",defaultValue="") String mc,
			@RequestParam(name = "entiteId", required = false) Long entiteId,
			@RequestParam(name = "entiteName", required = false) String entiteName,
			@RequestParam(name = "clientIce", required = false) String clientIce,
			@RequestParam(name = "clientNom", required = false) String clientNom,
			@RequestParam(name = "livreurCni", required = false) String livreurCni,
			@RequestParam(name = "destinataire", required = false) String destinataire,
			@RequestParam(name = "villeDestination", required = false) String villeDestination,
			@RequestParam(name = "dateDu", required = false) String dateDu,
			@RequestParam(name = "dateAu", required = false) String dateAu,
			@RequestParam(name="page",defaultValue="0")int page,
			@RequestParam(name="size",defaultValue="10")int size,
			@RequestParam(name = "sortBy", required = false) String sortBy,
			@RequestParam(name = "sortType", required = false) String sortType) {
		
		ColisSearch colisSearch = new ColisSearch();
		Entite entite = new Entite();
		entite.setId(entiteId);
		entite.setNom(entiteName);
		Client client = new Client();
		client.setIce(clientIce);
		client.setNom(clientNom);
		Ville v = new Ville();
		v.setNom(villeDestination);
		Livreur livreur = new Livreur();
		livreur.setCni(livreurCni);
		
		colisSearch.setLivreur(livreur);
		colisSearch.setEntite(entite);
		colisSearch.setClient(client);
		colisSearch.setVilleDestination(v);
		colisSearch.setMc(mc);
		colisSearch.setDestinataire(destinataire);
		
		
		
		
		
		Date dateDu1;
		Date dateAu1;
		try {
			dateDu1 = new SimpleDateFormat("dd/MM/yyyy").parse(dateDu);
			dateAu1 = new SimpleDateFormat("dd/MM/yyyy").parse(dateAu);   
		
			colisSearch.setDateDu(dateDu1);
			colisSearch.setDateAu(dateAu1);
		} catch (ParseException e) {
			e.printStackTrace();
		}   
		
		
		return colisService.findAllColisByColisSearch(colisSearch, page, size, sortBy, sortType);
	}
	
	
	@RequestMapping(value="/chercherColis",method=RequestMethod.GET)
	public ResponseEntity<Page<Colis>> chercherColisService2(@RequestParam(name="mc",defaultValue="") String mc,
			@RequestParam(name = "entiteId", required = false) Long entiteId,
			@RequestParam(name = "entiteName", required = false) String entiteName,
			@RequestParam(name = "clientIce", required = false) String clientIce,
			@RequestParam(name = "clientNom", required = false) String clientNom,
			@RequestParam(name = "livreurCni", required = false) String livreurCni,
			@RequestParam(name = "destinataire", required = false) String destinataire,
			@RequestParam(name = "villeDestination", required = false) String villeDestination,
			@RequestParam(name = "dateDu", required = false) String dateDu,
			@RequestParam(name = "dateAu", required = false) String dateAu,
			@RequestParam(name="page",defaultValue="0")int page,
			@RequestParam(name="size",defaultValue="10")int size,
			@RequestParam(name = "sortBy", required = false) String sortBy,
			@RequestParam(name = "sortType", required = false) String sortType) {
		
		ColisSearch colisSearch = new ColisSearch();
		Entite entite = new Entite();
		entite.setId(entiteId);
		entite.setNom(entiteName);
		Client client = new Client();
		client.setIce(clientIce);
		client.setNom(clientNom);
		Ville v = new Ville();
		v.setNom(villeDestination);
		Livreur livreur = new Livreur();
		livreur.setCni(livreurCni);
		
		colisSearch.setLivreur(livreur);
		colisSearch.setEntite(entite);
		colisSearch.setClient(client);
		colisSearch.setVilleDestination(v);
		colisSearch.setMc(mc);
		colisSearch.setDestinataire(destinataire);
		
		Date dateDu1;
		Date dateAu1;
		try {
			if(dateDu!=null) {
			dateDu1 = new SimpleDateFormat("dd/MM/yyyy").parse(dateDu);
			colisSearch.setDateDu(dateDu1);
			}
			if(dateAu!=null) {
				dateAu1 = new SimpleDateFormat("dd/MM/yyyy").parse(dateAu);   
				colisSearch.setDateAu(dateAu1);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}   
		ColisSpecification colisSpecification = new ColisSpecification(colisSearch);
		Map<String,String> params = new HashMap<String, String>();
		params.put("page", page+"");
		params.put("size",size+"");
		params.put("sortColumn", sortBy);
		params.put("sortOrder",sortType);
		return this.listSpecification(colisSpecification, params);
	}
	
	@RequestMapping(value="/chercherColisByLivreur",method=RequestMethod.GET)
	public Page<Colis> findAllColisByLivreur(@RequestParam(name="cni")String cniLivreur,@RequestParam(name="page",defaultValue="0") int page,@RequestParam(name="size",defaultValue="5") int size) {
		return colisService.findAllColisByLivreur(cniLivreur, page, size);
	}

	@RequestMapping(value="/chercherColisByClient",method=RequestMethod.GET)
	public Page<Colis> findAllColisByClient(@RequestParam(name="ice")String ice,@RequestParam(name="page",defaultValue="0") int page,@RequestParam(name="size",defaultValue="5") int size) {
		return colisService.findAllColisByClient(ice, page, size);
	}

	@RequestMapping(value="/chercherColisByUtilisateurs",method=RequestMethod.GET)
	public Page<Colis> findAllColisByUtilisateurs(@RequestParam(name="email")String emailUtilisateur,@RequestParam(name="page",defaultValue="0") int page,@RequestParam(name="size",defaultValue="5") int size) {
		return colisService.findAllColisByUtilisateurs(emailUtilisateur, page, size);
	}
	
	@PostMapping("/addColisFromFile")
	public ResponseEntity<String> addColisFromFile(@RequestParam(name="ice")String ice,@RequestParam(name="entiteId")long entiteId,@RequestParam("file") MultipartFile file) {
		String message = "";
		
		Path filepath = Paths.get("uploads/"+ file.getOriginalFilename());

	    try (OutputStream os = Files.newOutputStream(filepath)) {
	        os.write(file.getBytes());
	   
	        
			colisService.saveColisFromFile(new File("uploads/"+ file.getOriginalFilename()), entiteId, ice);
			
		
			message = "Colis crée avec succès à partir du fichier excel " + file.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.OK).body(message);
		} catch (Exception e) {
			message = "FAIL to upload " + file.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
		}finally {
			File f = new File("uploads/"+ file.getOriginalFilename());
			if(f.exists()) {
				f.delete();
			}
		}
			
		
	}
	
	@RequestMapping(value="/getAllStatutsColis",method=RequestMethod.GET)
	@XprRole(role = XprRole.Role.LIST, view= "ModelViews.SelectView")
	public List<StatutColis> getAllStatusColis() {
		return statutColisRepositoy.getAllStatutColis();
	}
	
	
}
