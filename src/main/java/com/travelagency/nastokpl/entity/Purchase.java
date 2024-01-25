package com.travelagency.nastokpl.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "purchases")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Purchase {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;

	@Column(name = "adult_count")
	private Integer adultCount;

	@Column(name = "child_count")
	private Integer childCount;

	@Column(name = "total_amount")
	@Digits(integer = 8, fraction = 2)
	private BigDecimal totalAmount;

	@OneToOne
	@JoinColumn(name = "trip_id")
	private Trip trip;
}
