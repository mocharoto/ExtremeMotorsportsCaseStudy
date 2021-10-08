package org.perscholas.extrememotorsports.controllers;

import lombok.extern.slf4j.Slf4j;
import org.perscholas.extrememotorsports.models.Customer;
import org.perscholas.extrememotorsports.models.Vehicles;
import org.perscholas.extrememotorsports.services.VehicleServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@Slf4j
public class VehicleController {
    private VehicleServices vehicleServices;

    @Autowired
    public VehicleController(VehicleServices vehicleServices) {
        this.vehicleServices = vehicleServices;
    }

    @GetMapping("vehicles")
    public String getVehicles(Model model) {
        List<Vehicles> vehicles = vehicleServices.getAllVehicles();
        log.warn("Number of Vehicles: " + vehicles.size());
        model.addAttribute("vehicles", vehicles);
        return "vehicles";
    }

    @GetMapping("vehicleregistration")
    public String getVehicleRegistration(Model model) {
        model.addAttribute("vehicle", new Vehicles());
        return "vehicleregistration";
    }

    @PostMapping("vehicleregistration")
    public String vehicleRegistration(@ModelAttribute("vehicle") Vehicles vehicle) {
        vehicle.setVehicleStatus(true);
        vehicle.setVehicleAvailability("Available");
        vehicleServices.save(vehicle);
        return "redirect:/vehicles";
    }

//    @PostMapping("vehicles")
//    public String rentVehicle(@RequestParam("customerid") Integer customerId, @RequestParam("vehicleid") Integer vehicleId, Model model) {
//        if(!vehicleServices.checkIfVehicleIsAvailable(vehicleId)) {
//            return "error";
//        } else {
//            Customer currentCustomer = vehicleServices.rentVehicleToCustomer(customerId, vehicleId);
//            List<Vehicles> vehiclesList = currentCustomer.getRentedVehicles();
//            model.addAttribute("currentCustomer", currentCustomer);
//            model.addAttribute("vehicleList", vehiclesList);
//            return "rentedvehicleslist";
//        }
//    }
    //Show Customer's rented vehicles
//    @GetMapping("/rentedvehicles")
//    public String rentedVehicles(Model model) {
//
//    }
//    TODO: Finish vehicle rental logic
    @PostMapping("vehicles/rent")
    public String vehicleList(@RequestParam("customerId") String customerId, @RequestParam("vehicleId") String vehicleId, Model model) {
        Integer vId = Integer.valueOf(vehicleId);
        Integer cId = Integer.valueOf(customerId);
        if (!vehicleServices.checkIfVehicleIsAvailable(vId)) {
            return "vehicles";
        } else {
            Customer customer = vehicleServices.rentVehicleToCustomer(cId, vId);
            log.warn(String.valueOf(customerId));
            log.warn(String.valueOf(vehicleId));
            List<Vehicles> customerVehicles = customer.getRentedVehicles();
            model.addAttribute("customer", customer);
            model.addAttribute("vehicles", customerVehicles);
            return "rentedvehicleslist";
        }
    }
//    @GetMapping("/vehicles/rent_vehicle")
//    public String rentVehicle(@PathVariable("vehicleId") Integer vehicleId, Model model) {
//            Optional<Vehicles> vehicles = vehicleServices.getVehicleById(vehicleId);
//            model.addAttribute("vehicles", vehicles);
//            return "rentedvehicleslist";
//
//
//
//    }
}
