package fr.cesi.service;

import fr.cesi.beans.pokemon.Attack;
import fr.cesi.dao.AttackDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service(value = "gestionAttack")
public class GestionAttack extends fr.cesi.service.Service {

    @Autowired
    AttackDAO dao;

    @PersistenceContext
    private EntityManager em;

    public GestionAttack getGestionAttack() {
        return this.getContext().getBean("gestionAttack", GestionAttack.class);
    }

    public List<Attack> findAll() {
        return dao.findAll();
    }

    public void add(Attack attack) {
        dao.save(attack);
    }

}
