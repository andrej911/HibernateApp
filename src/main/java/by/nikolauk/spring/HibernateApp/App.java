package by.nikolauk.spring.HibernateApp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import by.nikolauk.spring.model.Item;
import by.nikolauk.spring.model.Person1;

public class App {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Configuration configuration = new Configuration().addAnnotatedClass(Person1.class)
				.addAnnotatedClass(Item.class);

		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();

		try {
			session.beginTransaction();

			Person1 person = new Person1("Test cascading", 30);

			person.addItem(new Item("Item1"));
			person.addItem(new Item("Item2"));
			person.addItem(new Item("Item3"));

			session.persist(person);

			session.getTransaction().commit();

		} finally {
			sessionFactory.close();
		}
	}
}
