package com.travelagency.nastokpl.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "trips")
@Data
@NoArgsConstructor
@AllArgsConstructor
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

	@ManyToOne
	@JoinColumn(name = "departure_city_id")
	private City departureCityId;

	@ManyToOne
	@JoinColumn(name = "destination_city_id")
	private City destinationCityId;

	@OneToOne
	@JoinColumn(name = "trip_id")
	private Purchase purchase;
}
