package fr.cesi.service;

import fr.cesi.beans.Film;
import fr.cesi.dao.FilmDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service(value = "gestionFilm")
public class GestionFilm {
    @Autowired
    FilmDAO filmDAO;

    @PersistenceContext
    private EntityManager em;

    public List<Film> listerTousLesFilms() {
        // em.createQuery("SELECT f FROM Film f", Film.class);
        return filmDAO.findAll();
    }

    public void ajout(Film f) {
        filmDAO.save(f);
    }
}
