package org.perscholas.extrememotorsports.services;

import lombok.extern.slf4j.Slf4j;
import org.perscholas.extrememotorsports.dao.iCustomerRepo;
import org.perscholas.extrememotorsports.dao.iVehicleRepo;
import org.perscholas.extrememotorsports.models.Customer;
import org.perscholas.extrememotorsports.models.Vehicles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Slf4j
public class VehicleServices {
    iVehicleRepo vehicleRepo;
    iCustomerRepo customerRepo;
    @Autowired
    public VehicleServices(iVehicleRepo vehicleRepo, iCustomerRepo customerRepo) {
        this.vehicleRepo = vehicleRepo;
        this.customerRepo = customerRepo;
    }

    public Vehicles save(Vehicles vehicle) {
        return vehicleRepo.save(vehicle);
    }

    public Optional<Vehicles> getVehicleById(Integer vehicleId) {
        Optional<Vehicles> vehicle = vehicleRepo.findById(vehicleId);
        log.warn(vehicle.toString());
        return vehicle;
    }

    public List<Vehicles> getAllVehicles() {
        return vehicleRepo.findAll();
    }

    public boolean checkIfVehicleIsAvailable(Integer vehicleId) {
        Vehicles checkVehicle = vehicleRepo.findByVehicleId(vehicleId);
        return checkVehicle.getVehicleAvailability().equals("Available");
    }

    public Customer rentVehicleToCustomer(Integer customerId, Integer vehicleId) {
        log.warn(String.valueOf(customerId));
        log.warn(String.valueOf(vehicleId));
        Customer currentCustomer = customerRepo.getById(customerId);
        Vehicles desiredVehicle = vehicleRepo.getById(vehicleId);


        List<Vehicles> currentVehicles = currentCustomer.getRentedVehicles();

        currentVehicles.add(desiredVehicle);
        currentCustomer.setRentedVehicles(currentVehicles);

        desiredVehicle.setVehicleAvailability("Unavailable");
        Customer updatedCustomer = customerRepo.save(currentCustomer);
        vehicleRepo.save(desiredVehicle);

        return updatedCustomer;
    }
}
