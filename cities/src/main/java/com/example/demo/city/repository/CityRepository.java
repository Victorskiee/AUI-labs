package com.example.demo.city.repository;

import com.example.demo.city.entity.City;
import com.example.demo.country.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {

    Optional<City> findById(int id);

    Optional<City> findByIdAndCountry(int id, Country country);

    List<City> findAllByCountry(Country country);
}
