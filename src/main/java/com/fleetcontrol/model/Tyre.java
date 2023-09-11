package com.fleetcontrol.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "tyres")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Tyre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String manufacturer;

    private String serial;

    private String model;

    private String size;

    private String position;

    private String vehicle;

//    private Double insideTread;
//
//    private Double midleTread;
//
//    private Double outsideTread;

    @OneToMany(mappedBy = "tyre", fetch = FetchType.LAZY)

    @JsonIgnore
    private List<TyreReading> readings = new ArrayList<>();
}
