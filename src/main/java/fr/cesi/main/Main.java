package fr.cesi.main;

import fr.cesi.beans.pokemon.Attack;
import fr.cesi.beans.pokemon.Pokemon;
import fr.cesi.beans.pokemon.Trainer;
import fr.cesi.service.GestionAttack;
import fr.cesi.service.GestionPokemon;
import fr.cesi.service.GestionTrainer;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    static ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");

    public static void main(String[] args) {

        // Dresseurs
        Trainer trainer01 = new Trainer("GUYONNET", "Theo1");
        Trainer trainer02 = new Trainer("GUYONNET", "Theo2");
        GestionTrainer gestionTrainer = context.getBean("gestionTrainer", GestionTrainer.class);
        gestionTrainer.add(trainer01);
        gestionTrainer.add(trainer02);

        // Attaques
        Attack att01 = new Attack("statik", 17);
        Attack att02 = new Attack("paratonnerre", 30);
        GestionAttack gestionAttack = context.getBean("gestionAttack", GestionAttack.class);
        gestionAttack.add(att01);
        gestionAttack.add(att02);

        // Pokemons
        GestionPokemon gestionPokemon = context.getBean("gestionPokemon", GestionPokemon.class);
        gestionPokemon.add(new Pokemon("Pikachu", 25,  1, trainer01, att01, att02));
        gestionPokemon.add(new Pokemon("Gros Piakachu", 25,  5, trainer02, att01, att02));
    }
}
