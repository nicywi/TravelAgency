package com.travelagency.nastokpl.controller;

import com.travelagency.nastokpl.entity.Trip;
import com.travelagency.nastokpl.service.TripService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
@RestController
@RequestMapping("/search")
@Slf4j
@RequiredArgsConstructor
public class SearchController {
//    A controller that supports searching for trips according to given criteria.

    private final TripService tripService;

    @GetMapping
    public String showSearchForm() {
    // TODO: Logic to prepare data for the search form (e.g., dropdowns for cities, dates, etc.)
        return "search"; //"search" is HTML name for the search form
    }

    @GetMapping("/results")
    //mieście (Lotnisku) wylotu
    //mieście (Hotelu) pobytu
    public ResponseEntity<List<Trip>> searchTrips(@RequestParam(required = false) String departureCity,
                                                  @RequestParam(required = false) String destinationCity,
                                                  @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate minStartDate,
                                                  @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate maxStartDate,
                                                  @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate minEndDate,
                                                  @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate maxEndDate,
                                                  @RequestParam(required = false) String mealType,
                                                  @RequestParam(required = false) String hotelStandard,
                                                  @RequestParam(required = false) Integer minDurationDays,
                                                  @RequestParam(required = false) Integer maxDurationDays) {
        List<Trip> searchResults = tripService.searchTrips(departureCity, destinationCity, minStartDate, maxStartDate,
                minEndDate, maxEndDate, mealType, hotelStandard, minDurationDays, maxDurationDays);
        return ResponseEntity.ok(searchResults);
    }
}

