package org.perscholas.extrememotorsports.security;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.perscholas.extrememotorsports.dao.iAuthGroupRepo;
import org.perscholas.extrememotorsports.dao.iCustomerRepo;
import org.perscholas.extrememotorsports.models.AuthGroup;
import org.perscholas.extrememotorsports.models.Customer;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AppCustomerDetailsService implements UserDetailsService {
    iCustomerRepo customerRepo;
    iAuthGroupRepo authGroupRepo;

    public AppCustomerDetailsService(iCustomerRepo customerRepo, iAuthGroupRepo authGroupRepo) {
        this.customerRepo = customerRepo;
        this.authGroupRepo = authGroupRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        Optional<Customer> customer = customerRepo.findByCustomerUsername(s);
        if(customer.isEmpty()) {
            throw new UsernameNotFoundException("No customer " + s);
        }
        List<AuthGroup> authGroups = authGroupRepo.findByCustomerId(customer.get().getCustomerId());
        log.warn(authGroups.toString());
        return new AppUserPrincipal(customer.get(), authGroups);
    }
}
