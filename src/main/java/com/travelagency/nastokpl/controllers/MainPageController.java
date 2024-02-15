package com.travelagency.nastokpl.controllers;

import com.travelagency.nastokpl.models.PurchaseEntity;
import com.travelagency.nastokpl.models.TripEntity;
import com.travelagency.nastokpl.service.MainPageService;
import com.travelagency.nastokpl.service.PurchaseService;
import com.travelagency.nastokpl.service.TripService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/home")
@Slf4j
@RequiredArgsConstructor
public class MainPageController {
    //A controller that operates the main page of the system, which will present
    // promoted tours, upcoming tours, and recently purchased tours.

    private final MainPageService mainPageService;

    private final PurchaseService purchaseService;

    @GetMapping
    public String showMainPage(Model model) {
        // Pobierz promowane wycieczki
        List<TripEntity> promotedTrips = mainPageService.getPromotedTrips();

        // Pobierz zbliżające się wycieczki
        List<TripEntity> upcomingTrips = mainPageService.getUpcomingTrips();

        // Pobierz ostatnio zakupione wycieczki
        List<PurchaseEntity> recentlyPurchasedTrips = purchaseService.getRecentlyPurchasedTrips();

        // Przekaż dane do widoku
        model.addAttribute("promotedTrips", promotedTrips);
        model.addAttribute("upcomingTrips", upcomingTrips);
        model.addAttribute("recentlyPurchasedTrips", recentlyPurchasedTrips);

        return "mainpage";
    }

    //Test methods
//    @GetMapping("/test")
//    public String showPromotedTrip(Model model) {
//        TripEntity promotedTrip = new TripEntity(LocalDate.of(2024, 3, 1), LocalDate.of(2024, 3, 18), 3, "HB", new BigDecimal("500.00"), new BigDecimal("200.00"), true, 30, 15);
//        model.addAttribute("tac", promotedTrip);
//        return "mainpage";
//    }
    //TEST each method, trzeba zmienic na RestController
//    @GetMapping(path = "/promoted-trips")
//    public List<TripEntity> getPromotedTrips() {
//        return mainPageService.getPromotedTrips();
//    }
//
//    @GetMapping(path = "/upcoming-trips")
//    public List<TripEntity> getUpcomingTrips() {
//        return mainPageService.getUpcomingTrips();
//    }
//
//    @GetMapping(path = "/recently-purchased-trips")
//    public List<PurchaseEntity> getRecentlyPurchasedTrips() {
//        return mainPageService.getRecentlyPurchasedTrips();
//    }
}