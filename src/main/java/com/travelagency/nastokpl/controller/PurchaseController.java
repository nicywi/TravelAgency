package com.travelagency.nastokpl.controller;

import com.travelagency.nastokpl.entity.Purchase;
import com.travelagency.nastokpl.entity.Trip;
import com.travelagency.nastokpl.service.PurchaseService;
import com.travelagency.nastokpl.service.TripService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/purchase")
@Slf4j
@RequiredArgsConstructor
public class PurchaseController {
    //Controller handling the trip purchase process. It will contain methods for
    // displaying the purchase form, processing user input, and completing the transaction.
    private final TripService tripService;

    private final PurchaseService purchaseService;

    @GetMapping("/form")
    public String showPurchaseForm(@RequestParam("tripId") Long tripId, Model model) {
        final Optional<Trip> trip = tripService.getTripById(tripId);
        model.addAttribute("trip", trip);
        model.addAttribute("purchase", new Purchase());
        return "purchase-form";
    }

    @PostMapping("/confirm")
    public String confirmPurchase(@RequestParam("tripId") Long tripId,
                                  @RequestParam("adultCount") Integer adultCount,
                                  @RequestParam("childCount") Integer childCount,
                                  Model model) {
        Optional<Trip> optionalTrip = tripService.getTripById(tripId);

        if (optionalTrip.isPresent()) {
            Trip trip = optionalTrip.get();

            // Calculate total price based on number of adults and children
            BigDecimal totalPrice = trip.getPriceAdult().multiply(BigDecimal.valueOf(adultCount))
                    .add(trip.getPriceChild().multiply(BigDecimal.valueOf(childCount)));

            // Confirm the purchase
            purchaseService.confirmPurchase(tripId, adultCount, childCount);

            // Pass data to the view
            model.addAttribute("trip", trip);
            model.addAttribute("adultCount", adultCount);
            model.addAttribute("childCount", childCount);
            model.addAttribute("totalPrice", totalPrice);

            return "redirect:/confirmation";
        } else {
            // Case where the trip with the specified ID does not exist
            return "redirect:/error"; // Example: Redirect to an error page
        }
    }


    @GetMapping("/admin")
    public String showAdminPurchases(Model model) {
        List<Purchase> purchasedTrips = purchaseService.getAllPurchasedTrips();
        model.addAttribute("purchasedTrips", purchasedTrips);
        return "admin-purchases";
    }

}
