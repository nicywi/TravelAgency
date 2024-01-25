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
public class City {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;

	@Column
	private String name;

	@ManyToOne
	@JoinColumn(name = "country_id")
	private Country country;

	@OneToMany
	@JoinColumn(name = "airport_id")
	private List<Airport> airport;

	@OneToMany
	@JoinColumn(name = "hotel_id")
	private List<Hotel> hotel;

	@OneToMany
	@JoinColumn
	private List<Trip> departureCityId;

	@OneToMany
	@JoinColumn
	private List<Trip> destinationCityId;
}
