package org.perscholas.extrememotorsports.services;

import lombok.extern.slf4j.Slf4j;
import org.perscholas.extrememotorsports.dao.iCustomerRepo;
import org.perscholas.extrememotorsports.exceptions.CustomerNotFoundException;
import org.perscholas.extrememotorsports.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Slf4j
public class CustomerServices {
    iCustomerRepo customerRepo;
    @Autowired
    public CustomerServices(iCustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    public Customer save(Customer customer) {
        return customerRepo.save(customer);
    }

    public Optional<Customer> getCustomerById(Integer customerId) {
        Optional<Customer> customer = customerRepo.findById(customerId);
        log.warn(customer.toString());

        return customer;
    }

    public List<Customer> getAllCustomers() {
        return customerRepo.findAll();
    }

}
