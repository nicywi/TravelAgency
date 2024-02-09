package com.travelagency.nastokpl.repository;

import com.travelagency.nastokpl.entity.ApplicationUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationUserRepository extends JpaRepository<ApplicationUserEntity, Long> {
}
