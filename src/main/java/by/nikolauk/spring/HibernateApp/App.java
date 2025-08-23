package by.nikolauk.spring.HibernateApp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import by.nikolauk.spring.model.Actor;
import by.nikolauk.spring.model.Movie;

public class App {

	public static void main(String[] args) {
		Configuration configuration = new Configuration().addAnnotatedClass(Actor.class).addAnnotatedClass(Movie.class);

		SessionFactory sessionFactory = configuration.buildSessionFactory();

		// try with resources (try с ресурсами)
		try (sessionFactory) {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();

			// Удаляем актера из фильма
			Actor actor = session.find(Actor.class, 5);
			System.out.println(actor.getMovies());

			Movie movieToRemove = actor.getMovies().get(0);

			actor.getMovies().remove(0);
			movieToRemove.getActors().remove(actor);

			// Добавляем филь и актера
			// Movie movie = new Movie("Reservoir Dogs", 1992);
			// movie.setActors(new ArrayList<>(Collections.singletonList(actor)));
			// actor.getMovies().add(movie);
			// session.persist(movie);

			// Получаем фильм по актеру
			// Actor actor = session.find(Actor.class, 5);
			// System.out.println(actor.getMovies());

			// Получаем актеров из фильма
			// Movie movie = session.get(Movie.class, 4);
			// System.out.println(movie.getActors());

			// Создаем фильм и актеров
			// Movie movie = new Movie("Pulp fiction", 1994);
			// Actor actor1 = new Actor("Harvey Keitel", 81);
			// Actor actor2 = new Actor("Samuel L. Jackson", 72);

			// movie.setActors(new ArrayList<>(List.of(actor1, actor2)));

			// actor1.setMovies(new ArrayList<>(Collections.singletonList(movie)));
			// actor2.setMovies(new ArrayList<>(Collections.singletonList(movie)));

			// session.persist(movie);

			// session.persist(actor1);
			// session.persist(actor2);

			session.getTransaction().commit();
		}
	}
}
