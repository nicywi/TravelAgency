package com.travelagency.nastokpl.service;

import com.travelagency.nastokpl.entity.Continent;
import com.travelagency.nastokpl.entity.Country;
import com.travelagency.nastokpl.entity.Trip;
import com.travelagency.nastokpl.repository.TripRepository;
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

    public List<Trip> getPromotedTrips() {
        return tripRepository.findTripsByPromotedIsTrue();
    }

    public List<Trip> getUpcomingTrips() {
        // Get current date
        LocalDate currentDate = LocalDate.now();

        // Retrieve upcoming trips from the repository
        return tripRepository.findTripsByStartDateAfter(currentDate);
    }

    public Map<Country, List<Trip>> getUpcomingTripsByCountry() {
        LocalDate currentDate = LocalDate.now();
        List<Trip> upcomingTrips = tripRepository.findTripsByStartDateAfter(currentDate);

        // Group upcoming trips by country <- for that need to add Country to Trip class?
//        Map<Country, List<Trip>> tripsByCountry = upcomingTrips.stream()
//                .collect(Collectors.groupingBy(Trip::getCountry));

//        return tripsByCountry;
        return null;
    }

    public Map<Continent, List<Trip>> getUpcomingTripsByContinent() {
        LocalDate currentDate = LocalDate.now();
        List<Trip> upcomingTrips = tripRepository.findTripsByStartDateAfter(currentDate);

        // Group upcoming trips by country <- for that need to add Continent to Trip class?
//        Map<Continent, List<Trip>> tripsByContinent= upcomingTrips.stream()
//                .collect(Collectors.groupingBy(Trip::getContinent));

//        return tripsByContinent;
        return null;
    }


    public List<Trip> getRecentlyPurchasedTrips() {

        LocalDate currentDate = LocalDate.now();

        LocalDate startDate = currentDate.minusDays(7);

        return tripRepository.findTripsByPurchaseDateAfter(startDate);
    }
}
