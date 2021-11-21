package com.example.demo.country.event.dto;

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

    public static CreateCountryRequest entityToDtoMapper(Country request){
        return CreateCountryRequest.builder()
                .name(request.getName())
                .build();
    }
}
