package com.example.demo.Administration.repository;

import com.example.demo.Administration.entity.Country;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {

    Optional<Country> findByName(String name);
}
