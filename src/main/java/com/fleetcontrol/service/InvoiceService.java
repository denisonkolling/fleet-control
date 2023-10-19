package com.fleetcontrol.service;

import com.fleetcontrol.dto.InvoiceDto;
import com.fleetcontrol.model.Invoice;

import java.util.List;

public interface InvoiceService {

    Invoice createInvoice(InvoiceDto invoiceDto);

    List<Invoice> getAllInvoice();

    Invoice getInvoiceById(Long id);

//    TODO: Implementar LIST no retorno do metodo getInvoiceByNumber -> pode haver mais de uma nota com mesmo número
    Invoice getInvoiceByNumber(Long id);

}
