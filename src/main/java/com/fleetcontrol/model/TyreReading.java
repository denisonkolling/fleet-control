package com.fleetcontrol.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tab_tyres_readings")


public class TyreReading {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    private LocalDateTime readingDate = LocalDateTime.now();

    private Double insideTread;

    private Double midleTread;

    private Double outsideTread;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tyre_id")
    private Tyre tyre;

}
