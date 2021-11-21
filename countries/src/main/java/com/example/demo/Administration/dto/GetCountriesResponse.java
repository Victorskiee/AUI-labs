package com.example.demo.Administration.dto;

import lombok.*;
import java.util.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class GetCountriesResponse {

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @ToString
    @EqualsAndHashCode
    public static class Country{

        private String name;

    }

    @Singular
    private List<Country> countries;

    public static GetCountriesResponse entityToDtoMapper(Collection<com.example.demo.Administration.entity.Country> countries){
        GetCountriesResponse.GetCountriesResponseBuilder response = GetCountriesResponse.builder();
        countries.stream()
                .map(country -> Country.builder()
                        .name(country.getName())
                        .build())
                .forEach(response::country);
        return response.build();
    }
}
