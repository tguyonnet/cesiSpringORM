package fr.cesi.dao;

import fr.cesi.beans.pokemon.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainerDAO extends JpaRepository<Trainer, Integer> {

}
