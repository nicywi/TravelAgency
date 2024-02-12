package com.travelagency.nastokpl.dto;

import com.travelagency.nastokpl.model.*;
//import com.travelagency.nastokpl.entity.City;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CityDTO {
    private Long id;
    private CountryDTO country;
    private List<AirportDTO> airports;
    private List<HotelDTO> hotels;

    public CityEntity toEntity() {
        CityEntity city = new CityEntity();
        city.setId(this.id);

        if (this.country != null) {
            city.setCountry(this.country.toEntity());
        }

        if (this.airports != null) {
            List<AirportEntity> airportEntities = this.airports.stream()
                    .map(AirportDTO::toEntity)
                    .collect(Collectors.toList());
            airportEntities.forEach(airport -> airport.setCity(city)); // Ustawienie powrotnego odniesienia do miasta
            city.setAirports(airportEntities);
        }

        if (this.hotels != null) {
            List<HotelEntity> hotelEntities = this.hotels.stream()
                    .map(HotelDTO::toEntity)
                    .collect(Collectors.toList());
            hotelEntities.forEach(hotel -> hotel.setCity(city)); // Ustawienie powrotnego odniesienia do miasta
            city.setHotels(hotelEntities);
        }

        return city;
    }
}
