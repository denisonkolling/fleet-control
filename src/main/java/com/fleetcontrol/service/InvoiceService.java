package com.fleetcontrol.service;

import com.fleetcontrol.model.Invoice;
import com.fleetcontrol.model.RepairOrder;

import java.util.List;

public interface InvoiceService {

    public Invoice createInvoice(Invoice invoice);

    public List<Invoice> getAllInvoice();

}
