package com.fleetcontrol.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "service_order_services")

public class ServiceOrderService {

    @Id
    @ManyToOne
    @JoinColumn(name = "service_order_id")
    private ServiceOrder serviceOrder;

    @Id
    @ManyToOne
    @JoinColumn(name = "service_id")
    private Service service;

    private Integer quantity;

    private Double unitPrice;

}