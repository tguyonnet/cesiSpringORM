package fr.cesi.dao;

import fr.cesi.beans.pokemon.Attack;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttackDAO extends JpaRepository<Attack, Integer> {

}
