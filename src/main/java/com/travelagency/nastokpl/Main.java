package com.travelagency.nastokpl;


import com.travelagency.nastokpl.entity.*;
import com.travelagency.nastokpl.model.*;


public class Main {
    public static void main(String[] args) {
        // Tworzymy przykładowy kraj
        Country country = new Country();
        country.setId(1);
        country.setName("Polska");

        // Tworzymy przykładowe miasto
        City city = new City();
        city.setId(1);
        city.setCountry(country); // Przypisujemy kraj do miasta

        // Tworzymy przykładowe lotnisko
        Airport airport = new Airport();
        airport.setId(1);
        airport.setCity(city); // Przypisujemy miasto do lotniska

        // Konwersja do DTO
        CountryDTO countryDTO = country.toDTO();
        CityDTO cityDTO = city.toDTO();
        AirportDTO airportDTO = airport.toDTO();

        // Wyświetlamy wyniki na konsoli
        System.out.println("CountryDTO: " + countryDTO);
        System.out.println("CityDTO: " + cityDTO);
        System.out.println("AirportDTO: " + airportDTO);
    }
}
