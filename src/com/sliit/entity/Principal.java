/*
 * Class Name : Principal
 * GUI class
 *
 * Version info : ~
 *

 */

// package
package com.sliit.entity;

// imports

// class implementation
public class Principal {
    
    // properties
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String contact;
    private String position;
    private String address;
    private String gender;

    // default constructor
    public Principal() {
        id = null;
        firstName = null;
        lastName = null;
        email = null;
        contact = null;
        position = null;
        address = null;
        gender = null;
    }

    // overloaded constructor
    public Principal(String id, String firstName, String lastName, String email, String contact, String position, String address, String gender) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.contact = contact;
		this.position = position;
		this.address = address;
		this.gender = gender;
	}

    // getters and setters
    public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}