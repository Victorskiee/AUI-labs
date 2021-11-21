package com.example.demo.Administration.repository;

import com.example.demo.Administration.entity.City;
import com.example.demo.Administration.entity.Country;
import com.example.demo.Storage.DataStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {

    Optional<City> findById(int id);

    Optional<City> findByIdAndCountry(int id, Country country);

    List<City> findAllByCountry(Country country);

    /*private DataStorage storage;

    @Autowired
    public CityRepository(DataStorage storage){
        this.storage = storage;
    }

    @Override
    public Optional<City> find(String id) {
        City city = new City();
        for(City c : storage.getCities()) {
            if(c.getName().equals(id)){
                city.setCountry(c.getCountry());
                city.setName(c.getName());
                city.setNrOfStreets(c.getNrOfStreets());
                Optional<City> opt = Optional.of(city);
                return opt;
            }
        }
        return Optional.empty();
    }

    @Override
    public List<City> findAll() {
        List<City> listOfCities = new ArrayList<>();
        for(City city : storage.getCities()){
            City c = new City();
            c.setName(city.getName());
            c.setNrOfStreets(city.getNrOfStreets());
            Country country = new Country();
            country.setNrOfInhabitants(city.getCountry().getNrOfInhabitants());
            country.setGdpChange(city.getCountry().getGdpChange());
            country.setName(city.getCountry().getName());
            c.setCountry(country);
            listOfCities.add(c);
        }
        return listOfCities;
    }

    @Override
    public void create(City entity) {
        boolean unique = true;
        City newCity = new City();
        newCity.setNrOfStreets(entity.getNrOfStreets());
        newCity.setCountry(entity.getCountry());
        newCity.setName(entity.getName());

        for(City c : storage.getCities()){
            if(c.getName().equals(newCity.getName())){
                unique = false;
                System.out.println("Name exists, didn't add city");
                break;
            }
        }

        if(unique) {
            storage.getCities().add(newCity);
        }
    }

    @Override
    public void delete(City entity) {
        int index = -1;
        for(int i=0; i<storage.getCities().size(); i++){
            if(storage.getCities().get(i).getName().equals(entity.getName())){
                index = i;
                break;
            }
        }
        if(index >= 0){
            storage.getCities().remove(index);
        }
    }*/
}
