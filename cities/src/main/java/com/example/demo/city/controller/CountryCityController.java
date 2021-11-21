package com.example.demo.city.controller;

import com.example.demo.city.dto.CreateCityRequest;
import com.example.demo.city.dto.GetCitiesResponse;
import com.example.demo.city.dto.GetCityResponse;
import com.example.demo.city.dto.UpdateCityRequest;
import com.example.demo.city.entity.City;
import com.example.demo.city.service.CityService;
import com.example.demo.country.entity.Country;
import com.example.demo.country.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/countries/{country}/cities")
public class CountryCityController {

    private CityService cityService;

    private CountryService countryService;

    @Autowired
    public CountryCityController(CityService cityService, CountryService countryService){
        this.cityService = cityService;
        this.countryService = countryService;
    }

    @GetMapping
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

    @GetMapping("{id}")
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

    @PostMapping
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

    @DeleteMapping("{id}")
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

    @PutMapping("{id}")
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
}
