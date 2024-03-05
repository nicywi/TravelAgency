package com.travelagency.nastokpl.controllers.view;

import com.travelagency.nastokpl.models.TripEntity;
import com.travelagency.nastokpl.service.TripService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Controller
@RequestMapping("/trips")
@Slf4j
@RequiredArgsConstructor
public class TripViewController {
    //    Controller responsible for configuring the tour offer by the administrator.
//    It will contain actions for viewing, adding, editing and deleting trips.
    private final TripService tripService;

    @GetMapping
    public String listTrips(Model model) {
        List<TripEntity> trips = tripService.getAllTrips();
        model.addAttribute("allTrips", trips);
        return "trips";
    }

    @GetMapping("/tripForm")
    public String showAddTripForm(Model model) {
        model.addAttribute("trip", new TripEntity());
        return "trip-form";
    }

    @PostMapping(path = "/addTrip")
    public String addTrip(@Validated @ModelAttribute("trip") TripEntity trip) {
        tripService.addTrip(trip);
        return "redirect:/trips";
    }

    @PostMapping("/delete")
    public String deleteTrip(@RequestParam("id") Long id) {
        tripService.deleteTripById(id);
        return "redirect:/trips";
    }

    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        final Optional<TripEntity> trip = tripService.getTripById(id);
        TripEntity actualTrip = trip.orElseThrow(() -> new NoSuchElementException("Trip not found"));
        model.addAttribute("oldTrip", actualTrip);
        return "update-trip-form";
    }

    @PostMapping("/updateTrip/{id}")
    public String updateUser(@PathVariable("id") long id, @Valid  TripEntity trip,
                             BindingResult result) {
        if (result.hasErrors()) {
            trip.setId(id);
            return "update-trip-form";
        }

        tripService.updateTrip(trip);
        return "redirect:/trips";
    }

}
