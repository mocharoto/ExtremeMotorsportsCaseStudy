package org.perscholas.extrememotorsports.controllers;

import lombok.extern.slf4j.Slf4j;
import org.perscholas.extrememotorsports.dao.iAuthGroupRepo;
import org.perscholas.extrememotorsports.models.AuthGroup;
import org.perscholas.extrememotorsports.models.Customer;
import org.perscholas.extrememotorsports.services.CustomerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
    private iAuthGroupRepo authGroupRepo;

    @Autowired
    public CustomerController(CustomerServices customerService, iAuthGroupRepo authGroupRepo) {
        this.customerService = customerService;
        this.authGroupRepo = authGroupRepo;
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

//    @PostMapping("/customerregistration")
//    public String customerRegistration( @ModelAttribute("customer") Customer customer, BindingResult result, Model model) {
//        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
//
//        String password = customer.getPassword();
//        String hashedPassword = bCryptPasswordEncoder.encode(password);
//        log.warn(hashedPassword);
//        customer.setPassword(hashedPassword);
//        customer.setCustomerStatus(true);
//        if (result.hasErrors()) {
//            return "customerregistration";
//        }
//        customerService.save(customer);
//        return "redirect:/customers";
//
//    }

    @PostMapping("/customerregistration")
    public String customerRegistration( @Valid Customer customer, BindingResult result, Model model) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
        //hash password
        String password = customer.getPassword();
        String hashedPassword = bCryptPasswordEncoder.encode(password);
        log.warn(hashedPassword);
        customer.setPassword(hashedPassword);
        customer.setCustomerStatus(true);

        if (result.hasErrors()) {
            return "customerregistration";
        }
        customerService.save(customer);
        //Set role
        authGroupRepo.save(new AuthGroup(customer.getCustomerId(), "ROLE_CUSTOMER"));
        return "redirect:/customers";

    }

//    @GetMapping("/customerlogin")
//    public String customerLogin(Model model) {
//        log.warn("Login");
//        model.addAttribute("currentCustomer", new Customer());
//        return "login";
//    }
//
//    @PostMapping("/customerlogin")
//    public String customerLoginComplete(Model model, @ModelAttribute("currentCustomer") @Valid Customer currCustomer, BindingResult bindingResult) {
//        log.warn("Login complete");
//
//        return "login";
//    }
}
