package com.travelagency.nastokpl.service;

import com.travelagency.nastokpl.models.PurchaseEntity;
import com.travelagency.nastokpl.models.TripEntity;
import com.travelagency.nastokpl.repositories.PurchaseRepository;
import com.travelagency.nastokpl.repositories.TripRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Slf4j
@Service
public class PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private TripRepository tripRepository;

    public void confirmPurchase(Long tripId, Integer adultCount, Integer childCount, PurchaseEntity purchase) {
        TripEntity trip = tripRepository.findById(tripId)
                .orElseThrow(() -> new IllegalArgumentException("Trip not found with ID: " + tripId));

        // Validate available seats
        if (trip.getAvailableAdultSeats() < adultCount || trip.getAvailableChildSeats() < childCount) {
            throw new IllegalStateException("Not enough available seats for this trip");
        }

        // Update available seats
        trip.setAvailableAdultSeats(trip.getAvailableAdultSeats() - adultCount);
        trip.setAvailableChildSeats(trip.getAvailableChildSeats() - childCount);
        tripRepository.save(trip);

        // Calculate total price
        BigDecimal totalPrice = trip.getPriceAdult().multiply(BigDecimal.valueOf(adultCount))
                .add(trip.getPriceChild().multiply(BigDecimal.valueOf(childCount)));

        // Create and save purchase entity
        purchase.setTrip(trip);
        purchase.setAdultCount(adultCount);
        purchase.setChildCount(childCount);
        purchase.setTotalAmount(totalPrice);
        purchase.setDate(LocalDate.now());
        purchaseRepository.save(purchase);
    }

    public List<PurchaseEntity> getAllPurchasedTrips() {
        return purchaseRepository.findAll();
    }

    public List<PurchaseEntity> getRecentlyPurchasedTrips() {
        LocalDate currentDate = LocalDate.now();
        LocalDate pastDate = currentDate.minusDays(30);
        return purchaseRepository.findPurchaseByDateBetween(pastDate, currentDate);
    }
}
