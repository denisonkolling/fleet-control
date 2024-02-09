package com.fleetcontrol.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "service_orders")

public class ServiceOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String plate;

    private LocalDateTime openDate;

    private LocalDateTime closeDate;

    @JsonBackReference
    @OneToMany(mappedBy = "serviceOrder", cascade = CascadeType.ALL)
    private List<ServiceOrderService> services;

    @JsonBackReference
    @OneToMany(mappedBy = "serviceOrder", cascade = CascadeType.ALL)
    private List<ServiceOrderPart> parts;



}
