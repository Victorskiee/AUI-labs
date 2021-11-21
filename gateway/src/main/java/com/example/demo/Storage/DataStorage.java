package com.example.demo.Storage;

import com.example.demo.Administration.entity.City;
import com.example.demo.Administration.entity.Country;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@Getter
@Setter
public class DataStorage {
    private List<City> cities = new ArrayList<>();

    private List<Country> countries = new ArrayList<>();
}
