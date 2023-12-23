package com.fleetcontrol.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "vehicle_service_orders")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class ServiceOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String plate;

    private LocalDateTime openDate;

    private LocalDateTime closeDate;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "service_id")
    private List<ServiceOrderService> services;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "part_id")
    private List<ServiceOrderPart> parts;

}
