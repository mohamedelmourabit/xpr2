package com.xpr.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.xpr.services.BonRamassageService;
import com.xpr.services.ColisService;
import com.xpr.services.DemandeService;
import com.xpr.services.FactureService;
import com.xpr.utils.Constants;

@RestController
@RequestMapping(path="/dashboard")
public class DashboardController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DashboardController.class);
	
	@Autowired
	private BonRamassageService bonRamassageService;
	
	@Autowired
	private ColisService colisService;
	
	@Autowired
	private DemandeService demandeService;
	
	@Autowired
	private FactureService factureService;
	
	
	@RequestMapping(value="/getStatistics",method=RequestMethod.GET)
	public Map<String,Integer> getStatistics(@RequestParam(name="dateDebutPeriode") String dateDebut,@RequestParam(name="dateFinPeriode") String dateFin){
		
		Map<String,Integer> maps=new HashMap<String, Integer>();
		
		Date dateDebutPeriode;
		Date dateFinPeriode;
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		try {
			dateDebutPeriode = sdf.parse(dateDebut);
			
			 dateFinPeriode = sdf.parse(dateFin);
			
			 
			 Map<Integer,List<Date>> periods= getMonthFromDate(dateDebutPeriode,dateFinPeriode);
			 
			for(Map.Entry<Integer, List<Date>> map:periods.entrySet()) {
				
				map.getKey();
				
				List<Date> dates= map.getValue();
						
				Date dateDebutPeriode1=dates.get(0);
				Date dateFinPeriode1=dates.get(1);
				
				int numberColisLivrePeriode = colisService.getColisByStatutAndDate(Constants.LIVRE, dateDebutPeriode1, dateFinPeriode1);
				
				int numberColisEnCoursPeriode = colisService.getColisByStatutAndDate(Constants.EXPEDIE,dateDebutPeriode1, dateFinPeriode1);
				
				int numberColisAnnulePeriode =colisService.getColisByStatutAndDate(Constants.ANNULE, dateDebutPeriode1, dateFinPeriode1);
				
				Calendar cal = Calendar.getInstance();
				cal.setTime(dateDebutPeriode1);
				
				int month = cal.get(Calendar.MONTH)+1;
				
				maps.put("Mois_"+month+"_ColisLivre", numberColisLivrePeriode);
				
				maps.put("Mois_"+month+"_ColisEnCours", numberColisEnCoursPeriode);
				
				maps.put("Mois_"+month+"_ColisAnnule", numberColisAnnulePeriode);
				
				
			}
			 
			 
		
			
		} catch (ParseException e) {
			throw new RuntimeException("Invalid Pattern date ");
		}
		
		int numberColis = colisService.getCountColis();
		
		
		int numberColisLivre = colisService.getCountColisByStatut(Constants.LIVRE);
		
		int numberColisAnnule = colisService.getCountColisByStatut(Constants.ANNULE);
		
		int numberColisEnAttente = colisService.getCountColisByStatut(Constants.EXPEDIE);
		
		int numberBonLivraison = bonRamassageService.getCountBonRamassages();
		
		int numberFacture = factureService.getCountFactures();
		
		int numberDemandes = demandeService.getCountDemandes();
		
		maps.put("colis", numberColis);
		
		maps.put("colisLivre", numberColisLivre);
		
		maps.put("colisAnnule", numberColisAnnule);
		
		maps.put("colisEnAttente", numberColisEnAttente);
		
		maps.put("bonLivraisons", numberBonLivraison);
		
		maps.put("factures", numberFacture);
		
		maps.put("demandes", numberDemandes);
		
		return maps;
		
		
				
		
	}
	
	private Map<Integer,List<Date>> getMonthFromDate(Date dateDebut,Date dateFin) {
		
		Map<Integer,List<Date>> periods  = new HashMap<Integer, List<Date>>();
		
		
		Date date = dateDebut;
		
		while(date.before(dateFin)) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);

			Date lastDayOfMonth = cal.getTime();
			
			
			List<Date> dates = new ArrayList<Date>();
			
			dates.add(date); 
			dates.add(lastDayOfMonth);
			
			periods.put(cal.get(Calendar.MONTH), dates);
			
			
			cal.setTime(lastDayOfMonth); 
			cal.add(Calendar.DATE, 1);
			
			date =  cal.getTime();
			
		}
		
		return periods;
		
		
		
	}
	
	

}
