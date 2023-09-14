package com.fleetcontrol.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Address {

    private String street;

    private String number;

    private String city;

    private String country;

    private String state;

    private String zip;

}
