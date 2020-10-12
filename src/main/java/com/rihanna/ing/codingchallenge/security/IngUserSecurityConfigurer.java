package com.rihanna.ing.codingchallenge.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.rihanna.ing.codingchallenge.security.filter.JwtRequestFilter;
import com.rihanna.ing.codingchallenge.service.IngUserDetailService;

@EnableWebSecurity
public class IngUserSecurityConfigurer extends WebSecurityConfigurerAdapter {
	
	@Autowired
	IngPasswordEncoder ingPasswordEncoder;
	
	@Autowired
	private JwtRequestFilter jwtRequestFilter;
	
	@Autowired
	private IngUserDetailService ingUserDetailService;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(ingUserDetailService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
			.antMatchers("/ing/api/user/update*").authenticated()
			.antMatchers("/ing/api/user/update*").hasRole("ADMIN") // Only Admin can update users
			.antMatchers("/ing/api/login").permitAll()
			.antMatchers("/ing/v2/api-docs").permitAll()
			.antMatchers("/ing/swagger-ui/index.html").permitAll()
			.and()
			.csrf().disable()
			.exceptionHandling().and()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
	}

	@Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/ing/v2/api-docs",
                                   "/ing/configuration/ui",
                                   "/ing/swagger-resources/**",
                                   "/ing/configuration/security",
                                   "/ing/swagger-ui.html",
                                   "/ing/webjars/**");
    }

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
}
