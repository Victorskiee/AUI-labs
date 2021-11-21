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
public class CountryService {
    private CountryRepository repository;

    @Autowired
    public CountryService(CountryRepository repository){
        this.repository = repository;
    }

    public Optional<Country> find(String name){
        return repository.findById(name);
    }

    public List<Country> findAll(){
        return repository.findAll();
    }

    @Transactional
    public void create(Country country){
        repository.save(country);
    }

    @Transactional
    public void update(Country country){
        repository.save(country);
    }

    @Transactional
    public void delete(String id){
        repository.deleteById(id);
    }
}
