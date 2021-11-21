package com.example.demo.Configuration;

import com.example.demo.city.entity.City;
import com.example.demo.city.service.CityService;
import com.example.demo.country.entity.Country;
import com.example.demo.country.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;

@Component
public class DataInitializer {
    private final CityService cityService;

    private final CountryService countryService;

    @Autowired
    public DataInitializer(CityService cityService, CountryService countryService){
        this.countryService = countryService;
        this.cityService = cityService;
    }

    @PostConstruct
    private synchronized void init(){
        Country c1 = Country.builder()
                .name("Poland")
                .build();
        Country c2 = Country.builder()
                .name("France")
                .build();
        Country c3 = Country.builder()
                .name("Spain")
                .build();

        countryService.create(c1);
        countryService.create(c2);
        countryService.create(c3);

        City ci1 = City.builder()
                .country(c1)
                .name("Gdansk")
                .nrOfStreets(300)
                .build();

        City ci2 = City.builder()
                .country(c2)
                .name("Paris")
                .nrOfStreets(500)
                .build();

        City ci3 = City.builder()
                .country(c3)
                .name("Barcelona")
                .nrOfStreets(350)
                .build();

        cityService.create(ci1);
        cityService.create(ci2);
        cityService.create(ci3);

    }
}
