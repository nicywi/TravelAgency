package com.travelagency.nastokpl.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.travelagency.nastokpl.model.CityDTO;
import com.travelagency.nastokpl.model.HotelDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "hotels")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Hotel extends EntityMappedSuperclass {
	@Column
	private Integer stars;

	@Column(length = 1000)
	private String description;

	@ManyToOne
	@JoinColumn(name = "city_id")
	private City city;

	// Konwersja z encji na DTO
	public HotelDTO toDTO() {
		CityDTO cityDTO = this.city != null ? this.city.toDTO() : null; // Zakładając, że City ma metodę toDTO
		return new HotelDTO(this.getId(), this.stars, this.description, cityDTO);
	}
}
