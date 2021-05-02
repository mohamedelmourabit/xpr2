package com.xpr.services;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import javax.transaction.Transactional;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import com.xpr.dao.ColisRepository;
import com.xpr.dao.CommentaireRepository;
import com.xpr.dao.HistoriqueRepository;
import com.xpr.dao.LigneColisRepository;
import com.xpr.dao.LivreurRepository;
import com.xpr.dao.ProduitRepository;
import com.xpr.dao.ProduitStockClientRepository;
import com.xpr.dao.StatutColisRepositoy;
import com.xpr.dao.UtilisateurRepository;
import com.xpr.dao.VarianteRepository;
import com.xpr.dao.core.controller.AbstractCRUDController;
import com.xpr.dao.specification.ColisSpecification;
import com.xpr.dto.ColisSearch;
import com.xpr.entities.Client;
import com.xpr.entities.Colis;
import com.xpr.entities.Commentaire;
import com.xpr.entities.Entite;
import com.xpr.entities.Historique;
import com.xpr.entities.HistoriqueColis;
import com.xpr.entities.LigneColis;
import com.xpr.entities.Livreur;
import com.xpr.entities.Produit;
import com.xpr.entities.StatutColis;
import com.xpr.entities.Utilisateur;
import com.xpr.entities.Ville;
import com.xpr.exceptions.ColisException;
import com.xpr.exceptions.LivreurException;
import com.xpr.utils.Constants;

@Service
public class ColisServiceImp extends AbstractCRUDController<Colis, String> implements ColisService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ColisServiceImp.class);
	 
	@Autowired
	private UtilisateurRepository userRepository;
	
	@Autowired
	private ColisRepository colisRepository;

	@Autowired
	private LivreurRepository livreurRepository;

	@Autowired
	private HistoriqueRepository historiqueRepository;

	@Autowired
	private VarianteRepository varianteRepository;

	@Autowired
	private CommentaireRepository commentaireRepository;

	@Autowired
	private ProduitStockClientRepository produitStockClientRepository;

	@Autowired
	private ProduitRepository produitRepository;
	
	@Autowired
	private LigneColisRepository ligneColisRepository;
	
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	
	@Autowired
	private StatutColisRepositoy statutColisRepositoy;

	@Override
	@Transactional
	public Colis saveColis(Colis colis) {
		LOGGER.info("Ajout d'un nouveau colis ", colis.getNumCommande());
	
		colis.setCreatedDate (new Date());
		//colis.setStatut(Constants.NOUVEAU_COLIS);
		
		StatutColis statutColis = statutColisRepositoy.findByLibelle(Constants.NOUVEAU_COLIS);
		colis.setStatut(statutColis);
		String codeEnvoie = generateCodeEnvoie();
		colis.setCodeEnvoi(codeEnvoie);
		
		
		
		Client client = getCurrentUser().getClient();
		
		colis.setClient(client);
		
		colis.setTypeLivraison("Standart");
		
		Colis clonedColis;
		try {
			clonedColis = colis.clone();
			colis.setLigneColis(new HashSet<LigneColis>());
			colis = colisRepository.save(colis);
			
			
			
				
				for(LigneColis ligneColis : clonedColis.getLigneColis()) {
					
					if(ligneColis.getStock()==null) {
					
						Produit p = ligneColis.getProduit();
						
						p =produitRepository.save(p);
						ligneColis.setProduit(p);
						ligneColis.setColis(colis);
							
					}
					ligneColisRepository.save(ligneColis);
				}
				
			
			
			
			HistoriqueColis h = HistoriqueColis.getHistorique("Ajout d'un nouveau colis" , colis,
					getCurrentUser().getEmail());
			h.setColis(colis);

			colis.getHistoriques().add(h);

			historiqueRepository.save(h);
		} catch (CloneNotSupportedException e) {
			
			LOGGER.error(e.getMessage(),e);
		}		
		
		// generate ticket
		return colis;
	}

	@Override
	public Colis findColisById(String numCommande) {
		LOGGER.info("get colis by numCommande {} ", numCommande);
		return colisRepository.findById(numCommande).get();
	}


	@Override
	public List<Colis> findAll() {
		LOGGER.info("Recupération de tous les colis");
		return (List<Colis>) colisRepository.findAll();
	}

	@Override
	@Transactional
	public Colis updateColis(String numCommande, Colis colis) throws ColisException {
		LOGGER.info("Modification colis {}", numCommande);
		Colis colis1 = findColisById(numCommande);

	
		if (colis1.getStatut().getLibelle().equals(Constants.NOUVEAU_COLIS)
				|| colis1.getStatut().getLibelle().equals(Constants.EN_ATTENTE_RAMASSAGE)) {
			colis.setNumCommande(numCommande);
			
		
			for(LigneColis ligneColis : colis.getLigneColis()) {
				if(ligneColis.getStock()==null) {
					
					Produit p = ligneColis.getProduit();
					
					p =produitRepository.save(p);
					ligneColis.setProduit(p);
					ligneColis.setColis(colis);
					ligneColisRepository.save(ligneColis);
				}
				
			}
			
			if(!colis1.getStatut().getCode().equals(colis.getStatut().getCode())) {
				
				HistoriqueColis h = HistoriqueColis.getHistorique("Modification du colis "+ colis.getNumCommande() , colis,
						getCurrentUser().getEmail());
				h.setColis(colis);

				colis.getHistoriques().add(h);

				historiqueRepository.save(h);
				
			}
			
			
					

			return colisRepository.save(colis);
		} else {
			throw new ColisException("Modification du colis interdit arpès ramassage ");
		}

	}

	@Override
	public Colis updateStatutColis(String numCommande, String statut) throws ColisException {
		Colis colis = findColisById(numCommande);

		if (colis.getStatut().getLibelle().equalsIgnoreCase(statut)) {
			throw new ColisException("Veuillez changé le statut du colis !");
		}

		if (colis.getStatut().equals(Constants.NOUVEAU_COLIS)
				|| colis.getStatut().equals(Constants.EN_ATTENTE_RAMASSAGE)) {
			colis.setNumCommande(numCommande);
			
			colis = colisRepository.save(colis);
			
			
			if(!colis.getStatut().getCode().equals(statut)) {
				HistoriqueColis h = HistoriqueColis.getHistorique("Modification statut du colis", colis,
						getCurrentUser().getEmail());
				h.setColis(colis);
				historiqueRepository.save(h);
			}
			
			
			return colis;
		} else {
			throw new ColisException("Modification du colis interdit arpès ramassage ");
		}
	}

	@Override
	public void deleteColis(String numCommande) throws ColisException {
		LOGGER.info("Suprression colis {}", numCommande);
		Colis colis = findColisById(numCommande);
		//colis.setDateModification(new Date());
		if (colis.getStatut().getLibelle().equals(Constants.NOUVEAU_COLIS)
				|| colis.getStatut().getLibelle().equals(Constants.EN_ATTENTE_RAMASSAGE)) {
			
			
			for(Historique h : historiqueRepository.getHistoriqueColisByNumCommande(colis.getNumCommande())){
				historiqueRepository.delete(h);
			}
			
			
			colisRepository.delete(colis);
		} else {
			throw new ColisException("Suppresion du colis interdit arpès ramassage ");
		}

	}



	@Override
	public List<Colis> affectationColisToLivreur(String cniAffecteur,String cniLivreur, List<Colis> colis) throws LivreurException {

		LOGGER.info("Affectation  de {} colis au livreur {}", colis.size(), cniLivreur);

		Livreur livreur = livreurRepository.findById(cniLivreur).orElse(null);
		Utilisateur affecteur = utilisateurRepository.findByCni(cniAffecteur);
		
		
		
		if (livreur == null) {
			throw new LivreurException("Livreur introuvable " + cniLivreur);
		} else {
			
			for(Colis coli:colis) {
				LOGGER.debug("Affectation du colis : {} au livreur {}", coli.getNumCommande(), cniLivreur);
				coli.setLivreur(livreur);
				
				//coli.setStatut(Constants.EN_ATTENTE_LIVRAISON);
				HistoriqueColis h = HistoriqueColis.getHistorique("Affectation du colis au livreur: " + coli.getNumCommande(),
						coli,getCurrentUser().getEmail());
				coli = colisRepository.save(coli);
	
				coli.getHistoriques().add(h);
				h.setColis(coli);
				historiqueRepository.save(h);
				colisRepository.save(coli);
			}
		}

		

		return colis;
	}

	@Override
	public List<Colis> affectationColisToRamasseur(String cniAffecteur,String cniRamasseur, List<Colis> colis) throws LivreurException {
		Livreur livreur = livreurRepository.findById(cniRamasseur).orElse(null);
		Utilisateur affecteur = utilisateurRepository.findByCni(cniAffecteur);
		if (livreur == null) {
			throw new LivreurException("Ramasseur introuvable " + cniRamasseur);
		} else {
			for(Colis coli:colis) {
				coli.setLivreur(livreur);
				//coli.setStatut(Constants.EN_ATTENTE_RAMASSAGE);
				/*Historique h = Historique.getHistorique("Affectation du colis au rammasseur: " + coli.getNumCommande(),
						coli.getStatut(), affecteur.getNom()+" "+affecteur.getPrenom());*/
				coli = colisRepository.save(coli);
				//coli.getHistoriques().add(h);
				colisRepository.save(coli);
			}
		}
		

		return colis;
	}

	@Override
	public String generateCodeEnvoie() {
		int numberColis = colisRepository.getCountColis();
		numberColis = numberColis + 10001;
		return "XPR1032MA" + numberColis;
	}

	@Override
	public Page<Colis> findAllColisByLivreur(String emailLivreur, int page, int size) {
		return colisRepository.getAllColisByLivreur(emailLivreur, PageRequest.of(page, size));
	}

	@Override
	public Page<Colis> findAllColisByClient(String ice, int page, int size) {
		return colisRepository.getAllColisByClient(ice, PageRequest.of(page, size));
	}

	@Override
	public Page<Colis> findAllColisByUtilisateurs(String emailUtilisateur, int page, int size) {
		return colisRepository.getAllColisByClient(emailUtilisateur, PageRequest.of(page, size));
	}

	@Override
	public int getCountColis() {
		return colisRepository.getCountColis();
	}

	@Override
	public int getCountColisByStatut(String statut) {
		return colisRepository.getCountColisByStatut(statut);
	}

	@Override
	public int getColisByStatutAndDate(String statut, Date dateDebut, Date dateFin) {
		return colisRepository.getColisByStatutAndDate(statut, dateDebut, dateFin);
	}

	@Override
	public List<Colis> desaffectationColisToLivreur(String cniAffecteur,String cniLivreur, List<Colis> colis) throws LivreurException {
		Utilisateur affecteur = utilisateurRepository.findByCni(cniAffecteur);
		for (Colis coli : colis) {
			//coli.setStatut(Constants.EN_ATTENTE_AFFECTATION);
			coli.setLivreur(null);
			/*Historique h = Historique.getHistorique("Désaffectation du colis au livreur: " + cniLivreur,
					coli.getStatut(), affecteur.getNom()+" "+affecteur.getPrenom());
			coli = colisRepository.save(coli);

			coli.getHistoriques().add(h);
			coli = colisRepository.save(coli);*/
			//h.setColis(coli);
			//historiqueRepository.save(h);
		}
		return colis;
	}

	

	@Override
	public Page<Colis> getAll(Pageable pageable) {
		return colisRepository.getAll(pageable);
	}

	@Override
	public Page<Colis> getAllColisByLivreur(String emailLivreur, Pageable pageable) {
		return colisRepository.getAllColisByLivreur(emailLivreur, pageable);
	}

	@Override
	public Page<Colis> getAllColisByClient(String emailClient, Pageable pageable) {
		return colisRepository.getAllColisByClient(emailClient, pageable);
	}

	@Override
	public Page<Colis> getAllColisUtilisateur(Pageable pageable) {
		return colisRepository.getAllColisUtilisateur(pageable);
	}

	@Override
	public List<Colis> getAllColisWithoutBonRamassage() {
		return colisRepository.getAllColisWithoutBonRamassage();
	}


	@Override
	public List<Colis> getAllColisWithoutBonExpedition() {
		return colisRepository.getAllColisWithoutBonExpedition();
	}

	@Override
	public List<Colis> getAllColisWithBonRetour() {
		return colisRepository.getAllColisWithBonRetour();
	}

	@Override
	public Page<Colis> getAllColisByStatut(String statut, Pageable pageable) {
		return colisRepository.getAllColisByStatut(statut, pageable);
	}

	@Override
	public List<Historique> getHistoriqueColis(String numCommande) {

		return historiqueRepository.findHistoriqueColisByNom(numCommande);

	}

	@Override
	public Page<Historique> getHistoriqueColis(String numCommande, int page, int size) {

		return historiqueRepository.findHistoriqueColisByNumCommande(numCommande, PageRequest.of(page, size));
	}

	@Override
	public Commentaire addCommentaireToColis(String numCommande, Commentaire commentaire) {
		Colis c = colisRepository.findById(numCommande).orElse(null);
		if (c != null) {
			commentaire.setDateCreation(new Date());
			commentaire.setCreatedBy(getCurrentUser().getEmail());
			
			commentaire.setColis(c);
			commentaire = commentaireRepository.save(commentaire);
			return commentaire;
		} else {
			throw new IllegalArgumentException("colis introuvable" + numCommande);
		}

	}

	@Override
	public void deleteCommentaireToColis(long idCommentaire) {
		commentaireRepository.deleteById(idCommentaire);
	}

	@Override
	public List<Commentaire> getCommentairesColis(String numCommande) {
		return commentaireRepository.findCommentaireByColis(numCommande);
	}

	@Override
	public Page<Commentaire> getCommentairesColis(String numCommande, int page, int size) {
		return commentaireRepository.findCommentaireByColis2(numCommande, PageRequest.of(page, size));
	}

	@Override
	public Colis addLignesColisToColis(String numCommande, List<LigneColis> lignesColis) throws ColisException {
		Colis c = findColisById(numCommande);

		if (c != null) {

			//c.setDateModification(new Date());

			if (c.getStatut().equals(Constants.NOUVEAU_COLIS) || c.getStatut().equals(Constants.EN_ATTENTE_RAMASSAGE)) {

				c.getLigneColis().addAll(lignesColis);
				for (LigneColis l : lignesColis) {

					/*Stock stockLigneColis = l.getStock();

					stockLigneColis.setQteEnCoursLivraison(stockLigneColis.getQteEnCoursLivraison() + l.getQte());

					stockRepository.save(stockLigneColis);*/

				}

			} else {
				throw new ColisException(
						"Modification du colis numCommande" + numCommande + " interdite arpès ramassage");
			}
		} else {
			throw new ColisException("Colis introuvable numCommande " + numCommande);
		}

		return c;
	}

	/**
	 * 
	 */
	@Override
	public Colis deleteLignesColisToColis(String numCommande, List<LigneColis> lignesColis) throws ColisException {

		Colis c = findColisById(numCommande);
		
		if (c != null) {

			//c.setDateModification(new Date());

			if (c.getStatut().equals(Constants.NOUVEAU_COLIS) || c.getStatut().equals(Constants.EN_ATTENTE_RAMASSAGE)) {

				Iterator<LigneColis> iterator = c.getLigneColis().iterator();
				while (iterator.hasNext()) {
					LigneColis element = iterator.next();
					for (LigneColis lc : lignesColis) {
						if (lc.getId().equals(element.getId())) {
							iterator.remove();
						}
					}
				}
				


			} else {
				throw new ColisException(
						"Modification du colis numCommande" + numCommande + " interdite arpès ramassage");
			}
		} else {
			throw new ColisException("Colis introuvable numCommande " + numCommande);
		}

		return c;

	}

	@Override
	public List<Colis> saveColisFromFile(File excelFile,long entiteId,String clientId) {
		
		List<Colis> colis = new ArrayList<Colis>();
		try
        {
            FileInputStream file = new FileInputStream(excelFile);
 
            //Create Workbook instance holding reference to .xlsx file
            XSSFWorkbook workbook = new XSSFWorkbook(file);
 
            //Get first/desired sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(0);
 
            //Iterate through each rows one by one
            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) 
            {
            	Colis colis1 = new Colis();
            	if(clientId!=null) {
            		Client c = new Client();
            		c.setIce(clientId);
            		colis1.setClient(c);
            	}
            	Entite entite=new Entite();
            	entite.setId(entiteId);
            	colis1.setEntite(entite);
                Row row = rowIterator.next();
                //For each row, iterate through all the columns
                Iterator<Cell> cellIterator = row.cellIterator();
                 
                while (cellIterator.hasNext()) 
                {
                    Cell cell = cellIterator.next();
                    LigneColis lc = new LigneColis();
                    Produit p =new Produit();
                   
                    int index =cell.getColumnIndex();
                    
                    switch(index) {
                    case 1 : colis1.setDestinataire(cell.getStringCellValue()); break;
                    case 2 : colis1.setTelephone(cell.getStringCellValue());break;
                    case 3 : Ville v = new Ville(); v.setNom(cell.getStringCellValue()); colis1.setVilleDestination(v); break;
                    case 4 : colis1.setAdresse(cell.getStringCellValue());break;
                    case 5 : lc.setPrix(cell.getNumericCellValue());break;
                    case 6 : p.setNature(cell.getStringCellValue()); break;
                    case 7 : p.setIdIntern(cell.getStringCellValue()); break;
                    case 8 : colis1.setRemarque(cell.getStringCellValue()); break;
                   
            
                    }

                    lc.setProduit(p);
                    colis1.getLigneColis().add(lc);
                    colis.add(colis1);
               
                }
            }
            file.close();
            
            for(Colis c : colis) {
            	saveColis(c);
            }
            
           
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    
		return colis;
	}

	@Override
	public Page<Colis> findAllColisByColisSearch(ColisSearch colisSearch, int page, int size,String sortBy,String sortType ) {
		ColisSpecification colisSpecification = new ColisSpecification(colisSearch);
		
		if(sortBy!=null) {
			
			if("asc".equals(sortType)) {
				return colisRepository.findAll(colisSpecification,PageRequest.of(page-1, size,Sort.by(sortBy).ascending()));
				
			}else {
				return colisRepository.findAll(colisSpecification,PageRequest.of(page-1, size,Sort.by(sortBy).descending()));
			}
			
		}else {
			return colisRepository.findAll(colisSpecification,PageRequest.of(page-1, size));
		
		}
	}
	
	@Override
	public void setIdentifier(String id, Colis object) {
		object.setNumCommande(id);
		
	}


	public Utilisateur getCurrentUser() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String login = (String) authentication.getPrincipal();
        return this.userRepository.findByEmail(login);
}



	

}
