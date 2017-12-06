package com.lmig.gfc.wimp.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Actor {
	
public Actor(String firstName, String lastName, Long activeSinceYear, Date brithDate) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.activeSinceYear = activeSinceYear;
		this.brithDate = brithDate;
	}

public Actor () {
	
}

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
@Column(length=75, nullable = true)
	private String firstName;

@Column(length=75, nullable = true)
	private String lastName;

@Column(nullable = true)
	private Long activeSinceYear;

@Column(nullable = true)
private Date brithDate;

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public Long getActiveSinceYear() {
	return activeSinceYear;
}

public void setActiveSinceYear(Long activeSinceYear) {
	this.activeSinceYear = activeSinceYear;
}

public Date getBrithDate() {
	return brithDate;
}

public void setBrithDate(Date brithDate) {
	this.brithDate = brithDate;
}

}
