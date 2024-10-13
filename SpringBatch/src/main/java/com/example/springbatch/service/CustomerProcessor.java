package com.example.springbatch.service;

import com.example.springbatch.model.Customer;
import org.springframework.batch.item.ItemProcessor;

public class CustomerProcessor implements ItemProcessor<Customer, Customer> {

    @Override
    public Customer process(Customer customer) {
        int id = customer.getId();
        if (id != 0) {
            return customer;
        }
        return null;
    }
}
