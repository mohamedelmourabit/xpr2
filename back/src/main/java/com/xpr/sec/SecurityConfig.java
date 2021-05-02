package com.xpr.sec;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import com.fasterxml.jackson.databind.ObjectMapper;





@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	private static final Logger LOGGER = LogManager.getLogger(SecurityConfig.class);
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
    JWTAuthorizationFilter authorizationFilter;
	
	private final XprAccessDecisionManager accessDecisionManager;

	public SecurityConfig(XprAccessDecisionManager accessDecisionManager) {
		this.accessDecisionManager = accessDecisionManager;
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		// configure AuthenticationManager so that it knows from where to load
		// user for matching credentials
		// Use BCryptPasswordEncoder
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
		
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		
		ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry registry = http.antMatcher("/**").authorizeRequests();

		http.csrf().disable();
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		//http.formLogin(); on quiite la form login
		http.authorizeRequests().antMatchers("/login/**","/register/**","/swagger-ui/**").permitAll();
	
	
		http.authorizeRequests().anyRequest().authenticated();
		http.addFilter(new JWTAuthenticationFilter(authenticationManager()));
		http.addFilterBefore(authorizationFilter, UsernamePasswordAuthenticationFilter.class);
		
		http.exceptionHandling().accessDeniedHandler(accessDeniedHandler()).authenticationEntryPoint(authenticationEntryPoint());

		registry.withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
			@Override
			public <O extends FilterSecurityInterceptor> O postProcess(O o) {
				o.setAccessDecisionManager(accessDecisionManager);
				return o;
			}
		});
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		// TODO Auto-generated method stub
		 web.ignoring().antMatchers("/v2/api-docs",
                 "/configuration/ui",
                 "/swagger-resources/**",
                 "/configuration/security",
                 "/swagger-ui.html",
                 "/webjars/**");
	}
	
	private AuthenticationEntryPoint authenticationEntryPoint() {
		return (httpServletRequest, httpServletResponse, e) -> {
			LOGGER.error(e.getMessage(), e);
			String responseBody = new ObjectMapper().writeValueAsString("UNAUTHORIZED");
			httpServletResponse.setContentType(MediaType.TEXT_PLAIN.toString());
			httpServletResponse.getWriter().append(responseBody);
			httpServletResponse.setStatus(401);
		};
	}

	private AccessDeniedHandler accessDeniedHandler() {
		return (httpServletRequest, httpServletResponse, e) -> {
			LOGGER.error(e.getMessage(), e);
			String responseBody = new ObjectMapper().writeValueAsString("ACCESS DENIED");
			httpServletResponse.getWriter().append(responseBody);
			httpServletResponse.setStatus(403);
			httpServletResponse.setContentType(MediaType.TEXT_PLAIN.toString());
		};
	}
}
