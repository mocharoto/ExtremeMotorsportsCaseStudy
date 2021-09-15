package org.perscholas.extrememotorsports.security;

import lombok.extern.slf4j.Slf4j;
import org.perscholas.extrememotorsports.models.AuthGroup;
import org.perscholas.extrememotorsports.models.Customer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@Slf4j
public class AppUserPrincipal implements UserDetails {

    private Customer customer;
    private List<AuthGroup> authGroups;

    public AppUserPrincipal(Customer customer, List<AuthGroup> authGroups) {
        this.customer = customer;
        this.authGroups = authGroups;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        if(null == authGroups) {
            return Collections.emptySet();
        }
        Set<SimpleGrantedAuthority> grantedAuthorities = new HashSet<>();
        authGroups.forEach(authGroup -> grantedAuthorities.add(new SimpleGrantedAuthority(authGroup.getAuthGroup())));
        return grantedAuthorities;
    }

    @Override
    public String getPassword() { return customer.getPassword(); }

    @Override
    public String getUsername() { return customer.getCustomerUsername(); }

    @Override
    public boolean isAccountNonExpired() { return true; }

    @Override
    public boolean isAccountNonLocked() { return true; }

    @Override
    public boolean isCredentialsNonExpired() { return true; }

    @Override
    public boolean isEnabled() { return true; }
}
