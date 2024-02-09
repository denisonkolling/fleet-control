package com.fleetcontrol.service;

import com.fleetcontrol.dto.InvoiceRequest;
import com.fleetcontrol.model.Invoice;

import java.util.List;

public interface InvoiceService {

    Invoice createInvoice(InvoiceRequest invoiceRequest);

    List<Invoice> getAllInvoice();

    Invoice getInvoiceById(Long id);

//    TODO: Implementar LIST no retorno do metodo getInvoiceByNumber -> pode haver mais de uma nota com mesmo número

    Invoice getInvoiceByNumber(Long id);

}
