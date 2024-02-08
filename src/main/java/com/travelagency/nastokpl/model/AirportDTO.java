package com.travelagency.nastokpl.model;

import com.travelagency.nastokpl.entity.Airport;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AirportDTO {
    private Integer id;
    private CityDTO city;

    public Airport toEntity() {
        Airport airport = new Airport();
        airport.setId(this.id);
        if (this.city != null) {
            airport.setCity(this.city.toEntity());
        }
        return airport;
    }
}
