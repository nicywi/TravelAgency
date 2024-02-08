package com.travelagency.nastokpl.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.travelagency.nastokpl.model.AirportDTO;
import com.travelagency.nastokpl.model.CityDTO;
import com.travelagency.nastokpl.model.CountryDTO;
import com.travelagency.nastokpl.model.HotelDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "cities")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class City extends EntityMappedSuperclass {
	@ManyToOne
	@JoinColumn(name = "country_id")
	private Country country;

	@OneToMany(mappedBy = "city")
	private List<Airport> airport; // zmień ma liczbę mnogą wszędzie tam gdzie masz zbiory, kolekcje elementów

	//It is optional in some cases - when departuring from a city, we dont need hotel
	@OneToMany(mappedBy = "city")
	private List<Hotel> hotel;

	// Konwersja z encji na DTO
	public CityDTO toDTO() {
		List<AirportDTO> airportDTOs = this.airport != null ? this.airport.stream().map(Airport::toDTO).collect(Collectors.toList()) : null;
		List<HotelDTO> hotelDTOs = this.hotel != null ? this.hotel.stream().map(Hotel::toDTO).collect(Collectors.toList()) : null;
		CountryDTO countryDTO = this.country != null ? this.country.toDTO() : null;
		return new CityDTO(this.getId(), countryDTO, airportDTOs, hotelDTOs);
	}

//	@OneToMany(mappedBy = "departureCityId")
//	private List<Trip> departureCityId;
//
//	@OneToMany(mappedBy = "destinationCityId")
//	private List<Trip> destinationCityId;
}
