package com.example.springbatch.service;

import com.example.springbatch.model.Customer;
import com.example.springbatch.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Slf4j
@Component
@AllArgsConstructor
public class CustomerItemWriter implements ItemWriter<Customer> {

    private final CustomerRepository repository;

    @Override
    public void write(List<? extends Customer> customers){
        try {
            log.info("Writer Thread - {}", Thread.currentThread().getName());
            repository.saveAll(customers);
        }catch (Exception e){
            log.error("Error while saving the customer list - ",e);
        }
    }
}