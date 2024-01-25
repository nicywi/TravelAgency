package com.travelagency.nastokpl.controller;

import com.travelagency.nastokpl.entity.Trip;
import com.travelagency.nastokpl.service.TripService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.NoSuchElementException;


@RestController
@RequestMapping("/trips")
@Slf4j
@RequiredArgsConstructor
public class TripController {

//    Controller responsible for configuring the tour offer by the administrator.
//    It will contain actions for viewing, adding, editing and deleting trips.

    private final TripService tripService;

    @PostMapping("/add")
    public ResponseEntity<String> addTrip(@ModelAttribute("trip") Trip trip) {
        tripService.addTrip(trip);
        return new ResponseEntity<>("Trip added successfully", HttpStatus.CREATED);
    }

    @PutMapping("/edit")
    @ResponseBody
    public ResponseEntity<String> updateTrip(@ModelAttribute("trip") Trip trip) {
        tripService.updateTrip(trip);
        return new ResponseEntity<>("Trip updated successfully", HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    @ResponseBody
    public ResponseEntity<String> deleteTrip(@PathVariable Long id) {
        try {
            tripService.deleteTrip(id);
            return ResponseEntity.ok("Trip with ID " + id + " deleted successfully.");
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while deleting trip with ID " + id);
        }
    }

    @GetMapping("/list")
    public ResponseEntity<List<Trip>> listTrips() {
        List<Trip> trips = tripService.getAllTrips();
        return new ResponseEntity<>(trips, HttpStatus.OK);
    }
}
