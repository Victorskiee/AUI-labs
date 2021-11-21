package com.example.demo.Configuration;

import com.example.demo.Administration.entity.City;
import com.example.demo.Administration.entity.Country;
import com.example.demo.Administration.service.CityService;
import com.example.demo.Administration.service.CountryService;
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
                .nrOfInhabitants(40_000_000)
                .gdpChange(-2.7)
                .build();
        Country c2 = Country.builder()
                .name("France")
                .nrOfInhabitants(88_000_000)
                .gdpChange(-2.91)
                .build();
        Country c3 = Country.builder()
                .name("Spain")
                .nrOfInhabitants(77_770_000)
                .gdpChange(-5.9)
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

        /*System.out.println(c1.toString());
        System.out.println(c2.toString());
        System.out.println(c3.toString());
        System.out.println(ci1.toString());
        System.out.println(ci2.toString());
        System.out.println(ci3.toString());*/

    }
}
