package com.travelagency.nastokpl.controllers;

import com.travelagency.nastokpl.models.PurchaseEntity;
import com.travelagency.nastokpl.models.TripEntity;
import com.travelagency.nastokpl.service.PurchaseService;
import com.travelagency.nastokpl.service.TripService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Controller
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
        final Optional<TripEntity> trip = tripService.getTripById(tripId);
        model.addAttribute("trip", trip);
        model.addAttribute("purchase", new PurchaseEntity());
        return "purchase-form";
    }

//    @PostMapping("/confirm")
//    public String confirmPurchase(@RequestParam("tripId") Long tripId,
//                                  @RequestParam("adultCount") Integer adultCount,
//                                  @RequestParam("childCount") Integer childCount,
//                                  Model model) {
//        Optional<TripEntity> optionalTrip = tripService.getTripById(tripId);
//
//        if (optionalTrip.isPresent()) {
//            TripEntity trip = optionalTrip.get();
//
//            // Calculate total price based on number of adults and children
//            BigDecimal totalPrice = trip.getPriceAdult().multiply(BigDecimal.valueOf(adultCount))
//                    .add(trip.getPriceChild().multiply(BigDecimal.valueOf(childCount)));
//
//            // Confirm the purchase
//            purchaseService.confirmPurchase(tripId, adultCount, childCount);
//
//            // Pass data to the view
//            model.addAttribute("trip", trip);
//            model.addAttribute("adultCount", adultCount);
//            model.addAttribute("childCount", childCount);
//            model.addAttribute("totalPrice", totalPrice);
//
//            return "redirect:/confirmation";
//        } else {
//            // Case where the trip with the specified ID does not exist
//            return "redirect:/error"; // Example: Redirect to an error page
//        }
//    }


    @GetMapping("/admin")
    public String showAdminPurchases(Model model) {
        List<PurchaseEntity> purchasedTrips = purchaseService.getAllPurchasedTrips();
        model.addAttribute("purchasedTrips", purchasedTrips);
        return "admin-purchases";
    }

    //Tests - working with restcontroller
//    @GetMapping(path = "/recently-purchased-trips")
//    public List<PurchaseEntity> getRecentlyPurchasedTrips() {
//        return purchaseService.getRecentlyPurchasedTrips();
//    }

//    @GetMapping(path = "/pur")
//    public List<PurchaseEntity> showAllPurchasedTrips() {
//        return purchaseService.getAllPurchasedTrips();
//    }

//    @GetMapping("/admin2")
//    public ResponseEntity<List<PurchaseEntity>> listPurchases() {
//        List<PurchaseEntity> purchases = purchaseService.getAllPurchasedTrips();
//        return new ResponseEntity<>(purchases, HttpStatus.OK);
//    }

}
