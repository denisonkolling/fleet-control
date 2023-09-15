package com.fleetcontrol.service.impl;

import com.fleetcontrol.model.Customer;
import com.fleetcontrol.model.Invoice;
import com.fleetcontrol.model.Item;
import com.fleetcontrol.model.RepairOrder;
import com.fleetcontrol.repository.CustomerRepository;
import com.fleetcontrol.repository.InvoiceRepository;
import com.fleetcontrol.repository.ItemRepository;
import com.fleetcontrol.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Invoice createInvoice(Invoice form) {
        Invoice invoice = new Invoice();
        Customer issuer = customerRepository.findById(form.getIssuer().getId()).get();
        Customer buyer = customerRepository.findById(form.getBuyer().getId()).get();
        Item item = itemRepository.findById(form.getItem().getId()).get();

        invoice.setNumber(form.getNumber());
        invoice.setDate(form.getDate());
        invoice.setIssuer(issuer);
        invoice.setBuyer(buyer);
        invoice.setItem(item);

        return invoiceRepository.save(invoice);

    }

    @Override
    public List<Invoice> getAllInvoice() {
        return invoiceRepository.findAll();
    }
}
