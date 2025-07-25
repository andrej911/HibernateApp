package by.nikolauk.spring.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Item")
public class Item {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "item_name")
	private String itemName;

	@ManyToOne
	@JoinColumn(name = "person_id", referencedColumnName = "id")
	private Person1 owner;

	public Item() {

	}

	public Item(String itemName) {
		this.itemName = itemName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Person1 getOwner() {
		return owner;
	}

	public void setOwner(Person1 owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", itemName=" + itemName + "]";
	}
}
