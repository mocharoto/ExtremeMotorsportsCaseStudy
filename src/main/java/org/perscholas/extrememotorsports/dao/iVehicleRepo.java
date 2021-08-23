package org.perscholas.extrememotorsports.dao;

import org.perscholas.extrememotorsports.models.Vehicles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface iVehicleRepo extends JpaRepository<Vehicles, Integer>{
    Vehicles getVehiclesById(Integer vehicleId);
    List<Vehicles> getAllVehicles();


}
