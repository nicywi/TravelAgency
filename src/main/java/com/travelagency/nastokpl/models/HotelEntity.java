package com.travelagency.nastokpl.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.travelagency.nastokpl.dto.CityDTO;
import com.travelagency.nastokpl.dto.HotelDTO;
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
public class HotelEntity extends EntityMappedSuperclass {
	@Column
	private Integer stars;

	@Column(length = 1000)
	private String description;

	@ManyToOne
	@JoinColumn(name = "city_id")
	private CityEntity city;


	public HotelDTO toDTO(){
		CityDTO cityDTO = this.city != null ? this.city.toDTO() : null;
		return new HotelDTO(this.getId(), this.stars, this.description, cityDTO);
	}
	// code
}
