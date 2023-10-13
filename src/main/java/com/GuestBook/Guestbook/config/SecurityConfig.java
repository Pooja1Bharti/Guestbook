package com.GuestsBook.Guestbook.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfiguration {

	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("test").password("123").roles("Guest");
		auth.inMemoryAuthentication().withUser("test1").password("123").roles("Administrator");
	}

	@SuppressWarnings("deprecation")
	public void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests().requestMatchers("/guest/**").fullyAuthenticated().and().httpBasic();
		http.authorizeHttpRequests().requestMatchers("/admin/**").hasAnyRole("ADMINISTRATOR").
		anyRequest().fullyAuthenticated().and().httpBasic();
	

	}

	/*
	 * protected void configure(HttpSecurity http) throws Exception {
	 * http.csrf().disable();
	 * http.authorizeHttpRequests().anyRequest().fullyAuthenticated().and().
	 * httpBasic(); }
	 */

	@Bean
	public static NoOpPasswordEncoder passwordEncoder() {
		return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();

	}

}
