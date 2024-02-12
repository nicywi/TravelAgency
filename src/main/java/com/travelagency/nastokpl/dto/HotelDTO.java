package com.travelagency.nastokpl.dto;

import com.travelagency.nastokpl.models.HotelEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HotelDTO {
	private Long id;
	private Integer stars;
	private String description;
	private CityDTO city;

	public HotelEntity toEntity(){
		HotelEntity hotel = new HotelEntity();
		hotel.setId(this.id);
		hotel.setStars(this.stars);
		hotel.setDescription(this.description);
		if (this.city != null){
			hotel.setCity(this.city.toEntity());
		}
		return hotel;
	}
}