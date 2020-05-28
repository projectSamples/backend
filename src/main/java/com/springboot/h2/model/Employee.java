package com.springboot.h2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.sql.Date;

import javax.persistence.*;

// @Entity annotation specifies that the class is mapped to a database table.
@Entity
@SQLDelete(sql = "UPDATE Employee SET deleted=true WHERE id=?")
@Where(clause = "deleted = false")
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
	private String vpnCode;
	private String geId;
	private String phoneNumber;
	private String location;
	private String managerName;
	private String projectLocation;
	@JsonIgnore
	@Column(name = "deleted", columnDefinition = "boolean default false")
	private boolean deleted = false;
	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}




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
	 * @return the vpnCode
	 */
	public String getVpnCode() {
		return vpnCode;
	}


	/**
	 * @param vpnCode the vipCode to set
	 */
	public void setVpnCode(String vpnCode) {
		this.vpnCode = vpnCode;
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
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}


	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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
	 * @return the managerName
	 */
	public String getManagerName() {
		return managerName;
	}


	/**
	 * @param managerName the managerName to set
	 */
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}


	/**
	 * @return the projectLocation
	 */
	public String getProjectLocation() {
		return projectLocation;
	}


	/**
	 * @param projectLocation the projectLocation to set
	 */
	public void setProjectLocation(String projectLocation) {
		this.projectLocation = projectLocation;
	}

	public Employee() {}
	// Parameterized constructor.
	public Employee(int id, int empId, String name, int age, String emailAddress, String projectName, int projectId,
			Date startDate, Date endDate, int percentage, String progress, String vpnCode, String geId,
			String phoneNumber, String location, String managerName,  String projectLocation) {
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
		this.vpnCode = vpnCode;
		this.geId = geId;
		this.phoneNumber = phoneNumber;
		this.location = location;
		this.managerName = managerName;
		this.projectLocation = projectLocation;
	}
}
