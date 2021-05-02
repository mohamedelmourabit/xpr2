package com.xpr.sec;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import javax.servlet.FilterChain;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xpr.dao.ClientRepository;
import com.xpr.dao.UtilisateurRepository;
import com.xpr.entities.Profile;
import com.xpr.entities.Utilisateur;
import com.xpr.services.AccountService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	
	
	private AuthenticationManager authenticationManager;
	
	
	private UtilisateurRepository utilisateurRepository;
				
	
	private ClientRepository clientRepository;
	
	private AccountService accountService;
	
	public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
		super();
		this.authenticationManager = authenticationManager;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		
		Utilisateur user = null;
		
		try {
			user = new ObjectMapper().readValue(request.getInputStream(), Utilisateur.class);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}  
		
		
	
		return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
	}
	
	@Bean
	public PasswordEncoder passwordEncoder(){
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
	
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
	
		String encodedString = Base64.getEncoder().encodeToString(SecurityConstants.SECRET.getBytes());
		System.out.println("auth "+ authResult.getName());
		
		if(utilisateurRepository==null && clientRepository ==null && accountService==null ){
            ServletContext servletContext = request.getServletContext();
            WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
            utilisateurRepository = webApplicationContext.getBean(UtilisateurRepository.class);
            clientRepository = webApplicationContext.getBean(ClientRepository.class);
            accountService = webApplicationContext.getBean(AccountService.class);
		}
		
		
		Utilisateur u =utilisateurRepository.findUserWithAuthorisationsByUsername(authResult.getName());
		
		List<String> profiles = new ArrayList<String>();
		
		for(Profile p : u.getProfiles()) {
			profiles.add(p.getPrflName());
		}
		
		
		
		String jwt = Jwts.builder()
					.setSubject(u.getEmail())
					.setExpiration(new Date(System.currentTimeMillis()+SecurityConstants.EXPIRATION_TIME))
					.signWith(SignatureAlgorithm.HS256, encodedString)
					.claim("profiles", profiles)
					.claim("roles", authResult.getAuthorities())
					.claim("cni", u.getCni())
					.claim("clientId", u.getClient().getIce())
					.claim("clientName",u.getClient().getNom())
					.claim("prenom", u.getPrenom())
					.claim("nom", u.getNom())
					.claim("typeUtilisateur", u.getTypeUtilisateur())
					.claim("entiteId", u.getEntite().getId())
					.claim("entiteName", u.getEntite().getNom())
					.compact();
		
		System.out.println("jwt " + jwt);
		response.addHeader(SecurityConstants.HEADER_STRING, SecurityConstants.TOKEN_PREFIX+jwt);
		System.out.println("successful");
	}

}
