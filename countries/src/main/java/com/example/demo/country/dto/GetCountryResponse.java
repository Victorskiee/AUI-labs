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
