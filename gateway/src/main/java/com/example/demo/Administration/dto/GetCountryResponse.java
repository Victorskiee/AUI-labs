package com.example.demo.Administration.dto;

import com.example.demo.Administration.entity.City;
import com.example.demo.Administration.entity.Country;
import lombok.*;

import java.util.function.Function;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class GetCountryResponse {

    private String name;

    private int nrOfInhabitants;

    private double gdpChange;

    public static GetCountryResponse entityToDtoMapper(Country country) {
        return  GetCountryResponse.builder()
                .name(country.getName())
                .nrOfInhabitants(country.getNrOfInhabitants())
                .gdpChange(country.getGdpChange())
                .build();
    }
}
