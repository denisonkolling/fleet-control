package com.fleetcontrol.service;

import com.fleetcontrol.dto.InvoiceDto;
import com.fleetcontrol.model.Invoice;

import java.util.List;

public interface InvoiceService {

    Invoice createInvoice(InvoiceDto invoiceDto);

    List<Invoice> getAllInvoice();

}
