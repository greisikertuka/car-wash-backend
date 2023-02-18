package com.carwash.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "CARS")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    public Long id;

    @Column(name = "MODEL")
    @NonNull
    public String model;

    @Column(name = "YEAR")
    @NonNull
    public String year;
}
