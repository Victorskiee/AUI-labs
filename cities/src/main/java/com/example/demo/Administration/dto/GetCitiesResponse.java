package com.example.demo.Administration.dto;

import com.example.demo.Administration.entity.City;
import lombok.*;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class GetCitiesResponse {

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @ToString
    @EqualsAndHashCode
    public static class City{

        private int id;

        private String name;

    }

    @Singular
    private List<City> cities;

    public static GetCitiesResponse entityToDtoMapper(Collection<com.example.demo.Administration.entity.City> cities){
        GetCitiesResponseBuilder response = GetCitiesResponse.builder();
        cities.stream()
                .map(city -> City.builder()
                        .id(city.getId())
                        .name(city.getName())
                        .build())
                .forEach(c -> response.city(c));
        return response.build();
    }
}
