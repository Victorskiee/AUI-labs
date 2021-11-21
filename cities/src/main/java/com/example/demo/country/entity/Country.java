package com.example.demo.country.entity;

import com.example.demo.city.entity.City;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "countries")
public class Country {

    @Id
    @Column(name = "country_name")
    private String name;

    @OneToMany(mappedBy = "country", cascade = CascadeType.REMOVE)
    @ToString.Exclude
    @Basic(fetch = FetchType.LAZY)
    private List<City> cities;
}
