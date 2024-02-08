package com.travelagency.nastokpl.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.travelagency.nastokpl.model.CountryDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "countries")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Country extends EntityMappedSuperclass {
	@ManyToOne
	@JoinColumn(name = "continent_id")
	private Continent continent;

	// Konwersja z encji na DTO
	public CountryDTO toDTO() {
		return new CountryDTO(this.getId(), this.getName());
	}

//	@OneToMany(mappedBy = "country")
//	private List<City> city;
}
