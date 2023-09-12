package com.fleetcontrol.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "vehicle_parts")

public class Part {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long partId;

    private String partName;

    private String partCategory;

    private Double partPrice;
}
