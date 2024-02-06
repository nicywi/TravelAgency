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

    private CityRepository cityRepository;

//    public void addTrip(Trip trip) {
//        tripRepository.findById(trip.getId())
//                .ifPresent(t -> {
//                    throw new IllegalArgumentException("Can't add trip with the same id");
//                });
//        tripRepository.save(trip);
//    }

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

    public List<Trip> findTripsByCriteria(String departureCity, String destinationCity, String departureDate, String returnDate) {
        LocalDate startDate = LocalDate.parse(departureDate);
        LocalDate endDate = LocalDate.parse(returnDate);

        City depCity = cityRepository.findByName(departureCity);
        City destCity = cityRepository.findByName(destinationCity);

        return tripRepository.findTripsByDepartureCityIdAndDestinationCityIdAndStartDateGreaterThanEqualAndEndDateLessThanEqual(
                depCity, destCity, startDate, endDate
        );
    }

    public Optional<Trip> getTripById(Long id) {
        return tripRepository.findById(id);
    }
}
