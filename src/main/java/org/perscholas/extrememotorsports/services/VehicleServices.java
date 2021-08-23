package org.perscholas.extrememotorsports.services;

import lombok.extern.slf4j.Slf4j;
import org.perscholas.extrememotorsports.dao.iVehicleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@Slf4j
public class VehicleServices {
    iVehicleRepo vehicleRepo;
    @Autowired
    public VehicleServices(iVehicleRepo vehicleRepo) {

    }
}
