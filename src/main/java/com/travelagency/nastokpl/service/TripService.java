package com.travelagency.nastokpl.service;

import com.travelagency.nastokpl.models.TripEntity;
import com.travelagency.nastokpl.repositories.CityRepository;
import com.travelagency.nastokpl.repositories.TripRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@Service
public class TripService {

    @Autowired
    private TripRepository tripRepository;

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

//    public void updateTrip(TripEntity trip) {
//        if (tripRepository.existsById(trip.getId())) {
//            tripRepository.save(trip);
//        } else {
//            throw new NoSuchElementException("Trip with ID " + trip.getId() + " not found.");
//        }
//    }

//    public void updateTrip(TripEntity trip) {
//        if (tripRepository.existsById(trip.getId())) {
//            TripEntity existingTrip = tripRepository.findById(trip.getId())
//                    .orElseThrow(() -> new NoSuchElementException("Trip with ID " + trip.getId() + " not found."));
//
//            // Merge changes from the detached entity to the managed entity
//            existingTrip.setStartDate(trip.getStartDate());
//            existingTrip.setEndDate(trip.getEndDate());
//            existingTrip.setDurationDays(trip.getDurationDays());
//            existingTrip.setMealType(trip.getMealType());
//            // Update other trip attributes as needed
//
//            tripRepository.save(existingTrip);
//        } else {
//            throw new NoSuchElementException("Trip with ID " + trip.getId() + " not found.");
//        }
//    }

    public void updateTrip(TripEntity trip) {
        Optional<TripEntity> existingTripOptional = tripRepository.findById(trip.getId());

        if (existingTripOptional.isPresent()) {
            TripEntity existingTrip = existingTripOptional.get();

            // Check if the start date has changed
            if (trip.getStartDate() != null && !Objects.equals(existingTrip.getStartDate(), trip.getStartDate())) {
                existingTrip.setStartDate(trip.getStartDate());
            }


            // Check if the end date has changed
            if (trip.getEndDate() != null && !Objects.equals(existingTrip.getEndDate(), trip.getEndDate())) {
                existingTrip.setEndDate(trip.getEndDate());
            }

            if (trip.getDurationDays() != null && !Objects.equals(existingTrip.getDurationDays(), trip.getDurationDays())) {
                existingTrip.setDurationDays(trip.getDurationDays());
            }

            if (trip.getMealType() != null && !trip.getMealType().isEmpty() && !Objects.equals(existingTrip.getMealType(), trip.getMealType())) {
                existingTrip.setMealType(trip.getMealType());
            }

            if (trip.getPriceAdult() != null && !Objects.equals(existingTrip.getPriceAdult(), trip.getPriceAdult())) {
                existingTrip.setPriceAdult(trip.getPriceAdult());
            }
            if (trip.getPriceChild() != null && !Objects.equals(existingTrip.getPriceChild(), trip.getPriceChild())) {
                existingTrip.setPriceChild(trip.getPriceChild());
            }
            if (trip.getPromoted() != null && !Objects.equals(existingTrip.getPromoted(), trip.getPromoted())) {
                existingTrip.setPromoted(trip.getPromoted());
            }
            if (trip.getAvailableAdultSeats() != null && !Objects.equals(existingTrip.getAvailableAdultSeats(), trip.getAvailableAdultSeats())) {
                existingTrip.setAvailableAdultSeats(trip.getAvailableAdultSeats());
            }
            if (trip.getAvailableChildSeats() != null && !Objects.equals(existingTrip.getAvailableChildSeats(), trip.getAvailableChildSeats())) {
                existingTrip.setAvailableChildSeats(trip.getAvailableChildSeats());
            }
//            if (trip.getDepartureCityId() != null && !Objects.equals(existingTrip.getDepartureCityId(), trip.getDepartureCityId())) {
//                existingTrip.setDepartureCityId(trip.getDepartureCityId());
//            }
            // Update other fields similarly

            // Save the trip if any changes were made
            tripRepository.save(existingTrip);
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
