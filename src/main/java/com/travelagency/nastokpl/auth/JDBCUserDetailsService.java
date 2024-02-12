package com.travelagency.nastokpl.auth;

import com.travelagency.nastokpl.model.ApplicationUserEntity;
import com.travelagency.nastokpl.model.Authority;
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
public class JDBCUserDetailsService implements UserDetailsService {
	private final JdbcTemplate jdbcTemplate;

	public JDBCUserDetailsService(JdbcTemplate jdbcTemplate){
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		List<ApplicationUserEntity> users = jdbcTemplate.query(
				"SELECT * FROM users WHERE username = ?",
				new Object[]{username},
				new RowMapper<ApplicationUserEntity>() {
					@Override
					public ApplicationUserEntity mapRow(ResultSet rs, int rowNum) throws SQLException{
						ApplicationUserEntity user = new ApplicationUserEntity();
						user.setId(rs.getLong("id"));
						user.setUsername(rs.getString("username"));
						user.setPassword(rs.getString("password"));
						user.setAccountNonExpired(rs.getBoolean("is_account_mon_expired"));
						user.setAccountNonLocked(rs.getBoolean("is_account_non_locked"));
						user.setCredentialsNonExpired(rs.getBoolean("is_credentials_non_expired"));
						user.setEnabled(rs.getBoolean("is_enabled"));
						user.setAuthorities(Authority.valueOf(rs.getString("authorities")));
						return user;
					}
				});
		if (users.isEmpty()){
			throw new UsernameNotFoundException("User not found");
		}
		return new ApplicationUser(users.get(0));
	}
}
