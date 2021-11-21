package com.example.demo.Administration.repository;

import com.example.demo.Administration.entity.City;
import com.example.demo.Administration.entity.Country;
import org.springframework.stereotype.Repository;
import com.example.demo.Storage.DataStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {

    Optional<Country> findByName(String name);



    /*private DataStorage storage;

    @Autowired
    public CountryRepository(DataStorage storage){
        this.storage = storage;
    }

    @Override
    public Optional<Country> find(String id) {
        Country country = new Country();
        for(Country c : storage.getCountries()) {
            if(c.getName().equals(id)){
                country.setName(c.getName());
                country.setGdpChange(c.getGdpChange());
                country.setNrOfInhabitants(c.getNrOfInhabitants());
                Optional<Country> opt = Optional.of(country);
                return opt;
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Country> findAll() {
        List<Country> listOfCountries = new ArrayList<>();
        for(Country country : storage.getCountries()){
            Country ctr = new Country();
            ctr.setGdpChange(country.getGdpChange());
            ctr.setName(country.getName());
            ctr.setNrOfInhabitants(country.getNrOfInhabitants());
            listOfCountries.add(ctr);
        }
        return listOfCountries;
    }

    @Override
    public void create(Country entity) {
        boolean unique = true;
        Country newCountry = new Country();
        newCountry.setNrOfInhabitants(entity.getNrOfInhabitants());
        newCountry.setGdpChange(entity.getGdpChange());
        newCountry.setName(entity.getName());

        for(Country c : storage.getCountries()){
            if(c.getName().equals(newCountry.getName())){
                unique = false;
                System.out.println("Name exists, didn't add country");
                break;
            }
        }

        if(unique) {
            storage.getCountries().add(newCountry);
        }
    }

    @Override
    public void delete(Country entity) {
        int index = -1;
        for(int i=0; i<storage.getCountries().size(); i++){
            if(storage.getCountries().get(i).getName().equals(entity.getName())){
                index = i;
                break;
            }
        }
        if(index >= 0){
            storage.getCountries().remove(index);
        }
    }*/
}
