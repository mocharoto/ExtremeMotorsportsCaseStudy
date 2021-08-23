package org.perscholas.extrememotorsports.dao;

import org.perscholas.extrememotorsports.models.Customer;
import org.perscholas.extrememotorsports.models.Vehicles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface iCustomerRepo extends JpaRepository<Customer, Integer> {
    Customer getCustomerById(Integer customerId);
    Customer getCustomerByEmail(String customerEmail);
    List<Customer> findAllCustomers();
    List<Vehicles> getCustomerVehicleList();
    void deleteCustomerById(Integer customerId);
    void deleteCustomerByEmail(String customerEmail);
}
