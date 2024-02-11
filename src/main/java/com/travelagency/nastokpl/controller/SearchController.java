package com.travelagency.nastokpl.controller;

import com.travelagency.nastokpl.entity.City;
import com.travelagency.nastokpl.entity.Trip;
import com.travelagency.nastokpl.service.SearchService;
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

//    @GetMapping("/search")
//    public ResponseEntity<List<Trip>> searchTrips(
//            @RequestParam(required = false) Integer availableAdultSeats,
//            @RequestParam(required = false) BigDecimal priceAdult
//    ) {
//        List<Trip> trips = searchService.findTripsByCriteria(availableAdultSeats, priceAdult);
//        return new ResponseEntity<>(trips, HttpStatus.OK);
//    }

    @GetMapping("/search")
    public ResponseEntity<List<Trip>> searchTrips(
            @RequestParam(required = false) Integer availableAdultSeats,
            @RequestParam(required = false) BigDecimal priceAdult,
            @RequestParam(required = false) LocalDate startDate,
            @RequestParam(required = false) LocalDate endDate,
            @RequestParam(required = false) Integer durationDays,
            @RequestParam(required = false) String mealType,
            @RequestParam(required = false) BigDecimal priceChild,
            @RequestParam(required = false) Boolean promoted,
            @RequestParam(required = false) Integer availableChildSeats,
            @RequestParam(required = false) City departureCityId,
            @RequestParam(required = false) City destinationCityId) {
        List<Trip> trips = searchService.findTripsByCriteria(availableAdultSeats, priceAdult, startDate, endDate,
                durationDays, mealType, priceChild, promoted, availableChildSeats, departureCityId, destinationCityId);
        return new ResponseEntity<>(trips, HttpStatus.OK);
    }

}

