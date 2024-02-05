package com.travelagency.nastokpl.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Check;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

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
	@Check(constraints = "adult_count >= 0")
	private Integer adultCount;

	@Column(name = "child_count")
	@Check(constraints = "child_count >= 0")
	private Integer childCount;

	@Check(constraints = "adult_count + child_count > 0")

	@Column(name = "total_amount")
	@Digits(integer = 8, fraction = 2)
	private BigDecimal totalAmount;

	@Column(name = "purchase_date")
	private LocalDate purchaseDate;

	@ManyToOne
	@JoinColumn(name = "trip_id")
	private Trip trip;

	@OneToMany(mappedBy = "purchase", fetch = FetchType.LAZY)
	private List<Participant> participant;
}
