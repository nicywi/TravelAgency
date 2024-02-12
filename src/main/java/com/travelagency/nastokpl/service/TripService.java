package com.travelagency.nastokpl.service;

import com.travelagency.nastokpl.model.TripEntity;
import com.travelagency.nastokpl.repositories.CityRepository;
import com.travelagency.nastokpl.repositories.TripRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Slf4j
@Service
public class TripService {

    @Autowired
    private TripRepository tripRepository;

    private CityRepository cityRepository;

    public void addTrip(TripEntity trip) {
        tripRepository.save(trip);
    }

    public void deleteTripById(Long id) {
        if (tripRepository.existsById(id)) {
            tripRepository.deleteById(id);
        } else {
            throw new NoSuchElementException("Trip with ID " + id + " not found.");
        }
    }

    public void updateTrip(TripEntity trip) {
        if (tripRepository.existsById(trip.getId())) {
            tripRepository.save(trip);
        } else {
            throw new NoSuchElementException("Trip with ID " + trip.getId() + " not found.");
        }
    }

    public List<TripEntity> getAllTrips() {
        return tripRepository.findAll();
    }


    public Optional<TripEntity> getTripById(Long id) {
        return tripRepository.findById(id);
    }

}
