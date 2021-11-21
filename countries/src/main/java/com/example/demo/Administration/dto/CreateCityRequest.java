package com.example.demo.Administration.dto;

import com.example.demo.Administration.entity.City;
import com.example.demo.Administration.entity.Country;
import lombok.*;

import java.util.function.Function;
import java.util.function.Supplier;

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
