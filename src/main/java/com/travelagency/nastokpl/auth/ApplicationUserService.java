package com.travelagency.nastokpl.auth;
/*
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//@Service
public class ApplicationUserService{
	private ApplicationUserDAO applicationUserDAO;

	public ApplicationUserService(ApplicationUserDAO applicationUserDAO){
		this.applicationUserDAO = applicationUserDAO;
	}

	public ApplicationUserService(){
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		return applicationUserDAO
				.selectApplicationUserByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException(String.format("Username %s not found", username)));
	}
}
*/