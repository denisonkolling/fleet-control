package com.fleetcontrol.service.impl;

import com.fleetcontrol.dto.InvoiceDto;
import com.fleetcontrol.dto.ItemDto;
import com.fleetcontrol.model.*;
import com.fleetcontrol.repository.CustomerRepository;
import com.fleetcontrol.repository.InvoiceRepository;
import com.fleetcontrol.repository.ItemRepository;
import com.fleetcontrol.repository.ProductRepository;
import com.fleetcontrol.service.InvoiceService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Invoice createInvoice(InvoiceDto invoiceDto) {
        Invoice invoice = new Invoice();

        Customer issuer = customerRepository.findById(invoiceDto.getIssuerId())
                .orElseThrow(() -> new IllegalArgumentException("Issuer not found"));
        Customer buyer = customerRepository.findById(invoiceDto.getBuyerId())
                .orElseThrow(() -> new IllegalArgumentException("Buyer not found"));

        invoice.setNumber(invoiceDto.getNumber());
        invoice.setDate(invoiceDto.getDate());
        invoice.setIssuer(issuer);
        invoice.setBuyer(buyer);

        List<ItemDto> itemDtos = invoiceDto.getItems();

        if (itemDtos != null && !itemDtos.isEmpty()) {

            List<Item> items = new ArrayList<>();

            List<Double> itemsValue = new ArrayList<>();

            for (ItemDto itemDto : itemDtos) {

                Product product = productRepository.findById(itemDto.getProductId()).orElseThrow(() -> new EntityNotFoundException("Product not found"));

                Item item = new Item();

                item.setProduct(product);
                item.setQuantity(itemDto.getQuantity());
                item.setUnitPrice(itemDto.getUnitPrice());

                items.add(item);

                double itemTotalValue = item.getUnitPrice() * item.getQuantity();

                itemsValue.add(itemTotalValue);
            }

            double totalInvoiceValue = itemsValue.stream().mapToDouble(itemsTotalValue -> itemsTotalValue).sum();

            invoice.setInvoiceTotalValue(totalInvoiceValue);
            invoice.setItems(items);
        }

        return invoiceRepository.save(invoice);
    }

    @Override
    public List<Invoice> getAllInvoice() {
        return invoiceRepository.findAll();
    }
}