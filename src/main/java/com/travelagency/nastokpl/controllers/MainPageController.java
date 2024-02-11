package com.travelagency.nastokpl.controller;

import com.travelagency.nastokpl.entity.Trip;
import com.travelagency.nastokpl.service.MainPageService;
import com.travelagency.nastokpl.service.SearchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
@Slf4j
@RequiredArgsConstructor
public class MainPageController {
    //A controller that operates the main page of the system, which will present
    // promoted tours, upcoming tours, and recently purchased tours.

    private final MainPageService mainPageService;

    @GetMapping("/main")
    public String showMainPage(Model model) {
        // Pobierz promowane wycieczki
        List<Trip> promotedTrips = mainPageService.getPromotedTrips();

        // Pobierz zbliżające się wycieczki
        List<Trip> upcomingTrips = mainPageService.getUpcomingTrips();

        // Pobierz ostatnio zakupione wycieczki
        List<Trip> recentlyPurchasedTrips = mainPageService.getRecentlyPurchasedTrips();

        // Przekaż dane do widoku
        model.addAttribute("promotedTrips", promotedTrips);
        model.addAttribute("upcomingTrips", upcomingTrips);
        model.addAttribute("recentlyPurchasedTrips", recentlyPurchasedTrips);

        return "mainpage";
    }

    //TEST each method

    @GetMapping(path = "/promoted-trips")
    public List<Trip> getPromotedTrips() {
        return mainPageService.getPromotedTrips();
    }

    @GetMapping(path = "/upcoming-trips")
    public List<Trip> getUpcomingTrips() {
        return mainPageService.getUpcomingTrips();
    }

    @GetMapping(path = "/recently-purchased-trips")
    public List<Trip> getRecentlyPurchasedTrips() {
        return mainPageService.getRecentlyPurchasedTrips();
    }

}
