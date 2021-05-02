package com.xpr.services;

import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xpr.dao.AutorisationRepository;
import com.xpr.entities.Autorisation;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class DefaultRolesPopulator implements RolesPopulator {


    private AutorisationRepository autorisationRepository;

    private ListableBeanFactory listableBeanFactory;
    
    private List<String> unusedController = Arrays.asList("openApiWebMvc","apiResource","basicError","swagger2WebMvc");

    @Autowired
    public void setListableBeanFactory(ListableBeanFactory listableBeanFactory) {
        this.listableBeanFactory = listableBeanFactory;
    }

    @Autowired
    public void setAutorisationRepository(AutorisationRepository autorisationRepository) {
        this.autorisationRepository = autorisationRepository;
    }

    @Override
    public boolean run() {

        Map<String, Object> controllers = listableBeanFactory.getBeansWithAnnotation(Controller.class);

        System.out.println("Populating roles");
        final String[] relations = { "ALL", "ENTITE","CLIENT"};
        final String[] actions = {"CREATE", "UPDATE", "DELETE", "LIST", "LISTSELECT"};
        
        final String[] relationsLivreur = {"LIVREUR"};
        final String[] actions2 = { "UPDATE","LIST", "LISTSELECT"};
        
        final String[] relationsRamasseur = {"RAMASSEUR"};

        controllers.forEach((key, value) ->  {
            String controller = key.replace("Controller", "");
            System.out.println("Controller "+ controller);
            if(!unusedController.contains(controller)) {
            	
	            final String[] uri = new String[1];
	
	            Arrays.stream(value.getClass().getAnnotations()).forEach(
	                annotation -> {
	                    if (annotation instanceof RequestMapping) {
	                        String[] path = ((RequestMapping) annotation).path();
	                        uri[0] = path.length > 0 ? path[0] : "";
	                    }
	                }
	            );
	
	            final String regex = "(?=[A-Z][a-z])";
	            final Pattern pattern = Pattern.compile(regex);
	            final Matcher matcher = pattern.matcher(controller);
	
	            controller = matcher.replaceAll("-").toUpperCase();
	            for (String action : actions) {
	                for(String relation : relations) {
	                	
	                
	                    String role = controller + "$" + action + "$" + relation;
	                    Optional<Autorisation> result = Optional.ofNullable(this.autorisationRepository.findByAuthName(role));
	                    if (!result.isPresent()) {
	                        System.out.println(role);
	                        Autorisation autorisation = new Autorisation();
	                        autorisation.setAuthName(role);
	                        autorisation.setUri(uri[0]);
	                        this.autorisationRepository.save(autorisation);
	                    }
	                }
	            }
	            
	            if(controller.equals("colisRest") || controller.equals("factureRest") || controller.equals("bonRetourRest")  ) {
	            	for (String action : actions2) {
		                for(String relation : relationsLivreur) {
		                	
		                
		                    String role = controller + "$" + action + "$" + relation;
		                    Optional<Autorisation> result = Optional.ofNullable(this.autorisationRepository.findByAuthName(role));
		                    if (!result.isPresent()) {
		                        System.out.println(role);
		                        Autorisation autorisation = new Autorisation();
		                        autorisation.setAuthName(role);
		                        autorisation.setUri(uri[0]);
		                        this.autorisationRepository.save(autorisation);
		                    }
		                }
		            }
	            }
	            
	            if(controller.equals("bonRamassageRest") ) {
	            	for (String action : actions2) {
		                for(String relation : relationsRamasseur) {
		                	
		                
		                    String role = controller + "$" + action + "$" + relation;
		                    Optional<Autorisation> result = Optional.ofNullable(this.autorisationRepository.findByAuthName(role));
		                    if (!result.isPresent()) {
		                        System.out.println(role);
		                        Autorisation autorisation = new Autorisation();
		                        autorisation.setAuthName(role);
		                        autorisation.setUri(uri[0]);
		                        this.autorisationRepository.save(autorisation);
		                    }
		                }
		            }
	            }
	            
            }});

        return true;
        
    }
}
