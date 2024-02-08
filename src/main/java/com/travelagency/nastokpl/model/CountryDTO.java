package com.travelagency.nastokpl.model;
import com.travelagency.nastokpl.entity.Country;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountryDTO {
    private Integer id;
    private String name;

    // Przykładowa metoda konwersji na encję (zakładając, że istnieje klasa Country)
    public Country toEntity() {
        Country country = new Country();
        country.setId(this.id);
        country.setName(this.name);
        return country;
    }
}
