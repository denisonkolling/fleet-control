package com.fleetcontrol.controller;

import com.fleetcontrol.dto.InvoiceDto;
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

    @GetMapping("/{id}")
    private ResponseEntity<?> getInvoiceById(@PathVariable Long id){
        return new ResponseEntity<>(invoiceService.getInvoiceById(id), HttpStatus.OK);
    }

    @GetMapping("/number/{invoiceNumber}")
    public ResponseEntity<?> getInvoiceByNumber(@PathVariable Long invoiceNumber){
        return new ResponseEntity<>(invoiceService.getInvoiceByNumber(invoiceNumber), HttpStatus.OK);
    }
}
