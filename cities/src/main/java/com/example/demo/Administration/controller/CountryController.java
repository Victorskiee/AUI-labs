package com.example.demo.Administration.controller;

import com.example.demo.Administration.dto.*;
import com.example.demo.Administration.entity.City;
import com.example.demo.Administration.entity.Country;
import com.example.demo.Administration.service.CityService;
import com.example.demo.Administration.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;

@RestController
@RequestMapping("api/countries")
public class CountryController {

    private CityService cityService;

    private CountryService countryService;

    @Autowired
    public CountryController(CityService cityService, CountryService countryService){
        this.cityService = cityService;
        this.countryService = countryService;
    }

    @GetMapping("{country}/cities")
    public ResponseEntity<GetCitiesResponse> getCities(@PathVariable("country") String name){
        Optional<Country> country = countryService.find(name);
        if(country.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        else{
            List<City> cities = cityService.findAll(country.get());
            GetCitiesResponse response = GetCitiesResponse.entityToDtoMapper(cities);
            return ResponseEntity.ok(response);
        }
    }

    @GetMapping("{country}/cities/{id}")
    public ResponseEntity<GetCityResponse> getCity(@PathVariable("country") String name, @PathVariable("id") int id){
        Optional<City> city = cityService.find(name, id);
        if(city.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        else{
            GetCityResponse response = GetCityResponse.entityToDtoMapper(city.get());
            return ResponseEntity.ok(response);
        }
    }

    @PostMapping("{country}/cities")
    public ResponseEntity<Void> createCity(@PathVariable("country") String name,
                                           @RequestBody CreateCityRequest request,
                                           UriComponentsBuilder builder){
        Optional<Country> country = countryService.find(name);
        if(country.isPresent()){
            City city = CreateCityRequest.dtoToEntityMapper(request, country.get());
            city = cityService.create(city);
            return ResponseEntity.created(builder.pathSegment("api", "countries", "{country}", "cities")
                    .buildAndExpand(country.get().getName(), city.getId()).toUri()).build();
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{country}/cities/{id}")
    public ResponseEntity<Void> deleteCity(@PathVariable("country") String name,
                                           @PathVariable("id") int id){
        Optional<City> city = cityService.find(name, id);
        if(city.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        else{
            cityService.delete(city.get().getId());
            return ResponseEntity.accepted().build();
        }
    }

    @PutMapping("{country}/cities/{id}")
    public ResponseEntity<Void> updateCity(@PathVariable("country") String name,
                                           @PathVariable("id") int id,
                                           @RequestBody UpdateCityRequest request){
        Optional<City> city = cityService.find(name, id);
        if(city.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        else{
            City c = city.get();;
            UpdateCityRequest.dtoToEntityUpdater(c, request);
            cityService.update(c);
            return ResponseEntity.accepted().build();
        }
    }

    //----------------------------------------------------------------------------------

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
