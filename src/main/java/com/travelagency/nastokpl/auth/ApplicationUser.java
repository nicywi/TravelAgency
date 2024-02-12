package com.travelagency.nastokpl.auth;

import com.travelagency.nastokpl.model.ApplicationUserEntity;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@AllArgsConstructor
public class ApplicationUser implements UserDetails {
	private ApplicationUserEntity applicationUserEntity;

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
