package com.example.backend_gym.controllers;
import com.example.backend_gym.models.Disponibilite;
import com.example.backend_gym.repositories.DisponibiliteRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/disponibilite")
public class DisponibiliteController {
    @Autowired
    private DisponibiliteRepositories disponibiliteRepositories;

    @PostMapping("/add")
    public Disponibilite addDisponibilite(@RequestBody Disponibilite disponibilite) {
        return disponibiliteRepositories.save(disponibilite);
    }

    @GetMapping("/{id}")
    public Disponibilite getDisponibiliteById(@PathVariable Long id) {
        return disponibiliteRepositories.findById(id).orElse(null);
    }

    @PutMapping("/update/{id}")
    public Disponibilite updateDisponibilite(@PathVariable Long id, @RequestBody Disponibilite updatedDisponibilite) {
        return disponibiliteRepositories.findById(id)
                .map(disponibilite -> {
                    disponibilite.setDayOfWeek(updatedDisponibilite.getDayOfWeek());
                    disponibilite.setStartTime(updatedDisponibilite.getStartTime());
                    disponibilite.setEndTime(updatedDisponibilite.getEndTime());
                    return disponibiliteRepositories.save(disponibilite);
                })
                .orElse(null);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteDisponibilite(@PathVariable Long id) {
        disponibiliteRepositories.deleteById(id);
    }   

}
