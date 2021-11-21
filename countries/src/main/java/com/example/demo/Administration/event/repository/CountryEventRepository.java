package com.example.demo.Administration.event.repository;

import com.example.demo.Administration.entity.Country;
import com.example.demo.Administration.event.dto.CreateCountryRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class CountryEventRepository {

    private RestTemplate restTemplate;

    @Autowired
    public CountryEventRepository(@Value("${administration.cities.url}") String baseUrl){
        restTemplate = new RestTemplateBuilder().rootUri(baseUrl).build();
    }

    public void delete(String id){
        restTemplate.delete("/countries/{country}", id);
    }

    public void create(Country country){
        restTemplate.postForLocation("/countries", CreateCountryRequest.entityToDtoMapper(country));
    }
}
