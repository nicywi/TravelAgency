package com.travelagency.nastokpl.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public final class ApplicationUserEntity implements UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String username;

	@Column
	private String password;

	@Column(name = "is_account_mon_expired")
	private boolean isAccountNonExpired;

	@Column(name = "is_account_non_locked")
	private boolean isAccountNonLocked;

	@Column(name = "is_credentials_non_expired")
	private boolean isCredentialsNonExpired;

	@Column(name = "is_enabled")
	private boolean isEnabled;

//	@Enumerated(EnumType.STRING)
//	private ApplicationUserRole authorities;

//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities (){
//		return Collections.singleton(authorities);
//	}

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "user_authorities",
			joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "authority_id", referencedColumnName = "id"))
	private Set<ApplicationUserRole> authorities;

	public <R> ApplicationUserEntity(String username, String password, R collect, boolean accountNonExpired, boolean accountNonLocked, boolean credentialsNonExpired, boolean enabled){
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities(){
		return authorities;
	}

	@Override
	public boolean isAccountNonExpired(){
		return isAccountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked(){
		return isAccountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired(){
		return isCredentialsNonExpired;
	}

	@Override
	public boolean isEnabled(){
		return isEnabled;
	}

}
