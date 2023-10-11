package com.fleetcontrol.service;

import com.fleetcontrol.model.Customer;
import com.fleetcontrol.model.Driver;

import java.util.List;


public interface CustomerService {

    Customer createCustomer(Customer customer);

    List<Customer> getAllCustomer();

    Customer getCustomerById(Long id);
}
