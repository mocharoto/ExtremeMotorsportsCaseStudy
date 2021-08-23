package org.perscholas.extrememotorsports.dao;

import org.perscholas.extrememotorsports.models.Customer;
import org.perscholas.extrememotorsports.models.CustomerRental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface iCustomerRentalRepo extends JpaRepository<CustomerRental, Integer> {
    List<CustomerRental> findAllRentals();
    List<CustomerRental> findCustomerRentalByCustomer(Customer customer);
}
