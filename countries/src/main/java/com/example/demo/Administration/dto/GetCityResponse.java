package com.example.demo.Administration.dto;

import com.example.demo.Administration.entity.City;
import lombok.*;

import java.util.function.Function;

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
