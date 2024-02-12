package com.travelagency.nastokpl.controllers;

import com.travelagency.nastokpl.models.TripEntity;
import com.travelagency.nastokpl.service.TripService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping
@Slf4j
@RequiredArgsConstructor
public class SearchController {
//    A controller that supports searching for trips according to given criteria.

    private final SearchService searchService;

    @GetMapping("/search")
    public ResponseEntity<List<TripEntity>> searchTrips(
            @RequestParam(required = false) Integer availableAdultSeats,
            @RequestParam(required = false) BigDecimal priceAdult,
            @RequestParam(required = false) LocalDate startDate,
            @RequestParam(required = false) LocalDate endDate,
            @RequestParam(required = false) Integer durationDays,
            @RequestParam(required = false) String mealType,
            @RequestParam(required = false) BigDecimal priceChild,
            @RequestParam(required = false) Boolean promoted,
            @RequestParam(required = false) Integer availableChildSeats,
            @RequestParam(required = false) CityEntity departureCityId,
            @RequestParam(required = false) CityEntity destinationCityId) {
        List<TripEntity> trips = searchService.findTripsByCriteria(availableAdultSeats, priceAdult, startDate, endDate,
                durationDays, mealType, priceChild, promoted, availableChildSeats, departureCityId, destinationCityId);
        return new ResponseEntity<>(trips, HttpStatus.OK);
    }

//    @PostMapping("/results")
//    public String searchTrips(@RequestParam(required = false) String departureCity,
//                              @RequestParam(required = false) String destinationCity,
//                              @RequestParam(required = false) String startDate,
//                              @RequestParam(required = false) String endDate,
//                              @RequestParam(required = false) String tripType,
//                              @RequestParam(required = false) Integer hotelStandard,
//                              @RequestParam(required = false) Integer numberOfDays,
//                              Model model) {
//        // Logic to search for trips based on the provided criteria
//        List<Trip> searchResults = tripService.searchTrips(departureCity, destinationCity, startDate, endDate,
//                tripType, hotelStandard, numberOfDays);
//        model.addAttribute("searchResults", searchResults);
//        return "search_results"; // "search_results" is a HTML name for displaying results
//    }
}

