package com.example.demo.Administration.controller;

import com.example.demo.Administration.dto.CreateCityRequest;
import com.example.demo.Administration.dto.GetCitiesResponse;
import com.example.demo.Administration.dto.GetCityResponse;
import com.example.demo.Administration.dto.UpdateCityRequest;
import com.example.demo.Administration.entity.City;
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
@RequestMapping("api/cities")
public class CityController {

    private CityService cityService;

    private CountryService countryService;

    @Autowired
    public CityController(CityService cityService, CountryService countryService){
        this.cityService = cityService;
        this.countryService = countryService;
    }

    @GetMapping
    public ResponseEntity<GetCitiesResponse> getCities(){
        List<City> all = cityService.findAll();
        GetCitiesResponse response = GetCitiesResponse.entityToDtoMapper(all);
        return ResponseEntity.ok(response);
    }

    @GetMapping("{id}")
    public ResponseEntity<GetCityResponse> getCity(@PathVariable("id") int id){
        Optional<City> city = cityService.find(id);
        if(city.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        else{
            GetCityResponse response = GetCityResponse.entityToDtoMapper(city.get());
            return ResponseEntity.ok(response);
        }
    }

    @PostMapping
    public ResponseEntity<Void> createCity(@RequestBody CreateCityRequest request, UriComponentsBuilder builder){
        City city = CreateCityRequest.dtoToEntityMapper(request,null);
        city = cityService.create(city);

        return ResponseEntity.created(builder.pathSegment("api", "cities", "{id}")
                .buildAndExpand(city.getId()).toUri()).build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteCity(@PathVariable("id") int id){
        Optional<City> city = cityService.find(id);
        if(city.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        else{
            cityService.delete(city.get().getId());
            return ResponseEntity.accepted().build();
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> updateCity(@PathVariable("id") int id,
                                           @RequestBody UpdateCityRequest request){
        Optional<City> city = cityService.find(id);
        if(city.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        else{
            City c = city.get();
            UpdateCityRequest.dtoToEntityUpdater(c, request);
            cityService.update(c);
            return ResponseEntity.accepted().build();
        }
    }
}
