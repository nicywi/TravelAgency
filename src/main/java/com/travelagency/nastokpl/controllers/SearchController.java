package com.travelagency.nastokpl.controllers;

import com.travelagency.nastokpl.service.TripService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/search")
@Slf4j
@RequiredArgsConstructor
public class SearchController {
//    A controller that supports searching for trips according to given criteria.

    private final TripService tripService;

//    @GetMapping
//    public String showSearchForm() {
//    // TODO: Logic to prepare data for the search form (e.g., dropdowns for cities, dates, etc.)
//        return "search"; //"search" is HTML name for the search form
//    }
//    @GetMapping("/search")
//    public ResponseEntity<List<Trip>> searchTrips(
//            @RequestParam(required = false) String availableAdultSeats,
//            @RequestParam(required = false) String priceAdult
//    ) {
//        List<Trip> trips = tripService.findTripsByCriteria(availableAdultSeats, priceAdult);
//        return new ResponseEntity<>(trips, HttpStatus.OK);
//    }
//    @PostMapping
//    public String searchTrips(@RequestParam("departureCity") String departureCity,
//                              @RequestParam("destinationCity") String destinationCity,
//                              @RequestParam("departureDate") String departureDate,
//                              @RequestParam("returnDate") String returnDate,
//                              Model model) {
//
//        List<Trip> foundTrips = tripService.findTripsByCriteria(departureCity, destinationCity, departureDate, returnDate);
//
//        model.addAttribute("foundTrips", foundTrips);
//
//        return "searchResults";
//    }

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

