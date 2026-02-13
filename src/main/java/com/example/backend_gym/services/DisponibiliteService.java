package com.example.backend_gym.services;
import org.springframework.stereotype.Service;
import com.example.backend_gym.models.Disponibilite;
import com.example.backend_gym.repositories.DisponibiliteRepositories;


@Service
public class DisponibiliteService {
    private final DisponibiliteRepositories disponibiliteRepositories;

    public DisponibiliteService(DisponibiliteRepositories disponibiliteRepositories) {
        this.disponibiliteRepositories = disponibiliteRepositories;
    }

    public Disponibilite addDisponibilite(Disponibilite disponibilite) {
        return disponibiliteRepositories.save(disponibilite);
    }

    public Disponibilite updateDisponibilite(Long id, Disponibilite updatedDisponibilite) {
        return disponibiliteRepositories.findById(id)
                .map(disponibilite -> {
                    disponibilite.setDayOfWeek(updatedDisponibilite.getDayOfWeek());
                    disponibilite.setStartTime(updatedDisponibilite.getStartTime());
                    disponibilite.setEndTime(updatedDisponibilite.getEndTime());
                    return disponibiliteRepositories.save(disponibilite);
                })
                .orElse(null);
    }

    public void deleteDisponibilite(Long id) {
        disponibiliteRepositories.deleteById(id);
    }

    public Disponibilite getDisponibiliteById(Long id) {
        return disponibiliteRepositories.findById(id).orElse(null);
    }



}
