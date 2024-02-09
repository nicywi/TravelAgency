package com.travelagency.nastokpl.auth;

import com.travelagency.nastokpl.entity.ApplicationUserEntity;

import java.util.Optional;

public interface ApplicationUserDAO {
	Optional<ApplicationUserEntity> selectApplicationUserByUsername (String username);
}
