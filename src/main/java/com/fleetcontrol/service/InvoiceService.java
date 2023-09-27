package com.fleetcontrol.service;

import com.fleetcontrol.dto.InvoiceDto;
import com.fleetcontrol.model.Invoice;
import com.fleetcontrol.model.RepairOrder;

import java.util.List;

public interface InvoiceService {

    public Invoice createInvoice(InvoiceDto invoiceDto);

    public List<Invoice> getAllInvoice();

}
