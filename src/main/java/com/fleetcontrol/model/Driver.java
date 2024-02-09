package com.fleetcontrol.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@Builder
@Entity
@Table(name = "drivers")
@NoArgsConstructor
@AllArgsConstructor

public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private LocalDate birthday;

    private String licenseId;

    private LocalDate expiryDate;

    private String licenseClass;

}