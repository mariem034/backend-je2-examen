package com.example.backend_gym.models;

import java.time.LocalDate;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member extends AppUser {
   
    private LocalDate birthDate;
    private String phoneNumber;
    // default inactive
    private String membershipStatus="INACTIVE"; // ex: ACTIVE, EXPIRED

    @ManyToOne
    private Subscription subscription;

}
