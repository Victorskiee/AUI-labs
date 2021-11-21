package com.example.demo.Configuration;

import com.example.demo.country.entity.Country;
import com.example.demo.country.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DataInitializer {

    private final CountryService countryService;

    @Autowired
    public DataInitializer(CountryService countryService){
        this.countryService = countryService;
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
    }
}
