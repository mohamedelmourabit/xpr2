package com.xpr.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xpr.dao.helper.XprBaseModel;
import com.xpr.entities.Log;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import java.io.IOException;
import java.util.Date;

@Component
public class LogFactoryImpl implements LogFactory {

    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    private EntityManager entityManager;
    
    public LogFactoryImpl() {
		
	}

    @Transactional()
    public void createLog(String action, XprBaseModel subject) throws IOException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            String login = (String) authentication.getPrincipal();

            Log log = new Log();
            log.setAction(action);
            log.setIncidentDate(new Date());
            log.setTriggeredBy(login);
            log.setSubject(subject.getClass().getSimpleName());
            log.setSubjectId(String.valueOf(subject.getIdentifiant()));
            log.setArchived(false);

            ObjectMapper objectMapper = new ObjectMapper();

            if(action.equals(LogFactory.CREATE) || action.equals(LogFactory.UPDATE) ) {
                log.setNewValue(objectMapper.writeValueAsString(subject));
            }

            if (action.equals(LogFactory.UPDATE) || action.equals(LogFactory.DELETE) ) {
                ObjectMapper mapper = new ObjectMapper();
                log.setOldValue(mapper.writeValueAsString(subject.getSavedState()));
            }

            entityManager.persist(log);
        }
    }

    private String getUserSimpleName(String email) {
    	
    	if(this.entityManager!=null) {
    		Query query = this.entityManager.createNativeQuery(
    		        "SELECT CONCAT(nom, ' ', prenom) FROM utilisateur WHERE email = ?1"
    		        );
    		        return query.setParameter(1, email).getSingleResult().toString();
    	}else {
    		return email;
    	}
    	
        
    }
}
