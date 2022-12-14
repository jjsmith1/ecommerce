package com.TTS.ecommerce.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.TTS.ecommerce.Services.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

	@Autowired
	private UserService userService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{auth.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()http
			.antMatchers("/cart").authenticated()
			.and().formLogin()
				.loginPage("/signin")
				.loginProcessingUrl("/login")
				.and().logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/signout))")).logoutSuccessUrl("/")
				http.csrf().disable();
		http.headers().frameOptions().disable();
	}
}
