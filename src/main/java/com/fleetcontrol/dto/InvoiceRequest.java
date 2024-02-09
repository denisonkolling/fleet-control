package com.fleetcontrol.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Builder
@Data
@Embeddable
@NoArgsConstructor

public class InvoiceRequest {

    private Long number;

    private LocalDate date;

    private Long issuerId;

    private Long buyerId;

    private List<ItemRequest> items;

}
