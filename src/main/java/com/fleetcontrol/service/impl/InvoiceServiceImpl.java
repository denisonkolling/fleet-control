package com.fleetcontrol.service.impl;

import com.fleetcontrol.dto.InvoiceRequest;
import com.fleetcontrol.dto.ItemRequest;
import com.fleetcontrol.infra.InvoiceNotFoundException;
import com.fleetcontrol.model.*;
import com.fleetcontrol.repository.CustomerRepository;
import com.fleetcontrol.repository.InvoiceRepository;
import com.fleetcontrol.repository.ItemRepository;
import com.fleetcontrol.repository.ProductRepository;
import com.fleetcontrol.service.InvoiceService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InvoiceServiceImpl implements InvoiceService {


    private InvoiceRepository invoiceRepository;

    private CustomerRepository customerRepository;

    private ItemRepository itemRepository;

    private ProductRepository productRepository;

    public InvoiceServiceImpl(InvoiceRepository invoiceRepository, CustomerRepository customerRepository, ItemRepository itemRepository, ProductRepository productRepository) {
        this.invoiceRepository = invoiceRepository;
        this.customerRepository = customerRepository;
        this.itemRepository = itemRepository;
        this.productRepository = productRepository;
    }

    @Override
    public Invoice createInvoice(InvoiceRequest invoiceRequest) {
        Invoice invoice = new Invoice();

        Customer issuer = customerRepository.findById(invoiceRequest.getIssuerId())
                .orElseThrow(() -> new IllegalArgumentException("Issuer not found"));
        Customer buyer = customerRepository.findById(invoiceRequest.getBuyerId())
                .orElseThrow(() -> new IllegalArgumentException("Buyer not found"));

        invoice.setNumber(invoiceRequest.getNumber());
        invoice.setDate(invoiceRequest.getDate());
        invoice.setIssuer(issuer);
        invoice.setBuyer(buyer);

        List<ItemRequest> itemRequests = invoiceRequest.getItems();

        if (itemRequests != null && !itemRequests.isEmpty()) {

            List<Item> items = new ArrayList<>();

            List<Double> itemsValue = new ArrayList<>();

            for (ItemRequest itemRequest : itemRequests) {

                Product product = productRepository.findById(itemRequest.getProductId()).orElseThrow(() -> new EntityNotFoundException("Product not found"));

                Item item = new Item();

                item.setProduct(product);
                item.setQuantity(itemRequest.getQuantity());
                item.setUnitPrice(itemRequest.getUnitPrice());

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

    @Override
    public Invoice getInvoiceById(Long id) {
        return invoiceRepository.findById(id).get();
    }

    @Override
    public Invoice getInvoiceByNumber(Long invoiceNumber) {
        Invoice invoice = invoiceRepository.findByNumber(invoiceNumber);
        if (invoice != null) {
            return invoice;
        }
        throw new InvoiceNotFoundException("Invoice not found with number: " + invoiceNumber);
    }
}
