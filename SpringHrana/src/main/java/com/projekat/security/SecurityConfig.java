package com.projekat.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	@Qualifier("customUserDetail")
 	UserDetailsService userDetailsService;
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	   auth.userDetailsService(userDetailsService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	   http.authorizeRequests().
	   antMatchers("/").permitAll().
	   antMatchers("/vlasnikController/**").hasRole("vlasnik").
	   antMatchers("/korisnikController/**").hasAnyRole("vlasnik","korisnik").
	   and().
	   formLogin().
	   loginPage("/pages/login.jsp").
	   loginProcessingUrl("/login").
	   defaultSuccessUrl("/pages/index.jsp").and().
	   logout().invalidateHttpSession(true).logoutSuccessUrl("/pages/login.jsp").and().
	   exceptionHandling().accessDeniedPage("/pages/dozvole.jsp").
	   and().rememberMe().
	   and().csrf();
	}



	

	
	

}
