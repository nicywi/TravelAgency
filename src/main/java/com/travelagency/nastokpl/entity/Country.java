package com.travelagency.nastokpl.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "countries")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Country extends EntityMappedSuperclass {
	@ManyToOne
	@JoinColumn(name = "continent_id")
	private Continent continent;

	@OneToMany(mappedBy = "country")
	private List<City> city;
}
