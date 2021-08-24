package org.perscholas.extrememotorsports.controllers;

import lombok.extern.slf4j.Slf4j;
import org.perscholas.extrememotorsports.models.Customer;
import org.perscholas.extrememotorsports.services.CustomerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/customer")
public class CustomerController {
    private CustomerServices customerService;

    @Autowired
    public CustomerController(CustomerServices customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/createdCustomer")
    public String showCustomerData(@ModelAttribute("customer")Customer customer, Model model) {
        log.warn("Post Request!");
        Customer createdCustomer = customerService.saveCustomer(customer);
        log.warn(createdCustomer.toString());
        model.addAttribute("createdCustomer", createdCustomer);
        return "created-customer";
    }

    @GetMapping("/registeredCustomer")
    public String registerCustomer(Model model) {
        model.addAttribute("customer", new Customer());
        return "registered-customer";
    }
}
