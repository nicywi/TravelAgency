package com.travelagency.nastokpl.service;

import com.travelagency.nastokpl.entity.Purchase;
import com.travelagency.nastokpl.entity.Trip;
import com.travelagency.nastokpl.repository.PurchaseRepository;
import com.travelagency.nastokpl.repository.TripRepository;
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
    private TripRepository tripRepository;

    private PurchaseRepository purchaseRepository;

    public void confirmPurchase(Long tripId, Integer adultCount, Integer childCount) {
        Trip trip = tripRepository.findById(tripId)
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
        Purchase purchase = new Purchase();
        purchase.setTrip(trip);
        purchase.setAdultCount(adultCount);
        purchase.setChildCount(childCount);
        purchase.setTotalAmount(totalPrice);
        purchase.setDate(LocalDate.now());
        purchaseRepository.save(purchase);
    }

    public List<Purchase> getAllPurchasedTrips() {
        return purchaseRepository.findAll();
    }
}
