package org.perscholas.extrememotorsports.services;

import lombok.extern.slf4j.Slf4j;
import org.perscholas.extrememotorsports.dao.iVehicleRepo;
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
    @Autowired
    public VehicleServices(iVehicleRepo vehicleRepo) {
        this.vehicleRepo = vehicleRepo;
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
}
