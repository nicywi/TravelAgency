package com.travelagency.nastokpl.controllers.view;

import com.travelagency.nastokpl.models.PurchaseEntity;
import com.travelagency.nastokpl.models.TripEntity;
import com.travelagency.nastokpl.service.PurchaseService;
import com.travelagency.nastokpl.service.TripService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Controller
@RequestMapping("/purchase")
@Slf4j
@RequiredArgsConstructor
public class PurchaseViewController {
    //Controller handling the trip purchase process. It will contain methods for
    // displaying the purchase form, processing user input, and completing the transaction.
    private final TripService tripService;

    private final PurchaseService purchaseService;

    @GetMapping
    public String showPurchaseForm(@RequestParam Long id, Model model) {
        final Optional<TripEntity> trip = tripService.getTripById(id);
        TripEntity actualTrip = trip.orElseThrow(() -> new NoSuchElementException("Trip not found"));

        PurchaseEntity newPurchase = new PurchaseEntity();
        newPurchase.setTrip(actualTrip);

        model.addAttribute("trip", actualTrip);
        model.addAttribute("newPurchase", newPurchase);

        return "purchase-form";
    }

    @PostMapping
    public String confirmPurchase(@ModelAttribute("newPurchase") final PurchaseEntity purchase,
                                  final ModelMap modelMap) {

        // Confirm the purchase
        purchaseService.confirmPurchase(purchase.getTrip().getId(), purchase.getAdultCount(), purchase.getChildCount(), purchase);

        // Pass data to the view
        modelMap.addAttribute("purchaseInfo", purchase);

        return "confirmation";
    }


    @GetMapping("/admin")
    public String showAdminPurchases(Model model) {
        List<PurchaseEntity> purchasedTrips = purchaseService.getAllPurchasedTrips();
        BigDecimal totalSum = purchaseService.getTotalSumOfPurchases();
        model.addAttribute("purchasedTrips", purchasedTrips);
        model.addAttribute("totalSum", totalSum);
        return "admin-purchases";
    }

}
