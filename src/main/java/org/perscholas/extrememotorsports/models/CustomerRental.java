package org.perscholas.extrememotorsports.models;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerRental {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer customerRentalId;

    @FutureOrPresent
    @NotNull
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    LocalDate rentalDate;

    @FutureOrPresent
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    LocalDate returnDate;

    long mileage;

    @ManyToOne
    @NotNull(message = "Customer cannot be null")
    Customer carRenter;

    @ManyToMany
    @NotNull(message = "Car cannot be null")
    List<Vehicles> vehiclesList;


}
