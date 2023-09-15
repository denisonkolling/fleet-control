package com.fleetcontrol.repository;

import com.fleetcontrol.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
