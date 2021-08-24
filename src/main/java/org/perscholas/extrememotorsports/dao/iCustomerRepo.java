package org.perscholas.extrememotorsports.dao;

import org.perscholas.extrememotorsports.models.Customer;
import org.perscholas.extrememotorsports.models.Vehicles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface iCustomerRepo extends JpaRepository<Customer, Integer> {
//    Customer findByCustomerId(Integer customerId);
    Customer findByCustomerEmail(String customerEmail);
//    List<Vehicles> getCustomerrentedVehicles();
//    void deleteCustomerById(Integer customerId);
//    void deleteCustomerByEmail(String customerEmail);
}
