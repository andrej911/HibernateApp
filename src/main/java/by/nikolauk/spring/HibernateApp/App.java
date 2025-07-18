package by.nikolauk.spring.HibernateApp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import by.nikolauk.spring.model.Person;

public class App {
	public static void main(String[] args) {
		Configuration configuration = new Configuration().addAnnotatedClass(Person.class);

		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();

		try {
			session.beginTransaction();

			Person person1 = new Person("Test1", 25);
			Person person2 = new Person("Test1", 35);
			Person person3 = new Person("Test1", 45);

			session.persist(person1);
			session.persist(person2);
			session.persist(person3);

			session.getTransaction().commit();

		} finally {
			sessionFactory.close();
		}
	}
}
