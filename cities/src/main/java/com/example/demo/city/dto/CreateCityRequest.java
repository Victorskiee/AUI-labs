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
public class CreateCityRequest {

    private String name;

    private String Country;

    private int nrOfStreets;

    public static City dtoToEntityMapper(CreateCityRequest request, Country country){
        return City.builder()
                .name(request.getName())
                .nrOfStreets(request.getNrOfStreets())
                .country(country)
                .build();
    }
}
