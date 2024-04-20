package com.travelagency.nastokpl.security;

import com.travelagency.nastokpl.auth.JDBCUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(proxyTargetClass = true, securedEnabled = true)
public class ApplicationSecurityConfig {

	@Autowired
//	private DataSource dataSource;
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
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		http.csrf(AbstractHttpConfigurer::disable)
				.cors(AbstractHttpConfigurer::disable)
				.authorizeHttpRequests(authorization -> authorization
						.requestMatchers("/js/**", "/images/**"
								,SecurityApiPaths.HOME_PAGE.getEndpoint()
								,SecurityApiPaths.SIGN_IN_PAGE.getEndpoint()
								,SecurityApiPaths.SIGN_IN_API.getEndpoint()
								,SecurityApiPaths.SIGN_OUT_API.getEndpoint()
								,SecurityApiPaths.REGISTER_PAGE.getEndpoint()
								/*, "/trips/**", "/search/**", "/purchase/**", "/home/**", "/**"*/)
						.permitAll()
						.anyRequest().authenticated()
				).formLogin(
						f -> f
								.loginPage(SecurityApiPaths.SIGN_IN_PAGE.getEndpoint())
								.loginProcessingUrl(SecurityApiPaths.SIGN_IN_API.getEndpoint())
								.defaultSuccessUrl(SecurityApiPaths.HOME_PAGE.getEndpoint(),true)
								.failureUrl(SecurityApiPaths.SIGN_OUT_API.getEndpoint() + "?error")
								.permitAll()
				).logout(
						l -> l
								.logoutUrl(SecurityApiPaths.SIGN_OUT_API.getEndpoint())
								.invalidateHttpSession(true)
								.deleteCookies("JSESSIONID")
								.logoutSuccessUrl(SecurityApiPaths.HOME_PAGE.getEndpoint())
								.permitAll()
				).httpBasic(Customizer.withDefaults())
				.sessionManagement(httpSecuritySessionManagementConfigurer -> httpSecuritySessionManagementConfigurer
						.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		return http.build();
	}

	@Bean
	public AuthenticationManager authenticationManager(@Qualifier("JDBCUserDetailsService") UserDetailsService userDetailsService) {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(passwordEncoder());
		return new ProviderManager(provider);
	}
}
