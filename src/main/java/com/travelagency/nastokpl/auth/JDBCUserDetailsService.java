package com.travelagency.nastokpl.auth;

import com.travelagency.nastokpl.models.ApplicationUserEntity;
import com.travelagency.nastokpl.models.ApplicationUserRole;
import jakarta.annotation.Nullable;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
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
import java.util.stream.Collectors;

@Service
@NoArgsConstructor(force = true)
public class JDBCUserDetailsService implements UserDetailsService {
	private final JdbcTemplate jdbcTemplate;
	private final ApplicationUserDAO applicationUserDAO;
	private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public JDBCUserDetailsService(JdbcTemplate jdbcTemplate, ApplicationUserDAO applicationUserDAO,
								  NamedParameterJdbcTemplate namedParameterJdbcTemplate){
		this.jdbcTemplate = jdbcTemplate;
		this.applicationUserDAO = applicationUserDAO;
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
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

		Set<ApplicationUserRole> authorities = getAuthorities(users.stream().map(ApplicationUserEntity::getId).collect(Collectors.toSet()));
		users.forEach(u -> u.setAuthorities(authorities));

		if (users.isEmpty()){
			throw new UsernameNotFoundException("User not found");
		}
		return users.iterator().next();
	}

	private Set<ApplicationUserRole> getAuthorities(Set<Long> userIds) {
		Objects.requireNonNull(namedParameterJdbcTemplate);
		SqlParameterSource parameters = new MapSqlParameterSource("userIds", userIds);
        List<ApplicationUserRole> authorities = namedParameterJdbcTemplate.query(
				"SELECT name FROM authorities a JOIN user_authorities ua ON ua.authority_id = a.id AND ua.user_id IN (:userIds);",
				parameters,
				(rs, rowNum) -> new ApplicationUserRole().setRoleName(rs.getString("name"))

		);
		return new HashSet<>(authorities);
	}
}
