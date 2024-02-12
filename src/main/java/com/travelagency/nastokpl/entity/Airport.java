package com.travelagency.nastokpl.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.travelagency.nastokpl.model.AirportDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "airports")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Airport extends EntityMappedSuperclass {
	@ManyToOne
	@JoinColumn(name = "city_id")
	private City city;

	// Konwersja z encji na DTO
	public AirportDTO toDTO() {
		return new AirportDTO(this.getId(), this.city != null ? this.city.toDTO() : null);
	}
}

