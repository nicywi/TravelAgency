package com.travelagency.nastokpl.auth;

import com.travelagency.nastokpl.models.ApplicationUserEntity;
import jakarta.annotation.Nullable;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
@NoArgsConstructor(force = true)
public class JDBCUserDetailsService implements UserDetailsService {
	private final JdbcTemplate jdbcTemplate;

	public JDBCUserDetailsService(JdbcTemplate jdbcTemplate){
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	@Nullable
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		assert jdbcTemplate != null;
		List<ApplicationUserEntity> users = jdbcTemplate.query(
				"""
						SELECT * FROM user_authorities AS ua
						JOIN users AS u ON ua.user_id = u.id
						JOIN authorities AS a ON ua.authority_id = a.id
						WHERE usenrame = ?;
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
				if (users.isEmpty()){
			throw new UsernameNotFoundException("User not found");
		}
		return new ApplicationUser(users.get(0));
	}
}
