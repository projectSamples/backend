package com.springboot.h2.model;

import javax.persistence.Entity;
import javax.persistence.Id;

// @Entity annotation specifies that the class is mapped to a database table.
@Entity
public class Projects {

	// @Id annotation specifies the primary key of an entity.
	// @GeneratedValue provides the generation strategy specification for the primary key values.
	@Id
	private int id;
	private String name;

	// Default constructor.
	public Projects() {	}

	// Parameterized constructor.
	public Projects(int id, String name) {
		this.id = id;
		this.name = name;
	}

	// Getters.
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
}
