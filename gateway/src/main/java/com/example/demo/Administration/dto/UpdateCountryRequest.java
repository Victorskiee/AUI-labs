package com.example.demo.Administration.dto;

import com.example.demo.Administration.entity.City;
import com.example.demo.Administration.entity.Country;
import lombok.*;

import java.util.function.BiFunction;

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
