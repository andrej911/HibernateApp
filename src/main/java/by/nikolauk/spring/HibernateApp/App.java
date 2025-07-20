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

			Person person = session.find(Person.class, 2);
			session.remove(person);

			session.getTransaction().commit();

		} finally {
			sessionFactory.close();
		}
	}
}
