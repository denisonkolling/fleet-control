package com.fleetcontrol.controller;

import com.fleetcontrol.model.Invoice;
import com.fleetcontrol.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("invoice")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @PostMapping
    public ResponseEntity<?> createInvoice(@RequestBody Invoice invoice){
        return new ResponseEntity<>(invoiceService.createInvoice(invoice), HttpStatus.CREATED);
    }
}
