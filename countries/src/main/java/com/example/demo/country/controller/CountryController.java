package com.example.demo.country.controller;

import com.example.demo.country.dto.*;
import com.example.demo.country.entity.Country;
import com.example.demo.country.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.util.*;

@RestController
@RequestMapping("api/countries")
public class CountryController {

    private CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService){
        this.countryService = countryService;
    }

    @GetMapping
    public ResponseEntity<GetCountriesResponse> getCountries(){
        List<Country> all = countryService.findAll();
        GetCountriesResponse response = GetCountriesResponse.entityToDtoMapper(all);
        return ResponseEntity.ok(response);
    }

    @GetMapping("{country}")
    public ResponseEntity<GetCountryResponse> getCountry(@PathVariable("country") String name){
        Optional<Country> country = countryService.find(name);
        if(country.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        else{
            GetCountryResponse response = GetCountryResponse.entityToDtoMapper(country.get());
            return ResponseEntity.ok(response);
        }
    }

    @PostMapping
    public ResponseEntity<Void> createCountry(@RequestBody CreateCountryRequest request,
                                              UriComponentsBuilder builder){
        Optional<Country> c = countryService.find(request.getName());
        if(c.isEmpty()) {
            Country country = CreateCountryRequest.dtoToEntityMapper(request);
            countryService.create(country);

            return ResponseEntity.created(builder.pathSegment("api", "countries", "{country}")
                    .buildAndExpand(country.getName()).toUri()).build();
        }
        else{
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("{country}")
    public ResponseEntity<Void> deleteCountry(@PathVariable("country") String name){
        Optional<Country> country = countryService.find(name);
        if(country.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        else{
            countryService.delete(country.get().getName());
            return ResponseEntity.accepted().build();
        }
    }

    @PutMapping("{country}")
    public ResponseEntity<Void> updateCountry(@PathVariable("country") String name,
                                           @RequestBody UpdateCountryRequest request){
        Optional<Country> country = countryService.find(name);
        if(country.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        else{
            Country c = country.get();
            UpdateCountryRequest.dtoToEntityUpdater(c, request);
            countryService.update(c);
            return ResponseEntity.accepted().build();
        }
    }
}
