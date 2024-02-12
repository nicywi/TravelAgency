package com.travelagency.nastokpl.dto;

import com.travelagency.nastokpl.model.AirportEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AirportDTO {
	private Long id;
	private CityDTO city;

	public AirportEntity toEntity(){
		AirportEntity airport = new AirportEntity();
		airport.setId(this.id);
		if (this.city != null){
			airport.setCity(this.city.toEntity());
		}
		return airport;
	}
}
