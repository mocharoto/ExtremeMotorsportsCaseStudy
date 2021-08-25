package org.perscholas.extrememotorsports.models;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@RequiredArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull(message = "ID can't be null")
    Integer customerId;
    @NotNull()
    @NonNull
    String customerUsername;
    @NotNull()
    @NonNull
    @NotBlank
    String customerName;
    @NotNull(message = "Email can't be null")
    @NonNull
    @Email(message = "Try adding a correct email", regexp = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")
    String customerEmail;
    @NotNull
    @NonNull
    String password;
    @NotNull
    @NonNull
    String customerPhoneNumber;
    @NotNull
    @NonNull
    String customerAddress;
    @NotNull
    @NonNull
    Boolean customerStatus;
    @OneToMany(cascade = CascadeType.ALL)
    List<Vehicles> rentedVehicles;

}
