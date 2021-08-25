package org.perscholas.extrememotorsports;

import lombok.extern.slf4j.Slf4j;
import org.perscholas.extrememotorsports.dao.iCustomerRepo;
import org.perscholas.extrememotorsports.dao.iVehicleRepo;
import org.perscholas.extrememotorsports.models.Customer;
import org.perscholas.extrememotorsports.models.Vehicles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Slf4j
@Component
@Transactional
public class AppRunner implements CommandLineRunner {
    private iCustomerRepo customerRepo;
    private iVehicleRepo vehicleRepo;

    @Autowired
    public AppRunner(iCustomerRepo customerRepo, iVehicleRepo vehicleRepo) {
        this.customerRepo = customerRepo;
        this.vehicleRepo = vehicleRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        customerRepo.save(new Customer(1, "asdf", "asdf", "asdf@asdf.com", "123asdf", "12345667", "asdf w sadf ave", true, null));

        vehicleRepo.save(new Vehicles(1, "Yamaha", "YZ450FX", "Dirt Bike", "2020", 0, true));
        vehicleRepo.save(new Vehicles(2, "Yamaha", "YZ450F", "Dirt Bike", "2019", 0, true));
        vehicleRepo.save(new Vehicles(3, "Ski-Doo", "MXZ Sport Rotax 600 EFI", "Jet Ski", "2021", 0, true));
        vehicleRepo.save(new Vehicles(4, "Ski-Doo", "MXZ TNT Rotax 850 E-TEC Ripsaw", "Jet Ski", "2021", 0, true));
        vehicleRepo.save(new Vehicles(5, "Yamaha", "Smax", "Scooter", "2020", 0, true));



    }
}
