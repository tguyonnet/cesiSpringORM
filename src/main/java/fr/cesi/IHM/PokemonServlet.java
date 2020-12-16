package fr.cesi.IHM;

import fr.cesi.beans.pokemon.Pokemon;
import fr.cesi.beans.pokemon.Trainer;
import fr.cesi.beans.pokemon.Attack;
import fr.cesi.service.GestionPokemon;
import fr.cesi.service.GestionTrainer;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "PokemonServlet", urlPatterns = {"/PokemonServlet"})
public class PokemonServlet extends HttpServlet {
    int pokemonsIndex = 0;
    List<Pokemon> pokemons = new ArrayList<>();
    List<Trainer> trainers = new ArrayList<>();


    @Override
    public void init() throws ServletException {
        super.init();
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        GestionTrainer gestionTrainer = context.getBean("gestionTrainer", GestionTrainer.class);
        GestionPokemon gestionPokemon = context.getBean("gestionPokemon", GestionPokemon.class);
        trainers = gestionTrainer.findAll();
        pokemons = gestionPokemon.findAll();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String precedent = request.getParameter("precedent");
        String suivant = request.getParameter("suivant");

        if (precedent != null) {
            if (pokemonsIndex > 0) {
                pokemonsIndex--;
            } else {
                pokemonsIndex = pokemons.size()-1;
            }
        }
        if (suivant != null) {
            if (pokemonsIndex < pokemons.size()-1) {
                pokemonsIndex++;
            } else {
                pokemonsIndex = 0;
            }
        }

        request.setAttribute("dresseurs", trainers);
        request.setAttribute("currentPokemon", pokemons.get(pokemonsIndex));

        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/Pokemon.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Dresseurs
        request.setAttribute("trainers", trainers);

        // Pokemons
        request.setAttribute("pokemons", pokemons);

        request.setAttribute("currentPokemon", pokemons.get(pokemonsIndex));
        request.setAttribute("index", pokemonsIndex);

        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/Pokemon.jsp");
        rd.forward(request, response);
    }
}
