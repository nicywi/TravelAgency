package com.travelagency.nastokpl.auth;

import com.travelagency.nastokpl.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

//@AllArgsConstructor
public class ApplicationUser implements UserDetails {

//	private final String username;
//	private final String password;
//	private final Collection<? extends GrantedAuthority> grantedAuthorities;
//	private final boolean isAccountNonExpired;
//	private final boolean isAccountNonLocked;
//	private final boolean isCredentialsNonExpired;
//	private final boolean isEnabled;
	private User user;

	public ApplicationUser(User user) {
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return user.getAuthorities();
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return user.isAccountNonExpired();
	}

	@Override
	public boolean isAccountNonLocked() {
		return user.isAccountNonLocked();
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return user.isCredentialsNonExpired();
	}

	@Override
	public boolean isEnabled() {
		return user.isEnabled();
	}
}
