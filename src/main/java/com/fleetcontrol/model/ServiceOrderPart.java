package com.fleetcontrol.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "service_order_parts")
@Entity

public class ServiceOrderPart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "part_id")
    private Part part;

    private Integer quantity;

    private Double unitPrice;

    @ManyToMany
    @JoinColumn(name = "service_orders_id")
    @JsonIgnore
    private List<ServiceOrder> serviceOrder;

}