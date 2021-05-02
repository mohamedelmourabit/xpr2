package com.xpr.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.xpr.dao.core.view.ModelViews;
import com.xpr.dao.helper.XprBaseModel;
import com.xpr.utils.StringAttributeConverter;


@Entity
@Table(name = "colis")
public class Colis extends XprBaseModel implements Serializable,Cloneable {
	
	@Id
	@GenericGenerator(name = "colis_numCommande", strategy = "com.xpr.generator.ColisGenerator")
    @GeneratedValue(generator = "colis_numCommande") 
	@JsonView(ModelViews.SelectView.class)
	private String numCommande;
	
	@JsonView(ModelViews.SelectView.class)
	private String codeEnvoi;
	
	@JsonView(ModelViews.SelectView.class)
	private String idIntern;
	
	@JsonView(ModelViews.SelectView.class)
	private String typeLivraison;
	
	// à crypter
	//@Convert(converter = StringAttributeConverter.class)
	@JsonView(ModelViews.SelectView.class)
	private String nomComplet;
	
	@JsonView(ModelViews.ListView.class)
	private Date dateRamassage;
	
	@JsonView(ModelViews.ListView.class)
	private Date dateLivraison;
	
	@JsonView(ModelViews.SelectView.class)
	private boolean ouvertureColis;
	
	@JsonView(ModelViews.SelectView.class)
	private boolean applicationFrais;
	
	@JsonView(ModelViews.SelectView.class)
	private boolean applicationFraisAssurance;
	
	@Column(columnDefinition = "TEXT")
	@JsonView(ModelViews.SelectView.class)
	private String remarque;

	//crypté
	//@Convert(converter = StringAttributeConverter.class)
	@JsonView(ModelViews.SelectView.class)
	private String destinataire;
	
	// telephone
	//@Convert(converter = StringAttributeConverter.class)
	@JsonView(ModelViews.SelectView.class)
	private String telephone;
	
	@ManyToOne
	@JsonView(ModelViews.SelectView.class)
	private Ville villeDestination;
	
	@JsonView(ModelViews.SelectView.class)
	private String secteur;
	
	@Column(columnDefinition = "TEXT")
	@JsonView(ModelViews.SelectView.class)
	private String adresse;
	
		
	@ManyToOne
	@JsonIgnore
	private Facture facture;

	@ManyToOne
	@JsonIgnore
	private BonRamassage bonRamassage;
	
	
	@ManyToOne
	@JsonView(ModelViews.SelectView.class)
	private Client client;
	
	@ManyToOne
	@JsonView(ModelViews.SelectView.class)
	private Entite entite;
	
	@ManyToOne
	@JsonIgnore
	private Livreur livreur;
	
	@ManyToOne
	@JsonIgnore
	private Ramasseur ramasseur;
	
	@ManyToOne
	@JoinColumn(name="status_id")
    @JsonView(ModelViews.SelectView.class)
	private StatutColis statut;
	
	@JsonView(ModelViews.ListView.class)
	private boolean disabled;
		
	@ManyToOne
	@JsonIgnore
	private Business business;
	
	@ManyToOne
	@JsonIgnore
	private BonExpedition bonExpedition;
	
	@ManyToOne
	@JsonIgnore
	private BonRetour bonRetour;
	

	@OneToMany(mappedBy = "colis",fetch = FetchType.EAGER)
	private Set<HistoriqueColis> historiques;
	
	@OneToMany(mappedBy = "colis",fetch = FetchType.EAGER)
	@JsonIgnore
	private Set<Commentaire> commentaires;
	
	
	@OneToMany(mappedBy = "colis",fetch = FetchType.EAGER)
	 @JsonView(ModelViews.SelectView.class)
	private Set<LigneColis> ligneColis = new HashSet<LigneColis>();

	@JsonView(ModelViews.ListView.class)
	private boolean facturer;
	
	@JsonView(ModelViews.ListView.class)
	private boolean facturerClient;
	
	
	public Colis() {
		
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


	public String getNumCommande() {
		return numCommande;
	}

	public void setNumCommandeWithPrefix(String numCommande) {
		
		if(this.client!=null) {
			this.numCommande = this.client.getPrefixCommande()+"-"+numCommande;
		}else {
			this.numCommande = numCommande;
		}
	}
	
	public void setNumCommande(String numCommande) {
		
		
		this.numCommande = numCommande;
		
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

	public Facture getFacture() {
		return facture;
	}

	public void setFacture(Facture facture) {
		this.facture = facture;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Livreur getLivreur() {
		return livreur;
	}

	public void setLivreur(Livreur livreur) {
		this.livreur = livreur;
	}


	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

	public String getRemarque() {
		return remarque;
	}

	public void setRemarque(String remarque) {
		this.remarque = remarque;
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

	public BonRamassage getBonRamassage() {
		return bonRamassage;
	}

	public void setBonRamassage(BonRamassage bonRamassage) {
		this.bonRamassage = bonRamassage;
	}

	

	public Set<Commentaire> getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(Set<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}

	public Ville getVilleDestination() {
		return villeDestination;
	}

	public void setVilleDestination(Ville villeDestination) {
		this.villeDestination = villeDestination;
	}


	public BonRetour getBonRetour() {
		return bonRetour;
	}

	public void setBonRetour(BonRetour bonRetour) {
		this.bonRetour = bonRetour;
	}

	public Ramasseur getRamasseur() {
		return ramasseur;
	}

	public void setRamasseur(Ramasseur ramasseur) {
		this.ramasseur = ramasseur;
	}

	
	public Set<LigneColis> getLigneColis() {
		return ligneColis;
	}

	public void setLigneColis(Set<LigneColis> ligneColis) {
		this.ligneColis = ligneColis;
	}
		
	public String getCodeEnvoi() {
		return codeEnvoi;
	}

	public void setCodeEnvoi(String codeEnvoi) {
		this.codeEnvoi = codeEnvoi;
	}
	
	public Colis clone() throws CloneNotSupportedException{
	    return (Colis) super.clone();
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

	public Entite getEntite() {
		return entite;
	}

	public void setEntite(Entite entite) {
		this.entite = entite;
	}

	public String getIdIntern() {
		return idIntern;
	}

	public void setIdIntern(String idIntern) {
		this.idIntern = idIntern;
	}

	public StatutColis getStatut() {
		return statut;
	}

	public void setStatut(StatutColis statut) {
		this.statut = statut;
	}

	public Set<HistoriqueColis> getHistoriques() {
		return historiques;
	}

	public void setHistoriques(Set<HistoriqueColis> historiques) {
		this.historiques = historiques;
	}
	
	
	
	
	
	
}
