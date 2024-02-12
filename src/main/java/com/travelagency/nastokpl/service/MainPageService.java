package com.travelagency.nastokpl.service;

import com.travelagency.nastokpl.models.ContinentEntity;
import com.travelagency.nastokpl.models.CountryEntity;
import com.travelagency.nastokpl.models.TripEntity;
import com.travelagency.nastokpl.repositories.TripRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Service
public class MainPageService {

    @Autowired
    private TripRepository tripRepository;

    public List<TripEntity> getPromotedTrips() {
        return tripRepository.findTripsByPromotedIsTrue();
    }

    public List<TripEntity> getUpcomingTrips() {
        // Get current date
        LocalDate currentDate = LocalDate.now();

        // Retrieve upcoming trips from the repository
        return tripRepository.findTripsByStartDateAfter(currentDate);
    }

    public Map<CountryEntity, List<TripEntity>> getUpcomingTripsByCountry() {
        LocalDate currentDate = LocalDate.now();
        List<TripEntity> upcomingTrips = tripRepository.findTripsByStartDateAfter(currentDate);

        // Group upcoming trips by country <- for that need to add Country to Trip class?
//        Map<Country, List<Trip>> tripsByCountry = upcomingTrips.stream()
//                .collect(Collectors.groupingBy(Trip::getCountry));

//        return tripsByCountry;
        return null;
    }

    public Map<ContinentEntity, List<TripEntity>> getUpcomingTripsByContinent() {
        LocalDate currentDate = LocalDate.now();
        List<TripEntity> upcomingTrips = tripRepository.findTripsByStartDateAfter(currentDate);

        // Group upcoming trips by country <- for that need to add Continent to Trip class?
//        Map<Continent, List<Trip>> tripsByContinent= upcomingTrips.stream()
//                .collect(Collectors.groupingBy(Trip::getContinent));

//        return tripsByContinent;
        return null;
    }


    public List<TripEntity> getRecentlyPurchasedTrips() {

        LocalDate currentDate = LocalDate.now();

        LocalDate startDate = currentDate.minusDays(7);

        return tripRepository.findTripsByPurchaseDateAfter(startDate);
    }
}
