package fr.cesi.dao;

import fr.cesi.beans.pokemon.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonDAO extends JpaRepository<Pokemon, Integer> {

}
