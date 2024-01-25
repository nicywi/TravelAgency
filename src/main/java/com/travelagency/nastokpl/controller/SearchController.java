package com.travelagency.nastokpl.controller;

import com.travelagency.nastokpl.entity.Trip;
import com.travelagency.nastokpl.service.TripService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        return "search";
    }

    @PostMapping
    public String searchTrips(@RequestParam("departureCity") String departureCity,
                              @RequestParam("destinationCity") String destinationCity,
                              @RequestParam("departureDate") String departureDate,
                              @RequestParam("returnDate") String returnDate,
                              Model model) {

        List<Trip> foundTrips = tripService.findTripsByCriteria(departureCity, destinationCity, departureDate, returnDate);

        model.addAttribute("foundTrips", foundTrips);

        return "searchResults";
    }
}

