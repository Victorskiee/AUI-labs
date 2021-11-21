package com.example.demo.country.entity;

import lombok.*;
import javax.persistence.*;

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
}
