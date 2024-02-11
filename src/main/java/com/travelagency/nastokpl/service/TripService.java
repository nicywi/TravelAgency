package com.travelagency.nastokpl.service;

import com.travelagency.nastokpl.entity.City;
import com.travelagency.nastokpl.entity.Trip;
import com.travelagency.nastokpl.repository.CityRepository;
import com.travelagency.nastokpl.repository.TripRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Slf4j
@Service
public class TripService {

    @Autowired
    private TripRepository tripRepository;

    public void addTrip(Trip trip) {
        tripRepository.save(trip);
    }

    public void deleteTripById(Long id) {
        if (tripRepository.existsById(id)) {
            tripRepository.deleteById(id);
        } else {
            throw new NoSuchElementException("Trip with ID " + id + " not found.");
        }
    }

    public void updateTrip(Trip trip) {
        if (tripRepository.existsById(trip.getId())) {
            tripRepository.save(trip);
        } else {
            throw new NoSuchElementException("Trip with ID " + trip.getId() + " not found.");
        }
    }

    public List<Trip> getAllTrips() {
        return tripRepository.findAll();
    }


    public Optional<Trip> getTripById(Long id) {
        return tripRepository.findById(id);
    }

}
