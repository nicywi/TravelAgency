package com.travelagency.nastokpl.model;

import com.travelagency.nastokpl.entity.Hotel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HotelDTO {
    private Integer id;
    private Integer stars;
    private String description;
    private CityDTO city;

    // Konwersja z DTO do encji
    public Hotel toEntity() {
        Hotel hotel = new Hotel();
        hotel.setId(this.id);
        hotel.setStars(this.stars);
        hotel.setDescription(this.description);
        if (this.city != null) {
            hotel.setCity(this.city.toEntity()); // Zakładając, że CityDTO ma metodę toEntity
        }
        return hotel;
    }
}