package com.travelagency.nastokpl.controllers.view;

import com.travelagency.nastokpl.models.CityEntity;
import com.travelagency.nastokpl.models.TripEntity;
import com.travelagency.nastokpl.service.SearchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/search")
@RequiredArgsConstructor
@Slf4j
public class SearchViewController {

    private final SearchService searchService;

    @GetMapping("/showForm")
    public String searchTrips(){
        return "search";
    }

    @PostMapping("/showResults")
    public String displaySearchResults(@RequestParam(required = false) Integer availableAdultSeats,
                                       @RequestParam(required = false) BigDecimal priceAdult,
                                       @RequestParam(required = false) LocalDate startDate,
                                       @RequestParam(required = false) LocalDate endDate,
                                       @RequestParam(required = false) Integer durationDays,
                                       @RequestParam(required = false) String mealType,
                                       @RequestParam(required = false) BigDecimal priceChild,
                                       @RequestParam(required = false) Boolean promoted,
                                       @RequestParam(required = false) Integer availableChildSeats,
                                       @RequestParam(required = false) CityEntity departureCityId,
                                       @RequestParam(required = false) CityEntity destinationCityId,
                                       Model model) {

        List<TripEntity> searchResults = searchService.findTripsByCriteria(availableAdultSeats, priceAdult, startDate, endDate,
                durationDays, mealType, priceChild, promoted, availableChildSeats, departureCityId, destinationCityId);

        model.addAttribute("searchResults", searchResults);
        return "search";
    }

}
