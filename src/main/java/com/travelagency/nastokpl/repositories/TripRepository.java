package com.travelagency.nastokpl.repositories;

import com.travelagency.nastokpl.models.TripEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
@ResponseBody
public interface TripRepository extends JpaRepository<TripEntity, Long>{

    //For SearchController

//    List<Trip> findByAvailableAdultSeatsAndPriceAdult(Integer availableAdultSeats, BigDecimal priceAdult);
//
//    List<Trip> findByAvailableAdultSeats(Integer availableAdultSeats);
//
//    List<Trip> findByPriceAdult(BigDecimal priceAdult);

    //For MainPageController
    List<Trip> findTripsByStartDateAfter(LocalDate currentDate);

    List<Trip> findTripsByPurchaseDateAfter(LocalDate startDate);


    List<Trip> findTripsByPromotedIsTrue();
}
