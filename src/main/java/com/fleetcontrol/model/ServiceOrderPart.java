package com.fleetcontrol.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "service_order_parts")

public class ServiceOrderPart {

    @Id
    @ManyToOne
    @JoinColumn(name = "service_order_id")
    private ServiceOrder serviceOrder;

    @Id
    @ManyToOne
    @JoinColumn(name = "part_id")
    private Part part;

    private Integer quantity;

    private Double unitPrice;

}