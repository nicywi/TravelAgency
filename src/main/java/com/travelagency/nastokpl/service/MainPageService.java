package com.travelagency.nastokpl.service;

import com.travelagency.nastokpl.entity.Trip;
import com.travelagency.nastokpl.repository.TripRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

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

    public List<Trip> getRecentlyPurchasedTrips() {

        LocalDate currentDate = LocalDate.now();

        LocalDate startDate = currentDate.minusDays(7);

        return tripRepository.findTripsByPurchaseDateAfter(startDate);
    }
}
