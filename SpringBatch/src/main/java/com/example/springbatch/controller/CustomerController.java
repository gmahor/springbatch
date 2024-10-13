package com.example.springbatch.controller;

import com.example.springbatch.model.Customer;
import com.example.springbatch.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class CustomerController {

    @Autowired
    ICustomerService customerService;

    @GetMapping("/login")
    @ResponseBody
    public String getCustomer(@RequestBody Customer customer) {
        return customerService.getCustomer(customer);
    }

    @PostMapping("/csvdataUpload")
    public String saveCsvData(){
        return customerService.saveCsvData();
    }
}
