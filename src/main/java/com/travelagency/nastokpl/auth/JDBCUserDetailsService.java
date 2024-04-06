package com.travelagency.nastokpl.auth;

import com.travelagency.nastokpl.models.ApplicationUserEntity;
import jakarta.annotation.Nullable;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Service
@NoArgsConstructor(force = true)
public class JDBCUserDetailsService implements UserDetailsService {
	private final JdbcTemplate jdbcTemplate;
	private final ApplicationUserDAO applicationUserDAO;

	public JDBCUserDetailsService(JdbcTemplate jdbcTemplate, ApplicationUserDAO applicationUserDAO){
		this.jdbcTemplate = jdbcTemplate;
		this.applicationUserDAO = applicationUserDAO;
	}

	@Override
	@Nullable
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		Objects.requireNonNull(jdbcTemplate);
		List<ApplicationUserEntity> users = jdbcTemplate.query(
				"""
								SELECT * FROM users WHERE username = ?;
						""",
				new RowMapper<ApplicationUserEntity>() {
					@Override
					public ApplicationUserEntity mapRow(@NonNull ResultSet rs, int rowNum) throws SQLException{
						ApplicationUserEntity user = new ApplicationUserEntity();
						user.setId(rs.getLong("id"));
						user.setUsername(rs.getString("username"));
						user.setPassword(rs.getString("password"));
						user.setAccountNonExpired(rs.getBoolean("is_account_mon_expired"));
						user.setAccountNonLocked(rs.getBoolean("is_account_non_locked"));
						user.setCredentialsNonExpired(rs.getBoolean("is_credentials_non_expired"));
						user.setEnabled(rs.getBoolean("is_enabled"));
//						user.setAuthorities(Collections
//								.singleton((ApplicationUserRole) rs.getArray("name")));
						return user;
					}
				},
				new Object[]{username});

		Set<GrantedAuthority> authorities = new HashSet<>();
		jdbcTemplate.query(
				"""
						SELECT * FROM user_authorities AS uA
						JOIN authorities AS a ON uA.authority_id = a.id
						WHERE a.name = ?;
						""",
				new RowMapper<Set<GrantedAuthority>>() {
					@Override
					public Set<GrantedAuthority> mapRow(@NonNull ResultSet rs, int rowNum) throws SQLException{
						authorities.add(new SimpleGrantedAuthority(rs.getString("name")));
						return authorities;
					}
				},
				new Object[]{authorities}
		);

		if (users.isEmpty()){
			throw new UsernameNotFoundException("User not found");
		}
		return new ApplicationUserEntity();
	}
}
