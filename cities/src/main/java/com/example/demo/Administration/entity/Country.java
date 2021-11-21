package com.example.demo.Administration.entity;

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

    private int nrOfInhabitants;

    private double gdpChange;

    @OneToMany(mappedBy = "country", cascade = CascadeType.REMOVE)
    @ToString.Exclude
    @Basic(fetch = FetchType.LAZY)
    private List<City> cities;
}
