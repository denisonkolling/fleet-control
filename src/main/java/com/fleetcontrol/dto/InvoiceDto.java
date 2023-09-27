package com.fleetcontrol.dto;

import com.fleetcontrol.model.Customer;
import com.fleetcontrol.model.Item;
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

public class InvoiceDto {

    private Long number;

    private LocalDate date;

    private Customer issuer;

    private Customer buyer;

    private List<ItemDto> items;
}
