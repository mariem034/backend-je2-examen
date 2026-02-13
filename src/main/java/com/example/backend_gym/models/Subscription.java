package com.example.backend_gym.models;

import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.Data;
import java.util.List;
import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double price;
    private DurationType duration; // ex : "1 month", "1 year"
    private Boolean status; // ex : "ACTIVE", "EXPIRED"
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();
    // Relation avec membres
    @OneToMany(mappedBy = "subscription")
    private List<Member> members;


        public enum DurationType {
        SIX_MONTHS,
        ONE_YEAR
    }

}
