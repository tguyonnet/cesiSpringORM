package fr.cesi.main;

import fr.cesi.beans.Film;
import fr.cesi.service.GestionFilm;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("ApplicationContext.xml");
        GestionFilm gf = context.getBean("gestionFilm", GestionFilm.class);
        System.out.println(gf.listerTousLesFilms());
        Film f = new Film();
        f.setTitre("La reine des neiges");
        gf.ajout(f);
        System.out.println(gf.listerTousLesFilms());
    }
}
