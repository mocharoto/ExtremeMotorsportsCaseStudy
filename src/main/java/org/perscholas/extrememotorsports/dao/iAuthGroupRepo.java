package org.perscholas.extrememotorsports.dao;

import org.perscholas.extrememotorsports.models.AuthGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface iAuthGroupRepo extends JpaRepository<AuthGroup, Long> {
    List<AuthGroup> findByCustomerId(Integer customerId);
}
