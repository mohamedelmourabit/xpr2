package com.xpr.sec;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Collection;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Component
public class JWTAuthorizationFilter extends OncePerRequestFilter {
	
	private final UserAuthorityService userAuthorityService;

	public JWTAuthorizationFilter(UserAuthorityService userAuthorityService) {
		this.userAuthorityService = userAuthorityService;
	}


	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {


		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Headers",
				"Origin, Accept, X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers,authorization");
		response.addHeader("Access-Control-Expose-Headers",
				"Access-Control-Allow-Origin, Access-Control-Allow-Credentials, authorization");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS, PUT, DELETE");

		if (request.getMethod().equals("OPTIONS")) {

			response.setStatus(HttpServletResponse.SC_OK);
		} else {
			if (request.getParameter("token") != null) {
				response.addHeader("Access-Control-Allow-Credentials", "true");
				String jwt = request.getParameter("token");
			
				if (jwt == null || !jwt.startsWith(SecurityConstants.TOKEN_PREFIX)) {
					filterChain.doFilter(request, response);
					return;
				} else {
					Claims claims = Jwts.parser().setSigningKey(SecurityConstants.SECRET)
							.parseClaimsJws(jwt.replace(SecurityConstants.TOKEN_PREFIX, "")).getBody();

					String username = claims.getSubject();

					Collection<? extends GrantedAuthority> authorities = this.userAuthorityService.getGrantedAuthorities(username);
					UsernamePasswordAuthenticationToken authenticatedUser = new UsernamePasswordAuthenticationToken(username, null,authorities);
					SecurityContextHolder.getContext().setAuthentication(authenticatedUser);
					filterChain.doFilter(request, response);
				}
			} else {

				String jwt = request.getHeader(SecurityConstants.HEADER_STRING);
				
				if (jwt == null || !jwt.startsWith(SecurityConstants.TOKEN_PREFIX)) {
					filterChain.doFilter(request, response);
					return;
				} else {

					
					Claims claims= Jwts.parser().setSigningKey(SecurityConstants.SECRET.getBytes(Charset.forName("UTF-8"))).parseClaimsJws(jwt.replace(SecurityConstants.TOKEN_PREFIX, "").replace("{", "").replace("}","")).getBody();
					
					String username = claims.getSubject();

					Collection<? extends GrantedAuthority> authorities = this.userAuthorityService.getGrantedAuthorities(username);
					UsernamePasswordAuthenticationToken authenticatedUser = new UsernamePasswordAuthenticationToken(username, null,authorities);
					SecurityContextHolder.getContext().setAuthentication(authenticatedUser);
					filterChain.doFilter(request, response);


					

				}
			}
		}
	}

}
