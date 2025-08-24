package by.nikolauk.spring.HibernateApp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.hibernate.Hibernate;
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

		try {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();

			// Получаем человека
			Person1 person = session.find(Person1.class, 1);
			System.out.println("Get person");
			// System.out.println(person);

			// System.out.println(person.getItems());
			// Hibernate.initialize(person.getItems()); //Подгружаем связанные ленивые
			// сущности

			// Получаем товар
			// Item item = session.find(Item.class, 1);
			// System.out.println("Get item");

			// Получим связанные сущности
			// System.out.println(person.getItems());

			session.getTransaction().commit();
			System.out.println("session.close");

			// Открываем сессию и транзакцию еще раз(в любом другом месте в коде)
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();

			System.out.println("inside 2 transactions");

			person = (Person1) session.merge(person);
			Hibernate.initialize(person.getItems());

			System.out.println("Outside the 2 session");

			// Можно получать товары вне сессии
			// это работает, так как как связанные товары были загружжены
			System.out.println(person.getItems());

		} finally {
			sessionFactory.close();
		}
	}
}
