package com.travelagency.nastokpl.controllers.view;

import com.travelagency.nastokpl.models.PurchaseEntity;
import com.travelagency.nastokpl.models.TripEntity;
import com.travelagency.nastokpl.service.MainPageService;
import com.travelagency.nastokpl.service.PurchaseService;
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
public class MainPageViewController {
    //A controller that operates the main page of the system, which will present
    // promoted tours, upcoming tours, and recently purchased tours.

    private final MainPageService mainPageService;

    private final PurchaseService purchaseService;

    @GetMapping
    public String showMainPage(Model model) {
        try {
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
        } catch (Exception e) {
            log.error("Error occurred while fetching data for main page: {}", e.getMessage());
            return "error";
        }
        return "mainpage";
    }

}