package com.travelagency.nastokpl.repositories;

import com.travelagency.nastokpl.models.AirportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

@Repository
@ResponseBody
public interface AirportRepository extends JpaRepository<AirportEntity, Long> {
	// code
}
