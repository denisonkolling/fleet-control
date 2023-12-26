package com.fleetcontrol.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "service_order_services")

public class ServiceOrderService implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "service_order_id")
    @JsonIgnoreProperties("service_orders")
    private ServiceOrder serviceOrder;

    @Id
    @ManyToOne
    @JoinColumn(name = "service_id")
    @JsonIgnoreProperties("services")
    private Service service;

    private Integer quantity;

    private Double unitPrice;

}