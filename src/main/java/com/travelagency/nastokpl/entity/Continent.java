package com.travelagency.nastokpl.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "continents")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Continent {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;

	@Column
	private String name;

	@OneToMany
	@JoinColumn
	private List<Country> country;
}
