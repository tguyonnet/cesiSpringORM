package fr.cesi.service;

import fr.cesi.beans.pokemon.Pokemon;
import fr.cesi.dao.PokemonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service(value = "gestionPokemon")
public class GestionPokemon {
    @Autowired
    PokemonDAO dao;

    @PersistenceContext
    private EntityManager em;

    public List<Pokemon> findAll() {
        return dao.findAll();
    }

    public void add(Pokemon pokemon) {
        dao.save(pokemon);
    }
}
