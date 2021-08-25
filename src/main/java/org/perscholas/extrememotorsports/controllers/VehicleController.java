package org.perscholas.extrememotorsports.controllers;

import lombok.extern.slf4j.Slf4j;
import org.perscholas.extrememotorsports.models.Customer;
import org.perscholas.extrememotorsports.models.Vehicles;
import org.perscholas.extrememotorsports.services.VehicleServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

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
        vehicleServices.save(vehicle);
        return "redirect:/vehicles";
    }

    @PostMapping("vehicles")
    public String rentVehicle(@RequestParam("customerid") Integer customerId, @RequestParam("vehicleid") Integer vehicleId, Model model) {
        if(vehicleServices.checkIfVehicleIsAvailable(vehicleId) == false) {
            return "error";
        } else {
            Customer currentCustomer = vehicleServices.rentVehicleToCustomer(customerId, vehicleId);
            List<Vehicles> vehiclesList = currentCustomer.getRentedVehicles();
            model.addAttribute("currentCustomer", currentCustomer);
            model.addAttribute("vehicleList", vehiclesList);
            return "rentedvehicleslist";
        }
    }
}
