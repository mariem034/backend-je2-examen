package com.example.backend_gym.models;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
import jakarta.persistence.OneToMany;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Coach extends AppUser {

    private String specialty; // ex : Yoga, Cardio, Musculation
    private String phoneNumber;
    private String Experience; // ex : 5 years

    @OneToMany(mappedBy = "coach")
    private List<Disponibilite> disponibilite; // ex : "Monday to Friday, 9am-5pm"

}
