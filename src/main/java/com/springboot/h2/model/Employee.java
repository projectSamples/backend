package com.springboot.h2.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// @Entity annotation specifies that the class is mapped to a database table.
@Entity
public class Employee {
	@Id
	private int id;
	private int empId;
	private String name;
	private int age;
	private String emailAddress;
	private String projectName;
	private int projectId;
	private Date startDate;
	private Date endDate;
	private int percentage;
	private String progress;
	private String vipCode;
	private String geId;
	private String codeValue;
	private String location;
	private String coloum1;
	private String coloum2;


	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}


	/**
	 * @return the empId
	 */
	public int getEmpId() {
		return empId;
	}


	/**
	 * @param empId the empId to set
	 */
	public void setEmpId(int empId) {
		this.empId = empId;
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}


	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}


	/**
	 * @return the emailAddress
	 */
	public String getEmailAddress() {
		return emailAddress;
	}


	/**
	 * @param emailAddress the emailAddress to set
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}


	/**
	 * @return the projectName
	 */
	public String getProjectName() {
		return projectName;
	}


	/**
	 * @param projectName the projectName to set
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}


	/**
	 * @return the projectId
	 */
	public int getProjectId() {
		return projectId;
	}


	/**
	 * @param projectId the projectId to set
	 */
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}


	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}


	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}


	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}


	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}


	/**
	 * @return the percentage
	 */
	public int getPercentage() {
		return percentage;
	}


	/**
	 * @param percentage the percentage to set
	 */
	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}


	/**
	 * @return the progress
	 */
	public String getProgress() {
		return progress;
	}


	/**
	 * @param progress the progress to set
	 */
	public void setProgress(String progress) {
		this.progress = progress;
	}


	/**
	 * @return the vipCode
	 */
	public String getVipCode() {
		return vipCode;
	}


	/**
	 * @param vipCode the vipCode to set
	 */
	public void setVipCode(String vipCode) {
		this.vipCode = vipCode;
	}


	/**
	 * @return the geId
	 */
	public String getGeId() {
		return geId;
	}


	/**
	 * @param geId the geId to set
	 */
	public void setGeId(String geId) {
		this.geId = geId;
	}


	/**
	 * @return the codeValue
	 */
	public String getCodeValue() {
		return codeValue;
	}


	/**
	 * @param codeValue the codeValue to set
	 */
	public void setCodeValue(String codeValue) {
		this.codeValue = codeValue;
	}


	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}


	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}


	/**
	 * @return the coloum1
	 */
	public String getColoum1() {
		return coloum1;
	}


	/**
	 * @param coloum1 the coloum1 to set
	 */
	public void setColoum1(String coloum1) {
		this.coloum1 = coloum1;
	}


	/**
	 * @return the coloum2
	 */
	public String getColoum2() {
		return coloum2;
	}


	/**
	 * @param coloum2 the coloum2 to set
	 */
	public void setColoum2(String coloum2) {
		this.coloum2 = coloum2;
	}

	public Employee() {}
	// Parameterized constructor.
	public Employee(int id, int empId, String name, int age, String emailAddress, String projectName, int projectId,
			Date startDate, Date endDate, int percentage, String progress, String vipCode, String geId,
			String codeValue, String location, String coloum1,  String coloum2) {
		super();
		this.id = id;
		this.empId = empId;
		this.name = name;
		this.age = age;
		this.emailAddress = emailAddress;
		this.projectName = projectName;
		this.projectId = projectId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.percentage = percentage;
		this.progress = progress;
		this.vipCode = vipCode;
		this.geId = geId;
		this.codeValue = codeValue;
		this.location = location;
		this.coloum1 = coloum1;
		this.coloum2 = coloum2;
	}
}
