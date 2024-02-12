package com.travelagency.nastokpl.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.travelagency.nastokpl.dto.AirportDTO;
import com.travelagency.nastokpl.dto.CityDTO;
import com.travelagency.nastokpl.dto.CountryDTO;
import com.travelagency.nastokpl.dto.HotelDTO;
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
public class CityEntity extends EntityMappedSuperclass {
	@ManyToOne
	@JoinColumn(name = "country_id")
	private CountryEntity country;

	@OneToMany(mappedBy = "city")
	private List<AirportEntity> airports;

	//It is optional in some cases - when departuring from a city, we dont need hotel
	@OneToMany(mappedBy = "city")
	private List<HotelEntity> hotels;

	@OneToMany(mappedBy = "departureCityId")
	private List<TripEntity> departureCityId;

	@OneToMany(mappedBy = "destinationCityId")
	private List<TripEntity> destinationCityId;

	public CityDTO toDTO(){
		List<AirportDTO> airportDTOs = this.airports != null ? this.airports.stream().map(AirportEntity::toDTO).collect(Collectors.toList()) : null;
		List<HotelDTO> hotelDTOs = this.hotels != null ? this.hotels.stream().map(HotelEntity::toDTO).collect(Collectors.toList()) : null;
		CountryDTO countryDTO = this.country != null ? this.country.toDTO() : null;
		return new CityDTO(this.getId(), countryDTO, airportDTOs, hotelDTOs);
	}
}
