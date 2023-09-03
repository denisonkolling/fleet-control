package com.fleetcontrol.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@Table(name = "tyres")
@NoArgsConstructor
@AllArgsConstructor
public class Tyre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String manufacturer;

    private String serial;

    private String model;

    private String Size;

    private String position;

    private String vehicle;

    private Double insideTread;

    private Double midleTread;

    private Double outsideTread;

}
