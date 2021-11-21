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
public class CreateCountryRequest {

    private String name;

    private int nrOfInhabitants;

    private double gdpChange;

    public static Country dtoToEntityMapper(CreateCountryRequest request){
        return Country.builder()
                .name(request.getName())
                .nrOfInhabitants(request.getNrOfInhabitants())
                .gdpChange(request.getGdpChange())
                .build();
    }
}
