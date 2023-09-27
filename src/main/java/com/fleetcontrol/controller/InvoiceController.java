package com.fleetcontrol.controller;

import com.fleetcontrol.dto.InvoiceDto;
import com.fleetcontrol.model.Invoice;
import com.fleetcontrol.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("invoice")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @PostMapping
    public ResponseEntity<?> createInvoice(@RequestBody InvoiceDto invoiceDto){
        return new ResponseEntity<>(invoiceService.createInvoice(invoiceDto), HttpStatus.CREATED);
    }

    @GetMapping
    private ResponseEntity<?> getAllInvoice(){
        return new ResponseEntity<>(invoiceService.getAllInvoice(), HttpStatus.OK);
    }
}
