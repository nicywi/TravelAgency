package com.travelagency.nastokpl.repositories;

import com.travelagency.nastokpl.model.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

@Repository
@ResponseBody
public interface CityRepository extends JpaRepository<CityEntity, Long> {
	CityEntity findByName(String city);
}
