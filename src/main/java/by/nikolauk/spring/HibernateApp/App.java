package by.nikolauk.spring.HibernateApp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import by.nikolauk.spring.model.Passport;
import by.nikolauk.spring.model.Person2;

public class App {

	public static void main(String[] args) {
		Configuration configuration = new Configuration().addAnnotatedClass(Person2.class)
				.addAnnotatedClass(Passport.class);

		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();

		try {
			session.beginTransaction();

			// Создаем человека и паспорт
			Person2 person = new Person2("Test person4", 39);
			Passport passport = new Passport(6520123);
			person.setPassport(passport);
			session.persist(person);

			// Получаем номер паспорта
			// Person2 person = session.find(Person2.class, 2);
			// System.out.println(person.getPassport().getPassportNumber());

			// Получаем имя человека
			// Passport passport = session.find(Passport.class, 2);
			// System.out.println(passport.getPerson().getName());

			// Изменяем номер пасспорта
			// Person2 person = session.find(Person2.class, 3);
			// person.getPassport().setPassportNumber(777779);

			// Удаляем человека
			// Person2 person = session.find(Person2.class, 2);
			// session.remove(person);

			session.getTransaction().commit();

		} finally {
			sessionFactory.close();
		}
	}
}
