package com.travelagency.nastokpl.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "cities")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class City extends EntityMappedSuperclass {
	@ManyToOne
	@JoinColumn(name = "country_id")
	private Country country;

	@OneToMany(mappedBy = "city")
	private List<Airport> airport;

	@OneToMany(mappedBy = "city")
	private List<Hotel> hotel;

	@OneToMany(mappedBy = "departureCityId")
	private List<Trip> departureCityId;

	@OneToMany(mappedBy = "destinationCityId")
	private List<Trip> destinationCityId;
}
