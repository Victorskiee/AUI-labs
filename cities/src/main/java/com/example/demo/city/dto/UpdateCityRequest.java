package com.example.demo.city.dto;

import com.example.demo.city.entity.City;
import lombok.*;

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
