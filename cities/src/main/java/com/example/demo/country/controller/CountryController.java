package com.example.demo.country.controller;

import com.example.demo.country.dto.CreateCountryRequest;
import com.example.demo.country.entity.Country;
import com.example.demo.country.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.util.Optional;

@RestController
@RequestMapping("api/countries")
public class CountryController {

    private CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService){
        this.countryService = countryService;
    }

    @PostMapping("")
    public ResponseEntity<Void> createCountry(@RequestBody CreateCountryRequest request, UriComponentsBuilder builder){
       Country country = CreateCountryRequest.dtoToEntityMapper(request);
       countryService.create(country);
       return ResponseEntity
               .created(builder
                        .pathSegment("api", "countries", "{country}")
                        .buildAndExpand(country.getName()).toUri())
               .build();
    }

    @DeleteMapping("{country}")
    public ResponseEntity<Void> deleteCountry(@PathVariable("country") String name){
        Optional<Country> country = countryService.find(name);
        if (country.isPresent()){
            countryService.delete(country.get().getName());
            return ResponseEntity
                    .accepted()
                    .build();
        }
        else{
            return ResponseEntity
                    .notFound()
                    .build();
        }
    }
}
