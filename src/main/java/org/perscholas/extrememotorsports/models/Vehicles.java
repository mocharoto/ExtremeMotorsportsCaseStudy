package org.perscholas.extrememotorsports.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Vehicles {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    Integer vehicleId;
    @NotNull
    String vehicleName;
    @NotNull
    Integer vehicleMileage;
    @NotNull
    Boolean vehicleStatus;
}
