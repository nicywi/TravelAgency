package com.travelagency.nastokpl.auth;

import com.travelagency.nastokpl.models.ApplicationUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ApplicationUserDAO extends JpaRepository<ApplicationUserEntity, Long> {
    Optional<ApplicationUserEntity> getByUsername(String username);
}
