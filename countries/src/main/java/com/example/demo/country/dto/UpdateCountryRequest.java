package com.example.demo.country.dto;

import com.example.demo.country.entity.Country;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class UpdateCountryRequest {

    private int nrOfInhabitants;

    private double gdpChange;

    public static void dtoToEntityUpdater(Country country, UpdateCountryRequest request){
        country.setNrOfInhabitants(request.getNrOfInhabitants());
        country.setGdpChange(request.getGdpChange());
    }
}
