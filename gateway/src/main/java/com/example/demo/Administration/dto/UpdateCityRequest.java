package com.example.demo.Administration.dto;

import com.example.demo.Administration.entity.City;
import lombok.*;

import java.util.function.BiFunction;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class UpdateCityRequest {

    private String name;

    private int nrOfStreets;

    public static void dtoToEntityUpdater(City city, UpdateCityRequest request){
            city.setName(request.getName());
            city.setNrOfStreets(request.getNrOfStreets());
    }
}
