package com.example.demo.city.entity;

import com.example.demo.country.entity.Country;
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
@Table(name = "cities")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "city_name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "country")
    private Country country;

    private int nrOfStreets;
}
