package by.nikolauk.spring.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Passport")
public class Passport {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "passport_number")
	private int passportNumber;

	@OneToOne
	@JoinColumn(name = "person_id", referencedColumnName = "id")
	private Person2 person;

	public Passport() {

	}

	public Passport(int passportNumber) {
		this.passportNumber = passportNumber;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Person2 getPerson() {
		return person;
	}

	public void setPerson(Person2 person) {
		this.person = person;
	}

	public int getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(int passportNumber) {
		this.passportNumber = passportNumber;
	}

	@Override
	public String toString() {
		return "Passport [person=" + person + ", passportNumber=" + passportNumber + "]";
	}
}
