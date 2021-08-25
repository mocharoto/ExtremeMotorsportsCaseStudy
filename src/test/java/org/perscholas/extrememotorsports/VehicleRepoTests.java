package org.perscholas.extrememotorsports;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.perscholas.extrememotorsports.dao.iVehicleRepo;
import org.perscholas.extrememotorsports.models.Vehicles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class VehicleRepoTests {
    @Autowired
    iVehicleRepo vehicleRepo;

    @Test
    public void testRepository() {
        Vehicles expectedVehicle = new Vehicles();
        expectedVehicle.setVehicleId(3);
        expectedVehicle.setVehicleMake("Ski-Doo");
        expectedVehicle.setVehicleModel("MXZ Sport Rotax 600 EFI");
        expectedVehicle.setVehicleType("Jet-Ski");
        expectedVehicle.setVehicleYear("2021");
        expectedVehicle.setVehicleMileage(0);
        expectedVehicle.setVehicleAvailability("Available");
        expectedVehicle.setVehicleStatus(true);

        Vehicles actualVehicle = vehicleRepo.getById(3);
        assertEquals(expectedVehicle, actualVehicle);
    }
}
