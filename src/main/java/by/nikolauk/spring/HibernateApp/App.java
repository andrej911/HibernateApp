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

			// Получаем товары одного человака
			// Person1 person = session.find(Person1.class, 3);
			// System.out.println(person);
			// List<Item> items = person.getItems();
			// System.out.println(items);

			// Получаем владельца товара
			// Item item = session.find(Item.class, 5);
			// System.out.println(item);
			// Person1 person = item.getOwner();
			// System.out.println(person);

			// Добовляем товар
			// Person1 person = session.find(Person1.class, 2);
			// Item newItem = new Item("Item from Hibernate", person);
			// person.getItems().add(newItem); // Для актуального кэша
			// session.persist(newItem);

			// Добовляем человека
			// Person1 person = new Person1("Test person", 30);
			// Item newItem = new Item("Item from Hibernate2", person);
			// person.setItems(new ArrayList<>(Collections.singletonList(newItem)));
			// session.persist(person);
			// session.persist(newItem);

			// Удаляем товар у человека
			// Person1 person = session.find(Person1.class, 3);
			// List<Item> items = person.getItems();
			// SQL
			// for (Item item : items)
			// session.remove(item);
			// Не пораждает SQL, но необходимо для того, чтобы в кэше все было верно
			// person.getItems().clear();

			// Удаляем человека
			//Person1 person = session.find(Person1.class, 2);
			// SQL
			//session.remove(person);
			// Для правильного состояния Hibernate кэша
			//	person.getItems().forEach(i -> i.setOwner(null));
			
			// Меняем владельца товара
			Person1 person = session.find(Person1.class, 4);
			Item item = session.find(Item.class, 1);
			
			item.getOwner().getItems().remove(item);
			
			//SQL
			item.setOwner(person);
			
			person.getItems().add(item);

			session.getTransaction().commit();

		} finally {
			sessionFactory.close();
		}
	}
}
