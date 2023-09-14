package com.fleetcontrol.service.impl;

import com.fleetcontrol.model.Customer;
import com.fleetcontrol.repository.CustomerRepository;
import com.fleetcontrol.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
}
