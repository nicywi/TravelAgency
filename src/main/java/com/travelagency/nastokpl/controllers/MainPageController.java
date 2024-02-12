package com.travelagency.nastokpl.controllers;


import com.travelagency.nastokpl.models.TripEntity;
import com.travelagency.nastokpl.service.MainPageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/home")
@Slf4j
@RequiredArgsConstructor
public class MainPageController {
    //A controller that operates the main page of the system, which will present
    // promoted tours, upcoming tours, and recently purchased tours.

    private final MainPageService mainPageService;

    @GetMapping("/main")
    public String showMainPage(Model model) {
        // Pobierz promowane wycieczki
        List<TripEntity> promotedTrips = mainPageService.getPromotedTrips();

        // Pobierz zbliżające się wycieczki
        List<TripEntity> upcomingTrips = mainPageService.getUpcomingTrips();

        // Pobierz ostatnio zakupione wycieczki
        List<TripEntity> recentlyPurchasedTrips = mainPageService.getRecentlyPurchasedTrips();

        // Przekaż dane do widoku
        model.addAttribute("promotedTrips", promotedTrips);
        model.addAttribute("upcomingTrips", upcomingTrips);
        model.addAttribute("recentlyPurchasedTrips", recentlyPurchasedTrips);

        return "mainpage";
    }

    //TEST each method

    @GetMapping(path = "/promoted-trips")
    public List<TripEntity> getPromotedTrips() {
        return mainPageService.getPromotedTrips();
    }

    @GetMapping(path = "/upcoming-trips")
    public List<TripEntity> getUpcomingTrips() {
        return mainPageService.getUpcomingTrips();
    }

    @GetMapping(path = "/recently-purchased-trips")
    public List<TripEntity> getRecentlyPurchasedTrips() {
        return mainPageService.getRecentlyPurchasedTrips();
    }
}