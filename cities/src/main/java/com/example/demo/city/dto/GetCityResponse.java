package com.example.demo.city.dto;

import com.example.demo.city.entity.City;
import com.example.demo.country.entity.Country;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class GetCityResponse {

    private int id;

    private String name;

    private String country;

    private int nrOfStreets;

    public static GetCityResponse entityToDtoMapper(City city){
        String s = null;
        if(city.getCountry() != null){
            s = city.getCountry().getName();
        }
        return GetCityResponse.builder()
                .id(city.getId())
                .name(city.getName())
                .country(s)
                .nrOfStreets(city.getNrOfStreets())
                .build();
    }
}
