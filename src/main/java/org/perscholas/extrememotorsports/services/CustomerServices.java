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

    public Customer getCustomerById(Integer customerId) {
        Customer customer = customerRepo.getById(customerId);
        log.warn(String.valueOf(customer));

        return customer;
    }


    public List<Customer> getAllCustomers() {
        List<Customer> customers = customerRepo.findAll();
        log.warn(String.valueOf(customers));
        return customers;
    }

    public Customer saveCustomer(Customer customer) {
        log.warn(customer.toString());
        Customer createdCustomer = customerRepo.save(customer);
        return createdCustomer;
    }

    public boolean validateCustomer(Customer customer) {
        Customer newCustomer = this.getCustomerById(customer.getCustomerId());
        if (newCustomer == null) {
            return false;
        }

        String customerPassword = newCustomer.getPassword();
        log.trace(customerPassword);
        log.trace(newCustomer.getPassword());
        log.trace(customer.getPassword());

        if(customerPassword.equals(customer.getPassword())) {
            log.trace("Customer password is equal");
            return true;
        } else {
            log.warn("Passwords do not match");
            return false;
        }
    }

    public Customer get(Integer id) throws CustomerNotFoundException {
        Optional<Customer> getCustomer = customerRepo.findById(id);
        if(getCustomer.isPresent()) {
            return getCustomer.get();
        }
        throw new CustomerNotFoundException("Could not find customer by Id " + id);

    }

    public void delete(Integer id) throws CustomerNotFoundException {
        Optional<Customer> getCustomer = customerRepo.findById(id);
        if(getCustomer.isPresent()) {
            customerRepo.deleteById(id);
        }
        throw new CustomerNotFoundException("Could not find customer by Id " + id);
    }

}
