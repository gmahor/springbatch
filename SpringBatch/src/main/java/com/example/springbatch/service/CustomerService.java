package com.example.springbatch.service;

import com.example.springbatch.model.Customer;
import com.example.springbatch.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@AllArgsConstructor
@Service
public class CustomerService implements ICustomerService {

    private final CustomerRepository customerRepository;

    private final JobLauncher jobLauncher;

    private final Job job;

    @Override
    public String getCustomer(Customer customer) {
        List<Customer> cus = customerRepository.findByUsername(customer.getUsername());
        if (!cus.isEmpty() && cus.get(0).getPassword().equals(customer.getPassword())) {
            return "Success";
        }
        return "Failed";
    }

    @Override
    public String saveCsvData() {
        try {
            JobParameters jobParameters = new JobParametersBuilder()
                    .addLong("StartAt: ", System.currentTimeMillis())
                    .toJobParameters();
            JobExecution execute = jobLauncher.run(job, jobParameters);
            if (ExitStatus.COMPLETED.equals(execute.getExitStatus())) {
                return "Successfully Data Saved!";
            }
        } catch (Exception e) {
            log.error("Error while saving csv Data ", e);
        }
        return "Failed";
    }
}
