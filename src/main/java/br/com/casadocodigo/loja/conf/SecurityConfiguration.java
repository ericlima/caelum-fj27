package br.com.casadocodigo.loja.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService users;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
		.userDetailsService(users)
		.passwordEncoder(new BCryptPasswordEncoder());
	}
	
	
	public void Configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/livros/form").hasRole("ADMIN")
		.antMatchers("/shopping/***").permitAll()
		.antMatchers(HttpMethod.POST, "/livros").hasRole("ADMIN")
		.antMatchers("/livros/***").permitAll()
		.anyRequest().authenticated();
	}

	
	
}
