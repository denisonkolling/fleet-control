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
@Table(name = "service_orders")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class ServiceOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String plate;

    private LocalDateTime openDate;

    private LocalDateTime closeDate;

    @ManyToMany(cascade=CascadeType.PERSIST)
    @JoinTable(name = "service_orders_services",
            joinColumns = @JoinColumn(name = "service_order_fk"),
            inverseJoinColumns = @JoinColumn(name = "service_order_service_fk"))
    private List<ServiceOrderService> services;

    @ManyToMany(cascade=CascadeType.PERSIST)
    @JoinTable(name = "service_orders_parts",
            joinColumns = @JoinColumn(name = "service_order_fk"),
            inverseJoinColumns = @JoinColumn(name = "service_order_part_fk"))
    private List<ServiceOrderPart> parts;

}
