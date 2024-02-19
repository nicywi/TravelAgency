package com.travelagency.nastokpl.auth;

import com.travelagency.nastokpl.models.ApplicationUserEntity;
import com.travelagency.nastokpl.models.ApplicationUserRole;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;

@AllArgsConstructor
public class ApplicationUser implements UserDetails {
	private ApplicationUserEntity applicationUserEntity;

	public ApplicationUser(String username,
						   String password,
						   Set<ApplicationUserRole> authorities,
						   boolean accountNonExpired,
						   boolean accountNonLocked,
						   boolean credentialsNonExpired,
						   boolean enabled){
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities(){
		return applicationUserEntity.getAuthorities();
	}

	@Override
	public String getPassword(){
		return applicationUserEntity.getPassword();
	}

	@Override
	public String getUsername(){
		return applicationUserEntity.getUsername();
	}

	@Override
	public boolean isAccountNonExpired(){
		return applicationUserEntity.isAccountNonExpired();
	}

	@Override
	public boolean isAccountNonLocked(){
		return applicationUserEntity.isAccountNonLocked();
	}

	@Override
	public boolean isCredentialsNonExpired(){
		return applicationUserEntity.isCredentialsNonExpired();
	}

	@Override
	public boolean isEnabled(){
		return applicationUserEntity.isEnabled();
	}
}
