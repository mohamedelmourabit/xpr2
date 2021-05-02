package com.xpr.sec;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import com.xpr.dao.AutorisationRepository;
import java.util.Collection;
import java.util.HashSet;

@Service
public class UserAuthorityService {

    private final AutorisationRepository autorisationRepository;

    public UserAuthorityService(AutorisationRepository autorisationRepository) {
        this.autorisationRepository = autorisationRepository;
    }

    public Collection<? extends GrantedAuthority> getGrantedAuthorities(String login) {
        Collection<GrantedAuthority> grantedAuthorities = new HashSet<>();
        Collection<String> authorities = this.autorisationRepository.findAutorisationByUser(login);
        for(String auth : authorities) {
            grantedAuthorities.add(new SimpleGrantedAuthority(auth));
        }
        return grantedAuthorities;
    }

}
