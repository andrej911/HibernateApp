package by.nikolauk.spring.model;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Movie")
public class Movie {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "year_of_production")
	private int year_of_production;

	@ManyToMany(mappedBy = "movies")
	private List<Actor> actors;

	public Movie() {

	}

	public Movie(String name, int year_of_production) {
		this.name = name;
		this.year_of_production = year_of_production;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYear_of_production() {
		return year_of_production;
	}

	public void setYear_of_production(int year_of_production) {
		this.year_of_production = year_of_production;
	}

	public List<Actor> getActors() {
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, year_of_production);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		return id == other.id && Objects.equals(name, other.name) && year_of_production == other.year_of_production;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", name=" + name + ", year_of_production=" + year_of_production + "]";
	}
}
