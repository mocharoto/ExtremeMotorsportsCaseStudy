package org.perscholas.extrememotorsports.controllers;

import lombok.extern.slf4j.Slf4j;
import org.perscholas.extrememotorsports.models.Customer;
import org.perscholas.extrememotorsports.services.CustomerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@Slf4j
@SessionAttributes({"currentCustomer"})
public class CustomerController {
    private CustomerServices customerService;

    @Autowired
    public CustomerController(CustomerServices customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public String getCustomers(Model model) {
        List<Customer> customers = customerService.getAllCustomers();
        log.warn("Number of customers: " + customers.size());
        model.addAttribute("customers", customers);
        return "customers";
    }

    @GetMapping("/customerregistration")
    public String getCustomerRegistration(Model model) {
        model.addAttribute("customer", new Customer());
        return "customerregistration";
    }

    @GetMapping("/customerlogin")
    public String customerLogin(Model model) {
        log.warn("Login");
        model.addAttribute("currentCustomer", new Customer());
        return "login";
    }

    @PostMapping("/customerlogin")
    public String customerLoginComplete(Model model, @ModelAttribute("currentCustomer") @Valid Customer currCustomer, BindingResult bindingResult) {
        log.warn("Login complete");

        return "login";
    }
}
