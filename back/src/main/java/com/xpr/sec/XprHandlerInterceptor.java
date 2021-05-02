package com.xpr.sec;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.xpr.dao.UtilisateurRepository;
import com.xpr.dao.annotation.XprRole;
import com.xpr.entities.Livreur;
import com.xpr.entities.Utilisateur;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class XprHandlerInterceptor implements HandlerInterceptor {

    public UtilisateurRepository userRepository;
    
    
    public XprHandlerInterceptor() {
		
	}

    @Autowired
    public void setUserRepository(UtilisateurRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws AccessDeniedException {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            if (handlerMethod.hasMethodAnnotation(XprRole.class)) {
                XprRole annotation = handlerMethod.getMethodAnnotation(XprRole.class);
                if(annotation != null) {
                    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
                    Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
                    String action = annotation.role().name().toUpperCase();
                    String controller = this.getControllerName(handlerMethod);
                    String role = controller + "$" + action;
                    List<String> actionUserRoles = authorities.stream()
                            .filter(grantedAuthority -> grantedAuthority.getAuthority().startsWith(role))
                            .map(GrantedAuthority::getAuthority)
                            .collect(Collectors.toList());

                    if (actionUserRoles.size() == 0) {
                        throw new AccessDeniedException("Unauthorized operation");
                    }

                    String login = (String) authentication.getPrincipal();
                   
                    Utilisateur user = this.userRepository.findByEmail(login);
                    
                    Set<String> usersClient = this.userRepository.getAllUsersForClient(login);
                    
                    Set<String> usersEntite = this.userRepository.getAllUsersForEntite(login);
                    
                    request.setAttribute("usersClient", usersClient);
                    request.setAttribute("usersEntite", usersEntite);

                    request.setAttribute("actionUserRoles", actionUserRoles);
                    request.setAttribute("controller", controller);
                    request.setAttribute("action", action);
                    request.setAttribute("view", annotation.view());
                   
                    
                    request.setAttribute("user", user);
                }
            }
        }
        return true;
    }

    private String getControllerName(HandlerMethod handlerMethod) {
        String controller = handlerMethod.getBeanType().getSimpleName().replace("Controller", "");
        String regex = "(?=[A-Z][a-z])";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(controller);
        return matcher.replaceAll("-").toUpperCase().substring(1);
    }
}
