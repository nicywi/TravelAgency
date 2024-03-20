package com.travelagency.nastokpl.repositories;

import com.travelagency.nastokpl.models.CountryEntity;
import com.travelagency.nastokpl.models.TripEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
@ResponseBody
public interface TripRepository extends JpaRepository<TripEntity, Long>{
    //For MainPageController
    List<TripEntity> findTripsByStartDateAfter(LocalDate currentDate);

    List<TripEntity> findTripsByPromotedIsTrue();

    List<TripEntity> findTripsByStartDateBetween(LocalDate currentDate, LocalDate futureDate);

//    @Query("SELECT t FROM TripEntity t WHERE t.promoted = true AND t.destinationCityId.country = :country")
//    List<TripEntity> findPromotedTripsByCountry(CountryEntity country);
//
}
