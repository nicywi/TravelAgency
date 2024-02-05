package com.travelagency.nastokpl.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

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
	private List<Airport> airport;

	@OneToMany(mappedBy = "city")
	private List<Hotel> hotel;

	@OneToMany(mappedBy = "departureCityId")
	private List<Trip> departureCityId;

	@OneToMany(mappedBy = "destinationCityId")
	private List<Trip> destinationCityId;
}
