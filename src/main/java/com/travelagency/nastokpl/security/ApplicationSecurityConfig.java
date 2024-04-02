package com.travelagency.nastokpl.security;

import com.travelagency.nastokpl.auth.JDBCUserDetailsService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(proxyTargetClass = true, securedEnabled = true)
public class ApplicationSecurityConfig {
	private JDBCUserDetailsService jdbcUserDetailsService;

//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//		auth
//				.userDetailsService(jdbcUserDetailsService)
//				.passwordEncoder(passwordEncoder());
//	}

	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder(10);
	}


	// datasource sdo sprawdzenia
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http.csrf(AbstractHttpConfigurer::disable)
				.authorizeHttpRequests(authorizationManagerRequestMatcherRegistry -> authorizationManagerRequestMatcherRegistry
//						.requestMatchers("/js/**", "/images/**", "/trips/**"/*, "/search/**", "/purchase/**", "/home/**", "/**"*/)
//						.permitAll()
						.requestMatchers(HttpMethod.DELETE).hasRole("ADMIN")
						.requestMatchers("/admin/**").hasAnyRole("ADMIN")
						.requestMatchers("/user/**").hasAnyRole("USER", "ADMIN")
						.requestMatchers("/login/**").permitAll()
						.anyRequest().authenticated())
				.httpBasic(Customizer.withDefaults())/*
				.sessionManagement(httpSecuritySessionManagementConfigurer -> httpSecuritySessionManagementConfigurer
//						.sessionCreationPolicy(SessionCreationPolicy.STATELESS))*/;

		return http.build();
	}

	@Bean
	public AuthenticationManager authenticationManager(@Qualifier("JDBCUserDetailsService") UserDetailsService userDetailsService) {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(passwordEncoder());
		return new ProviderManager(provider);
	}

	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
		return (web) -> web.ignoring().requestMatchers("/js/**", "/images/**"/*, "/trips/**", "/search/**", "/purchase/**", "/home/**", "/**"*/);
	}

}
