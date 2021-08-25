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
        customerRepo.save(new Customer(2, "testCustomer", "Customer", "customer@email.com", "1234", "123-456-7890", "123 W Awesome St Awesome, ST 90210", true, null));

        vehicleRepo.save(new Vehicles(1, "Yamaha", "YZ450FX", "Dirt Bike", "2020",  0, "Available",true));
        vehicleRepo.save(new Vehicles(2, "Yamaha", "YZ450F", "Dirt Bike", "2019",  0, "Available",true));
        vehicleRepo.save(new Vehicles(3, "Ski-Doo", "MXZ Sport Rotax 600 EFI", "Jet Ski", "2021",  0, "Available",true));
        vehicleRepo.save(new Vehicles(4, "Ski-Doo", "MXZ TNT Rotax 850 E-TEC Ripsaw", "Jet Ski", "2021", 0, "Available", true));
        vehicleRepo.save(new Vehicles(5, "Yamaha", "Smax", "Scooter", "2020", 0, "Available",true));
        vehicleRepo.save(new Vehicles(6, "Yamaha", "Bolt R-Spec", "Motorcycle", "2019", 0, "Available",true));
        vehicleRepo.save(new Vehicles(7, "Yamaha", "MT-07", "Motorcycle", "2019", 0, "Available",true));
        vehicleRepo.save(new Vehicles(8, "Razor", "Dune Buggy", "Dune Buggy", "?", 0, "Available",true));
        vehicleRepo.save(new Vehicles(9, "Rimo", "Alpha", "Go Kart", "2008", 0, "Available",true));
        vehicleRepo.save(new Vehicles(10, "Hammerhead", "Off-Road Mudhead", "Dune Buggy", "2021", 0, "Available",true));




    }
}
