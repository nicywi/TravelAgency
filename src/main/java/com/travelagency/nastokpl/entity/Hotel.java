package com.travelagency.nastokpl.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "hotels")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hotel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;

	@Column
	private String name;

	@Column
	private Integer stars;

	@Column(length = 1000)
	private String description;

	@ManyToOne
	@JoinColumn(name = "city_id")
	private City city;
}
