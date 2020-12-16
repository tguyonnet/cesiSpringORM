package fr.cesi.dao;

import fr.cesi.beans.Film;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FilmDAO extends JpaRepository<Film, Integer> {
    List<Film> findByTitre(String titre);
}
