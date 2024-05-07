package com.travelagency.nastokpl.repositories;

import com.travelagency.nastokpl.models.PurchaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.util.List;

@Repository
@ResponseBody
public interface PurchaseRepository extends JpaRepository<PurchaseEntity, Long> {
    List<PurchaseEntity> findPurchaseByDateBetween(LocalDate pastDate, LocalDate currentDate);
    List<PurchaseEntity> findPurchaseByDateAfter(LocalDate startDate);
}
