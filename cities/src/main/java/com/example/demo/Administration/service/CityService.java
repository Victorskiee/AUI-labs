package com.example.demo.Administration.service;

import com.example.demo.Administration.entity.City;
import com.example.demo.Administration.entity.Country;
import com.example.demo.Administration.repository.CityRepository;
import com.example.demo.Administration.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CityService {
    private CityRepository repository;

    private CountryRepository countryRepository;

    @Autowired
    public CityService(CityRepository repository, CountryRepository countryRepository){
        this.repository = repository;
        this.countryRepository = countryRepository;
    }

    public Optional<City> find(int id){
        return repository.findById(id);
    }

    public Optional<City> find(String countryName, int id){
        Optional<Country> country = countryRepository.findById(countryName);
        if(country.isPresent()){
            return repository.findByIdAndCountry(id, country.get());
        }
        else{
            return Optional.empty();
        }
    }

    public List<City> findAll(){
        return repository.findAll();
    }

    public List<City> findAll(Country country){
        return repository.findAllByCountry(country);
    }

    @Transactional
    public City create(City city){
        return repository.save(city);
    }

    @Transactional
    public void update(City city) {repository.save(city);}

    @Transactional
    public void delete(int id){ repository.deleteById(id); }
}
