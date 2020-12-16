package fr.cesi.service;

import fr.cesi.beans.pokemon.Trainer;
import fr.cesi.dao.TrainerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service(value = "gestionTrainer")
public class GestionTrainer {

    @Autowired
    TrainerDAO dao;

    @PersistenceContext
    private EntityManager em;

    public List<Trainer> findAll() {
        return dao.findAll();
    }

    public void add(Trainer trainer) {
        dao.save(trainer);
    }
}
