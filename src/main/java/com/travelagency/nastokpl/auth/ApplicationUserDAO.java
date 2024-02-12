package com.travelagency.nastokpl.auth;

import com.travelagency.nastokpl.model.ApplicationUserEntity;

import java.util.Optional;

public interface ApplicationUserDAO {
	Optional<ApplicationUserEntity> selectApplicationUserByUsername(String username);
}
