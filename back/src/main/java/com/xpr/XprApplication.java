package com.xpr;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.xpr.dao.AgenceRepository;
import com.xpr.dao.AutorisationRepository;
import com.xpr.dao.BonExpeditionRepository;
import com.xpr.dao.BonRamassageRepository;
import com.xpr.dao.BonRetourRepository;
import com.xpr.dao.BusinessRepository;
import com.xpr.dao.ClientRepository;
import com.xpr.dao.ColisRepository;
import com.xpr.dao.CommentaireRepository;
import com.xpr.dao.ContratRepository;
import com.xpr.dao.EntiteRepository;
import com.xpr.dao.FactureRepository;
import com.xpr.dao.HistoriqueRepository;
import com.xpr.dao.HistoriqueStockRepository;
import com.xpr.dao.LigneColisRepository;
import com.xpr.dao.LivreurRepository;
import com.xpr.dao.ProduitRepository;
import com.xpr.dao.ProduitStockClientRepository;
import com.xpr.dao.ProfileRepository;
import com.xpr.dao.RamasseurRepository;
import com.xpr.dao.StatutBonRamassageRepositoy;
import com.xpr.dao.StatutColisRepositoy;
import com.xpr.dao.UtilisateurRepository;
import com.xpr.dao.VarianteRepository;
import com.xpr.dao.VilleRepository;
import com.xpr.dao.helper.CustomJPARepositoryImpl;
import com.xpr.entities.Agence;
import com.xpr.entities.Autorisation;
import com.xpr.entities.BonRamassage;
import com.xpr.entities.Business;
import com.xpr.entities.Client;
import com.xpr.entities.Colis;
import com.xpr.entities.Commentaire;
import com.xpr.entities.Contrat;
import com.xpr.entities.Entite;
import com.xpr.entities.HistoriqueBonRamassage;
import com.xpr.entities.HistoriqueColis;

import com.xpr.entities.LigneColis;
import com.xpr.entities.Livreur;
import com.xpr.entities.Produit;
import com.xpr.entities.Profile;
import com.xpr.entities.Ramasseur;
import com.xpr.entities.StatutBonRamassage;
import com.xpr.entities.StatutColis;
import com.xpr.entities.Utilisateur;
import com.xpr.entities.Ville;
import com.xpr.services.RolesPopulator;
import com.xpr.services.StartupEntry;
import com.xpr.utils.Constants;



@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = CustomJPARepositoryImpl.class)
public class XprApplication implements CommandLineRunner {
	
	private Set<StartupEntry> startupEntrySet = new HashSet<>();

	@Autowired
	public void setRolesPopulator(RolesPopulator populator) {
		startupEntrySet.add(populator);
	}

	private static final Logger LOGGER = LoggerFactory.getLogger(XprApplication.class);

	@Autowired
	private FactureRepository factureRepository;

	@Autowired
	private LivreurRepository livreurRepository;

	@Autowired
	private RamasseurRepository ramasseurRepository;

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private ColisRepository colisRepository;

	@Autowired
	private VilleRepository villeRepository;

	@Autowired
	private UtilisateurRepository utilisateurRepository;

	@Autowired
	private ProfileRepository profileRepository;

	@Autowired
	private AutorisationRepository autorisationRepository;

	@Autowired
	private BonRetourRepository bonRetourRepository;

	@Autowired
	private BonExpeditionRepository bonExpeditionRepository;

	@Autowired
	private BonRamassageRepository bonRamassageRepository;

	@Autowired
	private ProduitRepository produitRepository;

	@Autowired
	private ProduitStockClientRepository produitStockClientRepository;

	@Autowired
	private LigneColisRepository ligneColisRepository;

	@Autowired
	private VarianteRepository varianteRepository;

	@Autowired
	private AgenceRepository agenceRepository;

	@Autowired
	private BusinessRepository businessRepository;

	@Autowired
	private HistoriqueRepository historiqueRepository;

	@Autowired
	private CommentaireRepository commentaireRepository;

	@Autowired
	private HistoriqueStockRepository historiqueStockRepository;

	@Autowired
	private ContratRepository contratRepository;

	@Autowired
	private EntiteRepository entiteRepository;
	
	@Autowired
	private StatutColisRepositoy statutColisRepositoy;
	
	@Autowired
	private StatutBonRamassageRepositoy statutBonRamassageRepositoy;

	public static void main(String[] args) {
		SpringApplication.run(XprApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		for(StartupEntry entry : startupEntrySet)
			entry.run();

		Entite XPR = new Entite();
		XPR.setNom("XPR");

		XPR = entiteRepository.save(XPR);
		
		
		 StatutColis statutColisLivre =  statutColisRepositoy.save(new StatutColis(Constants.LIVRE));
		
		 StatutColis statutColisLivrePartiel =  statutColisRepositoy.save(new StatutColis(Constants.LIVRE_PARTIEL));
		 StatutColis statutColisRetourne =  statutColisRepositoy.save(new StatutColis(Constants.RETOURNE));
		 StatutColis statutColisEnAttenteRamassage =  statutColisRepositoy.save(new StatutColis(Constants.EN_ATTENTE_RAMASSAGE));
		 StatutColis statutColisEnAttenteLivraison =  statutColisRepositoy.save(new StatutColis(Constants.EN_ATTENTE_LIVRAISON));
		 StatutColis statutColisNouveauColis =  statutColisRepositoy.save(new StatutColis(Constants.NOUVEAU_COLIS));
		 StatutColis statutColisReceptionneSurAgenceFES =  statutColisRepositoy.save(new StatutColis(Constants.RECEPTIONNE_SUR_AGENCE));

		 
		 StatutBonRamassage statutBonRamassageEnAttenteRamassage =  statutBonRamassageRepositoy.save(new StatutBonRamassage(Constants.EN_ATTENTE_RAMASSAGE));
		 StatutBonRamassage statutBonRamassageRamasse =  statutBonRamassageRepositoy.save(new StatutBonRamassage(Constants.RAMASSE));
		 
		

		Profile profileSuperSuperAdmin = new Profile();
		profileSuperSuperAdmin.setPrflName("Super Super Admin");
		profileSuperSuperAdmin.setAutorisations(new HashSet<Autorisation>());
		for(Autorisation a : autorisationRepository.findAll()) {
			if(a.getAuthName().contains("ALL")) {
				profileSuperSuperAdmin.getAutorisations().add(a);
			}
		}
		
		Client clientXPR = new Client(); // contrat prixlivraison datedebut dateFin

		clientXPR.setContact("XPR");
		clientXPR.setPrefixCommande("XPR");
		clientXPR.setTypeClient("ENTITE");
		clientXPR.setEntite(XPR);
		clientXPR.setIce("iceXPR");
		clientXPR.setNom("XPR");
		clientXPR.setTypeClient("Entreprise");
		
		clientXPR = clientRepository.save(clientXPR);


		profileSuperSuperAdmin = profileRepository.save(profileSuperSuperAdmin);

		Utilisateur utilisateurSuperSuperAdminXpr = new Utilisateur();
		utilisateurSuperSuperAdminXpr.setCni("SuperSuperAdmin");
		utilisateurSuperSuperAdminXpr.setNom("SuperSuperAdmin");
		utilisateurSuperSuperAdminXpr.setPassword(new BCryptPasswordEncoder().encode("123456"));
		utilisateurSuperSuperAdminXpr.setEmail("SuperSuperAdmin");
		utilisateurSuperSuperAdminXpr.setEntite(XPR);
		utilisateurSuperSuperAdminXpr.setClient(clientXPR);
		utilisateurSuperSuperAdminXpr.getProfiles().add(profileSuperSuperAdmin);
		utilisateurSuperSuperAdminXpr = utilisateurRepository.save(utilisateurSuperSuperAdminXpr);

		Profile profileSuperAdmin = new Profile();
		profileSuperAdmin.setPrflName("Super Admin");
		profileSuperAdmin = profileRepository.save(profileSuperAdmin);
		

		Utilisateur utilisateurSuperAdminXpr = new Utilisateur();
		utilisateurSuperAdminXpr.setCni("SuperAdmin");
		utilisateurSuperAdminXpr.setNom("SuperAdmin");
		utilisateurSuperAdminXpr.setPassword(new BCryptPasswordEncoder().encode("123456"));
		utilisateurSuperAdminXpr.setEmail("SuperAdmin");
		utilisateurSuperAdminXpr.setEntite(XPR);
		utilisateurSuperAdminXpr.setClient(clientXPR);
		utilisateurSuperAdminXpr.getProfiles().add(profileSuperAdmin);
		utilisateurSuperAdminXpr = utilisateurRepository.save(utilisateurSuperAdminXpr);

		Profile profileAdmin = new Profile();
		profileAdmin.setPrflName("Admin");
		profileAdmin = profileRepository.save(profileAdmin);
		
		;

		Profile clientProfile = new Profile();
		clientProfile.setPrflName("Client");
		clientProfile = profileRepository.save(clientProfile);
		
	
		

		Utilisateur utilisateurAdminXpr = new Utilisateur();
		utilisateurAdminXpr.setCni("Admin");
		utilisateurAdminXpr.setNom("Admin");
		utilisateurAdminXpr.setPassword(new BCryptPasswordEncoder().encode("123456"));
		utilisateurAdminXpr.setEmail("Admin");
		utilisateurAdminXpr.setEntite(XPR);
		utilisateurAdminXpr.setClient(clientXPR);

		utilisateurAdminXpr.getProfiles().add(profileAdmin);
		utilisateurAdminXpr = utilisateurRepository.save(utilisateurAdminXpr);

		Profile profileManager = new Profile();
		profileManager.setPrflName("Manager");
		

		profileManager = profileRepository.save(profileManager);

		Profile profileLivreur = new Profile();
		profileLivreur.setPrflName("Livreur");

		

		profileRepository.save(profileLivreur);

		Profile profileRamasseur = new Profile();
		profileRamasseur.setPrflName("Ramasseur");
				profileRepository.save(profileRamasseur);

		profileRamasseur = profileRepository.save(profileRamasseur);

		Utilisateur utilisateurXpr = new Utilisateur();
		utilisateurXpr.setCni("cniUserXpr11");
		utilisateurXpr.setNom("userXpr1");
		utilisateurXpr.setPassword(new BCryptPasswordEncoder().encode("123456"));
		utilisateurXpr.setEmail("managerXPR@xpr.com");
		utilisateurXpr.setEntite(XPR);
		utilisateurXpr.setClient(clientXPR);

		utilisateurXpr.getProfiles().add(profileManager);
		utilisateurXpr = utilisateurRepository.save(utilisateurXpr);
		// utilisateurRepository.save(utilisateurXpr);

		Ville fes = new Ville();

		fes.setNom("FES");
		fes = villeRepository.save(fes);

		Client client = new Client();
		client.setNom("client1");
		client.setIce("iceClient1");
		client.setPrefixCommande("Client1Prefix");
		client.setVille(fes);
		client.setEntite(XPR);
		client = clientRepository.save(client);

		Utilisateur uc = new Utilisateur();
		uc.setCni("cniClient11");
		uc.setEmail("clientXPR@gmail.com");
		uc.setPassword(new BCryptPasswordEncoder().encode("123456"));
		uc.setNom("Client");
		uc.setPrenom("Client");
		uc.setClient(client);
		uc.setEntite(XPR);
		uc = utilisateurRepository.save(uc);
		uc.getProfiles().add(clientProfile);

		Contrat c = new Contrat();
		c.setClient(client);
		c.setPrixLivraison(10.00);
		c.setDateDebut(new Date());
		c.setEntite(XPR);

		c = contratRepository.save(c);
		
	

		Entite SEM = new Entite();
		SEM.setEntiteParent(XPR);
		SEM.setNom("SEM");

		SEM = entiteRepository.save(SEM);

		Utilisateur utilisateurXpr2 = new Utilisateur();
		utilisateurXpr2.setCni("cniUserXpr2");
		utilisateurXpr2.setNom("userXpr2");
		utilisateurXpr2.setPassword(new BCryptPasswordEncoder().encode("123456"));
		utilisateurXpr2.setTypeUtilisateur("Utilisateur");
		utilisateurXpr2.setEmail("managerSEM@xpr.com");
		utilisateurXpr2.setEntite(SEM);
		utilisateurXpr2.setClient(clientXPR);
		utilisateurXpr2 = utilisateurRepository.save(utilisateurXpr2);
		utilisateurXpr2.getProfiles().add(profileManager);

		Agence agenceFes = new Agence();
		agenceFes.setNom("Agence fes");
		agenceFes.setVille(fes);
		agenceFes.setEntite(XPR);
		agenceFes = agenceRepository.save(agenceFes);

		Ville casa = new Ville();
		casa.setNom("Casa");
		casa = villeRepository.save(casa);

		Agence agenceCasa = new Agence();
		agenceCasa.setNom("Agence Casa");
		agenceCasa.setVille(casa);
		agenceCasa = agenceRepository.save(agenceCasa);

		Ramasseur ramasseur1 = new Ramasseur();
		ramasseur1.setCni("CNIramasseur1");
		ramasseur1.setTypeUtilisateur("Ramasseur");
		//ramasseur1.setEntite(XPR);
		ramasseur1.setEmail("ramasseur1@xpr.com");
		ramasseur1.setPassword(new BCryptPasswordEncoder().encode("123456"));
		ramasseur1.setPrenom("prenomRamasseur1");
		ramasseur1.setNom("nomRamasseur1");

		LOGGER.debug("Ajout d'un nouveau ramasseur : ramasseur1");
		ramasseur1 = ramasseurRepository.save(ramasseur1);
		ramasseur1.getVilles().add(casa);
		ramasseur1.getProfiles().add(profileRamasseur);

		Livreur livreur1 = new Livreur();
		livreur1.setTypeUtilisateur("Livreur");
		livreur1.setEntite(XPR);

		livreur1.setCni("CNILivreur1");
		livreur1.setEmail("livreur1@xpr.com");
		livreur1.setPassword(new BCryptPasswordEncoder().encode("123456"));
		livreur1.setPrenom("prenomlivreur1");
		livreur1.setNom("nomlivreur1");

		LOGGER.debug("Ajout d'un nouveau livreur : livreur1");
		livreur1 = livreurRepository.save(livreur1);
		livreur1.getProfiles().add(profileLivreur);
		livreur1.setVilles(new HashSet<Ville>());
		livreur1.getVilles().add(fes);

		Livreur livreur2 = new Livreur();
		livreur2.setTypeUtilisateur("Livreur");
		livreur2.setEntite(XPR);
		livreur2.setCni("CNILivreur2");

		livreur2.setPrenom("prenomlivreur2");
		livreur2.setPassword(new BCryptPasswordEncoder().encode("123456"));
		livreur2.setNom("nomlivreur2");
		livreur2.setTypeUtilisateur("Livreur");
		livreur2.setEmail("livreur2@xpr.com");

		LOGGER.debug("Ajout d'un nouveau livreur : livreur2");
		livreur2 = livreurRepository.save(livreur2);
		livreur1.setProfiles(new HashSet<Profile>());
		livreur2.getProfiles().add(profileLivreur);
		livreur2.setVilles(new HashSet<Ville>());
		livreur2.getVilles().add(casa);
		
		
		Client client1 = new Client(); // contrat prixlivraison datedebut dateFin

		client1.setContact("client1Contact");
		client1.setTypeClient("Particulier");
		client1.setEntite(XPR);
		client1.setIce("ice1");
		client1.setTypeClient("Entreprise");

		client1.setNom("Client1");
		client1.setTelephone("052250605040");

		client1.setPrefixCommande("PR");
		client1.setVille(fes);
		LOGGER.debug("add Client1");

		client1 = clientRepository.save(client1);

		Contrat contrat1 = new Contrat();
		contrat1.setClient(client1);
		contrat1.setDateDebut(new Date());
		contrat1.setPrixLivraison(10.00);
		contrat1.setPrixAnnulation(2.00);

		Business business = new Business();
		business.setNom("business1");
		business.setClient(client1);

		business = businessRepository.save(business);

		uc = new Utilisateur();
		uc.setCni("cniClient1");
		uc.setEmail("client1@xpr.com");
		uc.setPassword(new BCryptPasswordEncoder().encode("123456"));
		uc.setNom("Client1 ");
		uc.setPrenom("Client 1");
		uc.setClient(client1);
		uc.setEntite(XPR);

		uc = utilisateurRepository.save(uc);
		uc.getProfiles().add(clientProfile);
		Colis colis1 = null;
		for (int i = 0; i < 50; i++) {

			// le client qui saisie le colis
			colis1 = new Colis();
			// colis1.setCreerPar(uc);
			colis1.setClient(client1);
			

			int numberColis = colisRepository.getCountColis();
			// numberColis = numberColis+10001;//annnée

			colis1.setCodeEnvoi("XPR1032MA" + numberColis);

			colis1.setClient(client1); //
			colis1.setAdresse("addresse" + i);
			colis1.setApplicationFrais(true);
			colis1.setApplicationFraisAssurance(false);
			Commentaire cCom = new Commentaire();
			cCom.setColis(colis1);
			cCom.setDateCreation(new Date());
			cCom.setCommentaire("merci de le livrer au plus vite");

			cCom.setUtilisateur(utilisateurXpr);
			colis1.setCommentaires(new HashSet<Commentaire>());
			colis1.getCommentaires().add(cCom);
			colis1.setClient(client1);
			colis1.setDestinataire("Houssam" + i);
			colis1.setNomComplet("Houssam Houssam " + i);
			colis1.setTelephone("06 20 67 47 78");
			colis1.setDateLivraison(null);
			colis1.setDateRamassage(null);
			colis1.setDestinataire("destinataire1");
			colis1.setTypeLivraison("A domicile");
			colis1.setEntite(XPR);
			colis1.setIdIntern("idIntern" + i);
			colis1.setStatut(statutColisNouveauColis);
			colis1.setVilleDestination(casa);
			colis1.setCreatedDate(getDate(i));
			colis1.setCreatedBy(utilisateurSuperAdminXpr.getEmail());
			LigneColis lc = new LigneColis();
			lc.setQte(i+2);
			Produit p = new Produit();
			p.setNom("produit1" + i);
			p.setQte(i+2);
			p.setPrixVente(1200.00);
			p.setPrixOriginale(1000.00);
			p = produitRepository.save(p);
			lc.setPrix(1200.00);
			lc.setColis(colis1);
			lc.setProduit(p);

			colis1 = colisRepository.save(colis1);

			lc = ligneColisRepository.save(lc);
			colis1.setLigneColis(new HashSet<LigneColis>());
			colis1.getLigneColis().add(lc);

			HistoriqueColis h = new HistoriqueColis();
			h.setAction("creer nouveau colis");
			h.setColis(colis1);
			h.setUtilisateur(utilisateurXpr);
			h.setStatut(colis1.getStatut().getLibelle());
			
			colis1.setHistoriques(new HashSet<HistoriqueColis>());
			colis1.getHistoriques().add(h);
			
			colis1.setVilleDestination(casa);
			colis1.setStatut(statutColisEnAttenteRamassage);

			 h = new HistoriqueColis();
			h.setAction("Affectation du ramasseur");
			h.setColis(colis1);
			h.setUtilisateur(utilisateurXpr);
			h.setStatut(colis1.getStatut().getLibelle());
			h.setDateCreation(new Date());
			colis1 = colisRepository.save(colis1);

			cCom = commentaireRepository.save(cCom);
			historiqueRepository.save(h);

		}

		// affectation au ramasseur si y'a pas de stock
		// utilisateurs xpr

		colis1.setRamasseur(ramasseur1);
		HistoriqueColis h = new HistoriqueColis();
		h.setAction("creer nouveau colis");
		h.setColis(colis1);
		h.setUtilisateur(utilisateurXpr);
		h.setStatut(colis1.getStatut().getLibelle());
		h.setDateCreation(new Date());
		colis1 = colisRepository.save(colis1);

		// creation du Bl cote client

		// liste les colis sans BL

		// Generation du Bon ramassage

		for(int i=0;i<30;i++) {
			BonRamassage br = new BonRamassage();
			br.setCreatedDate(getDate(i));
			if(i%2==0) {
				br.setEntite(SEM);
			}else {
				br.setEntite(XPR);
			}
			
			
			
			br.setClient(client1);
			br.setStatut(statutBonRamassageEnAttenteRamassage);
			br.setColis(new HashSet<Colis>());
			br.getColis().add(colis1);
			colis1.setStatut(statutColisEnAttenteRamassage);
			colis1.setDateRamassage(new Date());
			colis1 = colisRepository.save(colis1);
			HistoriqueBonRamassage h1 = new HistoriqueBonRamassage();
			h1.setAction("creer nouveau br");
			h1.setBonRamassage(br);
			h1.setUtilisateur(uc);
			h1.setStatut(br.getStatut().getLibelle());
			h1.setDateCreation(new Date());
	
			br.setRamasseur(ramasseur1);
			br.setAgence(agenceFes);
			br.setHistoriques(new HashSet<HistoriqueBonRamassage>());
			br.getHistoriques().add(h1); // livreur envoi colis vers agence ?
	
			br = bonRamassageRepository.save(br);
			System.out.println("br " + br.getNom());
			historiqueRepository.save(h);
	
			// ramassage par le livreur depot sur agenceFES et envoi vers Casa
	
			br.setStatut(statutBonRamassageRamasse);
	
			HistoriqueBonRamassage h2 = new HistoriqueBonRamassage();
			h2.setAction("En cours de depot sur agence FES"); // Expedition inter agence
			h2.setBonRamassage(br);
			h2.setUtilisateur(utilisateurXpr);
			h2.setStatut(br.getStatut().getLibelle());
			h2.setDateCreation(new Date());
	
			br.getHistoriques().add(h2);
			br = bonRamassageRepository.save(br);
			historiqueRepository.save(h);
		}

		// Réceptioniste utilisateurXPR (scanne Bon ramassage et dispatch)

		colis1.setStatut(statutColisReceptionneSurAgenceFES);
		h = new HistoriqueColis();
		h.setAction("réception colis sur agenceFes");
		h.setColis(colis1);
		h.setUtilisateur(utilisateurXpr2);
		h.setStatut("expeide");
		h.setDateCreation(new Date());
		colis1.setHistoriques(new HashSet<HistoriqueColis>());
		colis1.getHistoriques().add(h);

		colis1 = colisRepository.save(colis1);
		historiqueRepository.save(h);

		// Bon Expedition receptioniste qui le fait

		/*BonExpedition be = new BonExpedition();
	
		
		be.setStatut(Constants.NOUVEAU_BE);

		LigneBonExpedition lbe = new LigneBonExpedition();
		lbe.setColis(colis1);

		be.getLigneBonExpeditions().add(lbe);
		colis1.setStatut(StatusColisEnCoursExpedition);
		HistoriqueBonExpedition h2 = new HistoriqueBonExpedition();
		h2.setAction("creer nouveau be");
		h2.setBonExpedition(be);
		h2.setUtilisateur(utilisateurXpr);
		h2.setStatut(br.getStatut());
		h2.setDateCreation(new Date());

		be.setDepart(agenceFes);
		be.setDestination(agenceCasa);
		be.setLogistique("CTM");
		be.setRefBonLogistique("reference1");
		be.getHistoriques().add(h);

		h = new Historique();
		h.setAction("en cours expedition");
		h.setColis(colis1);
		h.setUtilisateur(utilisateurXpr);
		h.setStatut(br.getStatut());
		h.setDateCreation(new Date());
		be.getHistoriques().add(h);

		be = bonExpeditionRepository.save(be);
		System.out.println("be " + be.getNom());
		historiqueRepository.save(h);

		// arrive vers casa

		be.setStatut(Constants.EXPEDIE);
		h = new Historique();
		h.setAction("Confirmation reception expedition vers agence CASA");
		h.setBonExpedition(be);
		h.setUtilisateur(utilisateurXpr);
		h.setStatut(br.getStatut());
		h.setDateCreation(new Date());
		be.getHistoriques().add(h);
		historiqueRepository.save(h);

		colis1.setStatut(StatusColisExpedie);

		h = new Historique();
		h.setAction("Arrivé sur Casablanca");
		h.setColis(colis1);
		h.setUtilisateur(utilisateurXpr);
		h.setStatut(br.getStatut());
		h.setDateCreation(new Date());
		colis1.getHistoriques().add(h);

		be = bonExpeditionRepository.save(be);
		historiqueRepository.save(h);

		// affectation au livreur receptioniste

		colis1.setLivreur(livreur2);
		colis1.setStatut(StatusColisEnAttenteLivraisonClient);
		h = new Historique();
		h.setAction("Affectation au livreur");
		h.setColis(colis1);
		h.setUtilisateur(utilisateurXpr);
		h.setStatut(br.getStatut());
		h.setDateCreation(new Date());
		colis1.getHistoriques().add(h);
		historiqueRepository.save(h);

		// Livraison client

		colis1.setLivreur(livreur2);
		colis1.setStatut(statutColisLivre);
		colis1.setDateLivraison(new Date()); // scanné
		colisRepository.save(colis1);
		h = new Historique();
		h.setAction("Livré au client");
		h.setColis(colis1);
		h.setUtilisateur(livreur2);
		h.setStatut(br.getStatut());
		h.setDateCreation(new Date());
		colis1.getHistoriques().add(h);
		historiqueRepository.save(h);

		// facturation par le livreur 2

		// facturation sur agence (pour la collecte de l'argent)

		// 23:30 generation des factures

		// client pas de visibilité

		// type reglement : espece ou virement
		Facture facture = new Facture();
		facture.setDateCreation(new Date());

		LigneFacture ligneFacture = new LigneFacture();

		for (LigneColis ligneColis : colis1.getLigneColis()) {

			ligneFacture.setFacture(facture);
			ligneFacture.setLigneColis(ligneColis);

			double prix = 0.0;
			if (ligneColis.getQteLivre() != null)
				if (ligneColis.getQteLivre() > 0) {
					ligneFacture.setQte(ligneColis.getQteLivre());
					if (ligneColis.getProduit() != null) {
						prix = ligneColis.getProduit().getPrixVente();
					} else {
						prix = ligneColis.getVariante().getPrixVente();
					}
					ligneFacture.setPrixFacture(prix);
				}

		}

		facture.setLivreur(livreur2);
		facture.setCreerPar(livreur2);

		facture.setStatut("Non reglé");

		facture = factureRepository.save(facture);

		colis1.setFacture(facture);
		colisRepository.save(colis1);

		// puisque le client possede deja une facture
		FactureClient factureClient = new FactureClient();

		factureClient.setClient(client1);

		if (!colis1.isFacturerClient()) {

			for (LigneColis ligneColis : colis1.getLigneColis()) {
				LigneFactureClient ligneFactureClient = new LigneFactureClient();
				if (ligneColis.getQteLivre() != null)
					if (ligneColis.getQteLivre() > 0) {

						double prix = 0;
						ligneFactureClient.setQte(ligneColis.getQteLivre());
						if (ligneColis.getProduit() != null) {
							prix = ligneColis.getProduit().getPrixVente();
							ligneFactureClient.setLibelle("Livraison " + ligneColis.getProduit().getNom());

						} else {
							prix = ligneColis.getVariante().getPrixVente();
							ligneFactureClient.setLibelle("Livraison " + ligneColis.getVariante().getNom() + "_SKU_"
									+ ligneColis.getVariante().getSku());

						}
						ligneFactureClient.setPrixFacture(prix);
					}

				if (ligneColis.getQteLivre() != null)
					if (ligneColis.getQteRetourne() > 0) {
						ligneFacture.setQte(1);

						if (ligneColis.getProduit() != null) {
							ligneFactureClient.setLibelle("Annulation " + ligneColis.getProduit().getNom());
						} else {
							ligneFactureClient.setLibelle("Annulation " + ligneColis.getVariante().getNom() + "_SKU_"
									+ ligneColis.getVariante().getSku());

						}

						ligneFactureClient.setPrixFacture(-contrat1.getPrixAnnulation());
						ligneFactureClient.setFactureClient(factureClient);
						factureClient.getLigneFactures().add(ligneFacture);
					}
			}

		}

		colis1.setFacturerClient(true);

		// Lors de l'affectation plafonné 10colis en attente non reglé !

		double montantTotalNet = 0.0;

		/*
		 * for(LigneFacture c1 : facture.getLigneFactures()) { montantTotalNet =
		 * montantTotalNet + c1.getPrix(); } facture.setTotalNet(montantTotalNet);
		 * 
		 * if(facture.getColis()!=null) {
		 * facture.setNbrColis(facture.getColis().size()); }
		 */

	//	System.out.println("facture " + facture.getName());

		// apres reception du paiement par l'agence

		// factureClient à CREE prix colis globale - montantLivraiosn sur
		// contratlivraion

		// changement

		//facture.setStatut("Reglé");

		//factureRepository.save(facture);

		// generation des bon retour par colis annule 00:00

		// factureClient contrat n'accepte statut colis refusé

		// factureClient + colis refusé : prix refusé sur contrat

		// selection des colis

		// case de figure avec Stock

		// expedition produits sur agence

		// saisie BR

		/*
		 * Produit produit = new Produit(); produit.setClient(client1);
		 * produit.setContainVariantes(true); produit.setDimension("10 / 10");
		 * produit.setEmballer(true); produit.setIdIntern("produit1");
		 * produit.setMarque("marque1"); produit.setNom("nomProduit1");
		 * produit.setNature("nature1"); produit.setPrixOriginale(1000.00);
		 * produit.setPrixVente(1200.00);
		 * 
		 * produit = produitRepository.save(produit);
		 * 
		 * Variante variante1 = new Variante(); variante1.setPrixVente(1500.00);
		 * variante1.setSku("SKU1"); variante1.setId(produit.getId());
		 * variante1.setNom(produit.getNom()); variante1.setDimension("20px");
		 * variante1.setQte(100);
		 * 
		 * Variante variante2 = new Variante(); variante2.setPrixVente(2500.00);
		 * variante2.setSku("SKU"); variante2.setId(produit.getId());
		 * variante2.setNom(produit.getNom()); variante2.setQte(500);
		 * 
		 * variante1 = varianteRepository.save(variante1); variante2 =
		 * varianteRepository.save(variante2);
		 */
		// creer un BR Stock normal

		// reception par agenceCASA (dispatch interne)

		// colis expedition

		// reception par agence finale changement statut colis stocké en ville

		// receptionniste un colis stock

		// variante

		// receptioniste affecte au livreur

		// avant creation stock est ce qu'il y'a un bon livraison et bon rammassage ?

		// Creation stock agence avec variante1

		/*Stock s = new Stock();
		s.setAgence(agenceFes);
		s.setClient(client1);
		s.setVille(fes);
		s.setProduit(variante1);
		s.setQte(50);
		s.setQteNonLivre(50);
		s.setQteLivre(0);
		s.setQteEnCoursLivraison(0);

		s = stockRepository.save(s);

		// generation bon rammassage par le client

		HistoriqueStock hs = new HistoriqueStock();
		hs.setCreationDate(new Date());
		hs.setQte(s.getQte());
		hs.setUtilisateur(utilisateurXpr);
		hs.setStock(s);
		hs.setAction("Creation du stock sur agence variante: " + variante1.getSku() + "agence=" + agenceFes.getNom());
		historiqueStockRepository.save(hs);

		// Creation stock agence avec variante2

		Stock s2 = new Stock();
		s2.setAgence(agenceFes);
		s2.setClient(client1);
		s2.setVille(fes);
		s2.setProduit(variante2);
		s2.setQte(500);

		s2.setQteNonLivre(500);
		s2.setQteLivre(0);

		s2 = stockRepository.save(s2);

		// Creation stock livreur 20 variante1

		int qteVarianteReserveStock = 20;// varianteStockRepository.getSumQteStockVariante(variante1.getSku());

		int stockAvailable = variante1.getQte() - qteVarianteReserveStock;

		if (stockAvailable >= 20) {

			Stock stockLivreur = new Stock();
			// stockLivreur.setLivreur(livreur1);
			stockLivreur.setProduit(variante1);
			stockLivreur.setClient(client1);
			stockLivreur.setVille(fes);
			stockLivreur.setQte(20);
			stockLivreur.setQteNonLivre(20);
			stockLivreur.setQteLivre(0);

			stockLivreur = stockRepository.save(stockLivreur);
			hs = new HistoriqueStock();
			hs.setCreationDate(new Date());
			hs.setQte(s.getQte());
			hs.setUtilisateur(utilisateurXpr);
			hs.setStock(s);
			hs.setAction(
					"Creation du stock sur livreur variante: " + variante1.getSku() + "livreur=" + livreur1.getCni());
			historiqueStockRepository.save(hs);

		}

		/*
		 * // creation colis avec 2: variante1 et 1 variante2 à partir du stock sur
		 * agence fes Colis colisStock = new Colis();
		 * colisStock.setDestinataire("SIMO"); colisStock.setNomComplet("SIMO SIMO");
		 * colisStock.setTelephone("06 20 67 47 90"); colisStock.setClient(client1);
		 * colisStock.setAdresse("adrees xxx"); colisStock.setCreerPar(utilisateurXpr);
		 * colisStock.setDateCreation(new Date()); colisStock.setApplicationFrais(true);
		 * colisStock.setTypeLivraison("type livraison1");
		 * colisStock.setStatut(Constants.EN_ATTENTE_LIVRAISON);
		 * colisStock.setVilleDestination(fes); // livré sur meme ville de stock donc à
		 * priori c'est sans bon expedition ? colisStock.setEntite(XPR);
		 * colis1.setIdIntern("idIntern"+51); int numberColis =
		 * colisRepository.getCountColis(); //numberColis = numberColis+10001;//annnée
		 * 
		 * colisStock.setCodeEnvoi("PWC1032MA"+numberColis);
		 * 
		 * 
		 * colisStock = colisRepository.save(colisStock);
		 * 
		 * 
		 * LigneColis lc1=new LigneColis(); lc1.setColis(colisStock);
		 * lc1.setVariante(variante1); lc1.setStock(s); lc1.setQte(2);
		 * lc1.setPrix(1200.00);
		 * 
		 * 
		 * LigneColis lc2=new LigneColis(); lc2.setColis(colisStock);
		 * lc2.setVariante(variante2); lc2.setStock(s2); lc2.setQte(1);
		 * lc2.setPrix(1500.00);
		 * 
		 * colisStock.getLigneColis().add(lc1); colisStock.getLigneColis().add(lc2);
		 * 
		 * s.setQteEnCoursLivraison(s.getQteEnCoursLivraison()+lc1.getQte());
		 * s.setQteNonLivre(s.getQteNonLivre()+lc1.getQte());
		 * 
		 * 
		 * 
		 * s =stockRepository.save(s);
		 * 
		 * 
		 * s2.setQteEnCoursLivraison(s2.getQteEnCoursLivraison()+lc2.getQte());
		 * s2.setQteNonLivre(s2.getQteNonLivre()+lc2.getQte()); s2
		 * =stockRepository.save(s2);
		 * 
		 * 
		 * // Pour cette exemple de stock sur fes et livraison pas de bon expediton
		 * 
		 * 
		 * 
		 * //affectation au livreur
		 * 
		 * colisStock.setLivreur(livreur1);
		 * colisStock.setStatut(Constants.EN_ATTENTE_LIVRAISON); h=new Historique();
		 * h.setAction("Affectation au livreur"); h.setColis(colisStock);
		 * h.setUtilisateur(utilisateurXpr); h.setStatut(colisStock.getStatut());
		 * h.setDateCreation(new Date()); colisStock.getHistoriques().add(h);
		 * 
		 * historiqueRepository.save(h);
		 * 
		 * //
		 * 
		 * // changement de setQteEnCoursLivraison stock
		 * 
		 * for(LigneColis l : colisStock.getLigneColis()) {
		 * 
		 * Stock stockLigneColis= l.getStock();
		 * 
		 * stockLigneColis.setQteEnCoursLivraison(
		 * stockLigneColis.getQteEnCoursLivraison() +l.getQte());
		 * 
		 * stockRepository.save(stockLigneColis);
		 * 
		 * }
		 * 
		 * 
		 * // Livraison au client final
		 * 
		 * 
		 * colisStock.setStatut(Constants.LIVRE); colisStock.setDateLivraison(new
		 * Date());
		 * 
		 * 
		 * // case exceptionnel lors de la livraion le client finale ne veut qu'une 1
		 * variante1 et 1variante2
		 * 
		 * // selection des variantes non livré
		 * 
		 * 
		 * for(LigneColis l : colisStock.getLigneColis()) {
		 * 
		 * l.setQteRetourne(0); l.setQteLivre(l.getQte());
		 * 
		 * 
		 * if(l.getVariante().getSku().equals("variante1")) { l.setQteRetourne(1);
		 * l.setQteLivre(l.getQteLivre()-1);
		 * 
		 * 
		 * 
		 * }
		 * 
		 * ligneColisRepository.save(l);
		 * 
		 * }
		 * 
		 * 
		 * 
		 * // Mise à jour qute stock changement des quantités livré sur stock extrait
		 * depuis ligneColis
		 * 
		 * for(LigneColis l : colisStock.getLigneColis()) {
		 * 
		 * Stock stockLigneColis= l.getStock();
		 * 
		 * stockLigneColis.setQteEnCoursLivraison(stockLigneColis.getQteEnCoursLivraison
		 * ()-l.getQte());
		 * stockLigneColis.setQteLivre(stockLigneColis.getQteLivre()+l.getQte());
		 * stockLigneColis.setQteNonLivre(stockLigneColis.getQteNonLivre()-l.getQte());
		 * 
		 * 
		 * stockRepository.save(stockLigneColis);
		 * 
		 * }
		 * 
		 * 
		 * 
		 * colisRepository.save(colisStock);
		 * 
		 * h=new Historique(); h.setAction("Livré au client"); h.setColis(colis1);
		 * h.setUtilisateur(livreur1); h.setStatut(br.getStatut());
		 * h.setDateCreation(new Date()); colisStock.getHistoriques().add(h);
		 * historiqueRepository.save(h);
		 * 
		 * 
		 * 
		 * 
		 * // de preference création du bon retour de 1:variante1
		 * 
		 * BonRetour bonRetour = new BonRetour();
		 * 
		 * bonRetour.setClient(client1); bonRetour.setLivreur(livreur1);
		 * 
		 * // historque creation bon retour par le livreur
		 * //bonRetour.setCreerPar(livreur1);
		 * 
		 * Set<LigneColis> colisRetourne = new HashSet<LigneColis>();
		 * 
		 * for(LigneColis ligneColis:colisStock.getLigneColis()) {
		 * if(ligneColis.getQteRetourne()>0) {
		 * 
		 * LigneBonRetour ligneBonRetour = new LigneBonRetour();
		 * 
		 * ligneBonRetour.setBonRetour(bonRetour);
		 * ligneBonRetour.setLigneColis(ligneColis);
		 * 
		 * bonRetour.getLigneBonRetours().add(ligneBonRetour);
		 * 
		 * 
		 * } }
		 * 
		 * bonRetour.setStatut("En attente de retour au stock"); bonRetour=
		 * bonRetourRepository.save(bonRetour);
		 * 
		 * // retourne au stock
		 * 
		 * // Mise à jour qute stock changement des quantités livré sur stock extrait
		 * depuis ligneColis
		 * 
		 * for(LigneColis l : colisStock.getLigneColis()) {
		 * 
		 * Stock stockLigneColis= l.getStock();
		 * 
		 * stockLigneColis.setQteEnCoursLivraison(stockLigneColis.getQteEnCoursLivraison
		 * ()-l.getQteLivre());
		 * stockLigneColis.setQteLivre(stockLigneColis.getQteLivre()+l.getQteLivre());
		 * stockLigneColis.setQteNonLivre(stockLigneColis.getQteNonLivre()-l.getQteLivre
		 * ());
		 * 
		 * 
		 * stockRepository.save(stockLigneColis);
		 * 
		 * }
		 * 
		 * // historque creation bon retour par le livreur où receptioniste agence
		 * bonRetour.setStatut("Retourné au stock"); bonRetour.setDateModification(new
		 * Date()); bonRetour= bonRetourRepository.save(bonRetour);
		 * 
		 * 
		 * // facturation par le livreur1 // refusé
		 * 
		 * facture = new Facture(); //facture.getColis().add(colisStock);
		 * //facture.setClient(client1); facture.setLivreur(livreur1);
		 * facture.setCreerPar(livreur1); facture.setStatut("Non reglé");
		 * 
		 * //int nbColis = 0;
		 * 
		 * for(Colis cc : facture.getColis()) { montantTotalNet=0.0;
		 * 
		 * for(LigneColis lc:cc.getLigneColis()) { montantTotalNet = montantTotalNet + (
		 * lc.getVariante().getPrix()* lc.getQteLivre()) ; //nbColis =
		 * nbColis+lc.getQteLivre(); }
		 * 
		 * }
		 * 
		 * //facture.setNbrColis(facture.getColis().size());
		 * //facture.setTotalNet(montantTotalNet);
		 * 
		 * if(facture.getColis()!=null) {
		 * facture.setNbrColis(facture.getColis().size()); }
		 * 
		 * facture.setType("Livré"); facture = factureRepository.save(facture);
		 * 
		 * System.out.println("facture " + facture.getName());
		 * 
		 * // apres reception du paiement par le livreur
		 * 
		 * 
		 * facture.setStatut("Reglé"); factureRepository.save(facture);
		 */

		// ajouter du ticket apres chaque nouveau colis

		// stock déjà chez le livreur

		// Ramasseur ramasser où pas

		// client saisie BL 3ndna f system genere un QR code

		// rammseur scan code pour rentrer les produits dans notre agence pour
		// dispatcher

		// lecture_ modification_ suppression_ chez superadmin uniquement

		// apres rammassage pas de modification du colis ni bu BL

		// action ramassage

		// Avant ramassage

		// si il a dejà un stock en cours d'éxpedition

		// dispatching

		// agence receptioniste

		// reception en agence en cours de dispatch

		// ==> dispatch des colis en zone apres reception des produits physiquement en
		// rayon

		// génération des listes des expeditions

		// Bon d'éxpedition qui s'alimente avec les colis recu auprès des ramasseurs QR
		// code

		// deux cas de figures :
		// Affectation au livreur

		// Réception du Bon d'éxpedition

		// Pour les clients vue colis uniquement pour suivre le statut des colis

		// Changement de statut de commande

		// selection des colis livrée pour généré factures

		// Changemnets des status de la facture vers reglé par le livreur apres
		// reception de paiement

		// Génération Facture et ticket

		// Apres Livraison

	}
	
	public static Date getDate(int i) {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.DAY_OF_MONTH, i);
		return c.getTime();
	}

}
