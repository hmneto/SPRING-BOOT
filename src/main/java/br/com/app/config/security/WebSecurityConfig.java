package br.com.app.config.security;

import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SuppressWarnings("deprecation")
//@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	public UserDetailsServiceImpl userDetailsService;

	public WebSecurityConfig(UserDetailsServiceImpl userDetailsService) {
		this.userDetailsService = userDetailsService;
	}

	// @Bean
	// public AuthenticationManager authenticationManager() throws Exception {
	// return super.authenticationManagerBean();
	// }

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//Authentication in memory 
		
		// auth.inMemoryAuthentication()
		// .withUser("admin")
		// .password(passwordEncoder().encode("123"))
		// .roles("Admin");
		// auth.userDetailsService(this.userDetailsService).passwordEncoder(passwordEncoder());
		
		// Authentication in database
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic().and().authorizeHttpRequests().anyRequest().authenticated().and().csrf().disable()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
