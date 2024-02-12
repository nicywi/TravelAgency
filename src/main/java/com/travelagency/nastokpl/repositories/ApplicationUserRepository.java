package com.travelagency.nastokpl.repositories;

import com.travelagency.nastokpl.models.ApplicationUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationUserRepository extends JpaRepository<ApplicationUserEntity, Long> {
}
