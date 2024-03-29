package com.travelagency.nastokpl.auth;

import com.travelagency.nastokpl.models.ApplicationUserEntity;

import java.util.Optional;

public interface ApplicationUserDAO {
	Optional<ApplicationUser> selectApplicationUserByUsername(String username);
}
