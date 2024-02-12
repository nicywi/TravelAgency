package com.travelagency.nastokpl.repositories;

import com.travelagency.nastokpl.models.PurchaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

@Repository
@ResponseBody
public interface PurchaseRepository extends JpaRepository<PurchaseEntity, Long> {
}
