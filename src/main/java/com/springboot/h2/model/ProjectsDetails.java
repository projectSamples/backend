package com.springboot.h2.model;

import java.util.List;


public class ProjectsDetails {

	private int id;
	private String name;
	private List<Employee> employees;

	/**
	 * @return the employees
	 */
	public List<Employee> getEmployees() {
		return employees;
	}

	/**
	 * @param employees the employees to set
	 */
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	// Default constructor.
	public ProjectsDetails() {	}

	// Parameterized constructor.
	public ProjectsDetails(int id, String name, List<Employee> employees) {
		this.id = id;
		this.name = name;
		this.employees = employees;
	}

	// Getters.
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
}
