package com.fleetcontrol.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fleetcontrol.dto.InvoiceDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "invoices")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long number;

    private LocalDate date;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "issuer_id")
    private Customer issuer;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "buyer_id")
    private Customer buyer;

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "item_id")
//    private Item item;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "item_id")
    private List<Item> items;

    private Double invoiceTotalValue;

}
