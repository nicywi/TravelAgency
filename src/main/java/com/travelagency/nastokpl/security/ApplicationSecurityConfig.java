package com.travelagency.nastokpl.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true,
		jsr250Enabled = true)
public class ApplicationSecurityConfig {
	@Bean
	public UserDetailsService userDetailsService(PasswordConfig bCPE) {
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		manager.createUser(User.withUsername("admin")
				.password(bCPE.passwordEncoder().encode("userPass"))
				.roles("USER", "ADMIN")
				.build());
		manager.createUser(User.withUsername("user")
				.password(bCPE.passwordEncoder().encode("adminPass"))
				.roles("USER")
				.build());
		return manager;
	}


}
