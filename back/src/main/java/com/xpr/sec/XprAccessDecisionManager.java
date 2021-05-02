package com.xpr.sec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.FilterInvocation;
import org.springframework.stereotype.Component;

import com.xpr.dao.AutorisationRepository;
import com.xpr.entities.Autorisation;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class XprAccessDecisionManager implements AccessDecisionManager {

    private AutorisationRepository autorisationRepository;

    @Autowired
    public void setAutorisationRepository(AutorisationRepository autorisationRepository) {
        this.autorisationRepository = autorisationRepository;
    }

    /**
     * @param authentication: Role information of current login user
     * @param object: Request url information
     * @param collection: `UrlFilterInvocationSecurityMetadataSource`From the getAttributes method in, indicating the roles required by the current request (there may be more than one)
     * return: void
     */
    @Override
    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> collection) throws AccessDeniedException, AuthenticationException {
        HttpServletRequest request = ((FilterInvocation)object).getRequest();
        Set<String> requiredRoles = this.getRequiredRoles(request.getRequestURI().replace(request.getContextPath(), ""));

        if (requiredRoles.size() > 0 && authentication instanceof AnonymousAuthenticationToken) {
             throw new BadCredentialsException("Unauthenticated user");
        } else {
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
            for (GrantedAuthority authority : authorities) {
                if (requiredRoles.contains(authority.getAuthority()))
                    return;
            }
        }

        throw new AccessDeniedException("Unauthorized operation");
    }

    private Set<String> getRequiredRoles(String uri) {
        String moduleUrI = uri.substring(0, uri.substring(1).indexOf('/') + 1);
        Set<Autorisation> authorisations = this.autorisationRepository.findByUri(moduleUrI);
        return authorisations.stream().map(Autorisation::getAuthName).collect(Collectors.toSet());
    }

    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
