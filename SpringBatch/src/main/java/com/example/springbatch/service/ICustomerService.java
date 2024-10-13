package com.example.springbatch.service;

import com.example.springbatch.model.Customer;

public interface ICustomerService {

    String getCustomer(Customer customer);

    String saveCsvData();
}
