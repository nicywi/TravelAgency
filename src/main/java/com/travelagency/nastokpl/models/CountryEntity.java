package com.travelagency.nastokpl.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.travelagency.nastokpl.dto.CountryDTO;
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
public final class CountryEntity extends EntityMappedSuperclass {
	@ManyToOne
	@JoinColumn(name = "continent_id")
	private ContinentEntity continent;

	@OneToMany(mappedBy = "country")
	private List<CityEntity> cities;

	public CountryDTO toDTO(){
		return new CountryDTO(this.getId(), this.getName());
	}
	// code
}
