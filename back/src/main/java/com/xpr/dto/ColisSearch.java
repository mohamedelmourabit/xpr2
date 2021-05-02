package com.xpr.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Convert;
import javax.persistence.ManyToOne;
import com.xpr.entities.BonExpedition;
import com.xpr.entities.BonRetour;
import com.xpr.entities.Business;
import com.xpr.entities.Client;
import com.xpr.entities.Commentaire;
import com.xpr.entities.Entite;
import com.xpr.entities.Historique;
import com.xpr.entities.LigneColis;
import com.xpr.entities.Livreur;
import com.xpr.entities.Ramasseur;
import com.xpr.entities.Utilisateur;
import com.xpr.entities.Ville;
import com.xpr.utils.StringAttributeConverter;


public class ColisSearch {
	
	private String numCommande;
	
	private String periode;
	
	
	private String codeEnvoi;
	
	private boolean stock;
	
	private String idIntern;
	
	
	private String typeLivraison;
	
	
	private String nomComplet;
	
	
	private Date dateRamassage;
	
	
	private Date dateLivraison;
	
	
	private Date dateCreation;
	
	private Date dateModification;
	
	
	private boolean ouvertureColis;
	
	private boolean applicationFrais;
	
	private boolean applicationFraisAssurance;
	

	private String remarque;

	@Convert(converter = StringAttributeConverter.class)
	private String destinataire;
	
	@Convert(converter = StringAttributeConverter.class)
	private String telephone;
	
	
	private Ville villeDestination;
	
	private String secteur;
	
	private String adresse;
	
	private double crbt;
	

	private Client client;
	

	private Entite entite;
	
	
	private Livreur livreur;
	
	
	private Ramasseur ramasseur;
	
	private String statutCode;
	
	private String statutLibelle;
	
	private boolean disabled;
		
	
	private Business business;
	
	
	private BonExpedition bonExpedition;
	
	
	private BonRetour bonRetour;
	
	

	
	private Set<Historique> historiques=new HashSet<Historique>();
	
	
	private Set<Commentaire> commentaires=new HashSet<Commentaire>();
	
	

	private Set<LigneColis> ligneColis=new HashSet<LigneColis>();

	
	private Utilisateur creerPar;
	
	@ManyToOne
	private Utilisateur modifierPar;
	

	
	private boolean facturer;
	
	private boolean facturerClient;
	
	private String produitName;
	
	private String varianteName;
	
	private Integer prix;
	
	
	private String mc;
	
	private Date dateDu;
	
	private Date dateAu;


	public ColisSearch() {
		super();
	}


	public String getNumCommande() {
		return numCommande;
	}


	public void setNumCommande(String numCommande) {
		this.numCommande = numCommande;
	}


	public String getCodeEnvoi() {
		return codeEnvoi;
	}


	public void setCodeEnvoi(String codeEnvoi) {
		this.codeEnvoi = codeEnvoi;
	}


	public boolean isStock() {
		return stock;
	}


	public void setStock(boolean stock) {
		this.stock = stock;
	}


	public String getIdIntern() {
		return idIntern;
	}


	public void setIdIntern(String idIntern) {
		this.idIntern = idIntern;
	}


	public String getTypeLivraison() {
		return typeLivraison;
	}


	public void setTypeLivraison(String typeLivraison) {
		this.typeLivraison = typeLivraison;
	}


	public String getNomComplet() {
		return nomComplet;
	}


	public void setNomComplet(String nomComplet) {
		this.nomComplet = nomComplet;
	}


	public Date getDateRamassage() {
		return dateRamassage;
	}


	public void setDateRamassage(Date dateRamassage) {
		this.dateRamassage = dateRamassage;
	}


	public Date getDateLivraison() {
		return dateLivraison;
	}


	public void setDateLivraison(Date dateLivraison) {
		this.dateLivraison = dateLivraison;
	}


	public Date getDateCreation() {
		return dateCreation;
	}


	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}


	public Date getDateModification() {
		return dateModification;
	}


	public void setDateModification(Date dateModification) {
		this.dateModification = dateModification;
	}


	public boolean isOuvertureColis() {
		return ouvertureColis;
	}


	public void setOuvertureColis(boolean ouvertureColis) {
		this.ouvertureColis = ouvertureColis;
	}


	public boolean isApplicationFrais() {
		return applicationFrais;
	}


	public void setApplicationFrais(boolean applicationFrais) {
		this.applicationFrais = applicationFrais;
	}


	public boolean isApplicationFraisAssurance() {
		return applicationFraisAssurance;
	}


	public void setApplicationFraisAssurance(boolean applicationFraisAssurance) {
		this.applicationFraisAssurance = applicationFraisAssurance;
	}


	public String getRemarque() {
		return remarque;
	}


	public void setRemarque(String remarque) {
		this.remarque = remarque;
	}


	public String getDestinataire() {
		return destinataire;
	}


	public void setDestinataire(String destinataire) {
		this.destinataire = destinataire;
	}


	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	public Ville getVilleDestination() {
		return villeDestination;
	}


	public void setVilleDestination(Ville villeDestination) {
		this.villeDestination = villeDestination;
	}


	public String getSecteur() {
		return secteur;
	}


	public void setSecteur(String secteur) {
		this.secteur = secteur;
	}


	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public double getCrbt() {
		return crbt;
	}


	public void setCrbt(double crbt) {
		this.crbt = crbt;
	}


	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}


	public Entite getEntite() {
		return entite;
	}


	public void setEntite(Entite entite) {
		this.entite = entite;
	}


	public Livreur getLivreur() {
		return livreur;
	}


	public void setLivreur(Livreur livreur) {
		this.livreur = livreur;
	}


	public Ramasseur getRamasseur() {
		return ramasseur;
	}


	public void setRamasseur(Ramasseur ramasseur) {
		this.ramasseur = ramasseur;
	}


	


	public String getStatutCode() {
		return statutCode;
	}


	public void setStatutCode(String statutCode) {
		this.statutCode = statutCode;
	}


	public String getStatutLibelle() {
		return statutLibelle;
	}


	public void setStatutLibelle(String statutLibelle) {
		this.statutLibelle = statutLibelle;
	}


	public boolean isDisabled() {
		return disabled;
	}


	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}


	public Business getBusiness() {
		return business;
	}


	public void setBusiness(Business business) {
		this.business = business;
	}


	public BonExpedition getBonExpedition() {
		return bonExpedition;
	}


	public void setBonExpedition(BonExpedition bonExpedition) {
		this.bonExpedition = bonExpedition;
	}


	public BonRetour getBonRetour() {
		return bonRetour;
	}


	public void setBonRetour(BonRetour bonRetour) {
		this.bonRetour = bonRetour;
	}


	public Set<Historique> getHistoriques() {
		return historiques;
	}


	public void setHistoriques(Set<Historique> historiques) {
		this.historiques = historiques;
	}


	public Set<Commentaire> getCommentaires() {
		return commentaires;
	}


	public void setCommentaires(Set<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}


	public Set<LigneColis> getLigneColis() {
		return ligneColis;
	}


	public void setLigneColis(Set<LigneColis> ligneColis) {
		this.ligneColis = ligneColis;
	}


	public Utilisateur getCreerPar() {
		return creerPar;
	}


	public void setCreerPar(Utilisateur creerPar) {
		this.creerPar = creerPar;
	}


	public Utilisateur getModifierPar() {
		return modifierPar;
	}


	public void setModifierPar(Utilisateur modifierPar) {
		this.modifierPar = modifierPar;
	}


	public boolean isFacturer() {
		return facturer;
	}


	public void setFacturer(boolean facturer) {
		this.facturer = facturer;
	}


	public boolean isFacturerClient() {
		return facturerClient;
	}


	public void setFacturerClient(boolean facturerClient) {
		this.facturerClient = facturerClient;
	}


	public String getMc() {
		return mc;
	}


	public void setMc(String mc) {
		this.mc = mc;
	}


	public String getProduitName() {
		return produitName;
	}


	public void setProduitName(String produitName) {
		this.produitName = produitName;
	}


	public String getVarianteName() {
		return varianteName;
	}


	public void setVarianteName(String varianteName) {
		this.varianteName = varianteName;
	}


	public Integer getPrix() {
		return prix;
	}


	public void setPrix(Integer prix) {
		this.prix = prix;
	}


	public Date getDateDu() {
		return dateDu;
	}


	public void setDateDu(Date dateDu) {
		this.dateDu = dateDu;
	}


	public Date getDateAu() {
		return dateAu;
	}


	public void setDateAu(Date dateAu) {
		this.dateAu = dateAu;
	}


	public String getPeriode() {
		return periode;
	}


	public void setPeriode(String periode) {
		this.periode = periode;
	}
	
	
	
	

}
