package com.travelagency.nastokpl.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "trips")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Trip {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;

	@Column(name = "start_date")
	private LocalDate startDate;

	@Column(name = "end_date")
	private LocalDate endDate;

	@Column(name = "duration_days")
	private Integer durationDays;

	@Column(name = "meal_type", length = 10)
	private String mealType;

	@Column(name = "price_adult")
	@Digits(integer = 8, fraction = 2)
	private BigDecimal priceAdult;

	@Column(name = "price_child")
	@Digits(integer = 8, fraction = 2)
	private BigDecimal priceChild;

	@Column
	private Boolean promoted;

	@Column(name = "available_adult_seats")
	private Integer availableAdultSeats;

	@Column(name = "available_child_seats")
	private Integer availableChildSeats;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "departure_city_id")
	private City departureCityId;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "destination_city_id")
	private City destinationCityId;

	@OneToMany(mappedBy = "trip", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Purchase> purchase;
}
