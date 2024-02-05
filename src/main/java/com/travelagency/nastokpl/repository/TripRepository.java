package com.travelagency.nastokpl.repository;

import com.travelagency.nastokpl.entity.City;
import com.travelagency.nastokpl.entity.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.util.List;

@Repository
@ResponseBody
public interface TripRepository extends JpaRepository<Trip, Long> {


	List<Trip> findTripsByDepartureCityIdAndDestinationCityIdAndStartDateGreaterThanEqualAndEndDateLessThanEqual(
			City departureCityId,
			City destinationCityId,
			LocalDate startDate,
			LocalDate endDate
	);

	List<Trip> findByCriteria(String departureCity, String destinationCity, LocalDate minStartDate, LocalDate maxStartDate,
							  LocalDate minEndDate, LocalDate maxEndDate, String mealType, String hotelStandard,
							  Integer minDurationDays, Integer maxDurationDays, String sort, String order);
}
