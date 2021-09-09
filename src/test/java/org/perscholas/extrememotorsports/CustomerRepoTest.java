//package org.perscholas.extrememotorsports;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.perscholas.extrememotorsports.dao.iCustomerRepo;
//import org.perscholas.extrememotorsports.models.Customer;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import static org.junit.Assert.assertEquals;
//
//@RunWith(SpringRunner.class)
//@DataJpaTest
//public class CustomerRepoTest {
//    @Autowired
//    iCustomerRepo customerRepo;
//
//    @Test
//    public void testRepository() {
//        Customer expectedCustomer = new Customer();
//        expectedCustomer.setCustomerUsername("testCustomer");
//        expectedCustomer.setCustomerName("Customer");
//        expectedCustomer.setCustomerEmail("customer@email.com");
//        expectedCustomer.setCustomerAddress("123 W Awesome St Awesome, ST 90210");
//        expectedCustomer.setPassword("1234");
//        expectedCustomer.setCustomerPhoneNumber("123-456-7890");
//        expectedCustomer.setCustomerStatus(true);
//        expectedCustomer.setRentedVehicles(null);
//
//        Customer actualCustomer = customerRepo.getById(2);
//        assertEquals(expectedCustomer, actualCustomer);
//
//    }
//}
