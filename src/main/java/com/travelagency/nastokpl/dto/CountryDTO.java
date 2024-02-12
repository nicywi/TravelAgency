package com.travelagency.nastokpl.dto;

import com.travelagency.nastokpl.models.CountryEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountryDTO {
	private Long id;
	private String name;

	public CountryEntity toEntity(){
		CountryEntity country = new CountryEntity();
		country.setId(this.id);
		country.setName(this.name);
		return country;
	}
	// code
}
