package com.learnit.operations.onlineshop.enteties.impl;

import com.learnit.operations.onlineshop.enteties.UserRole;
import com.learnit.operations.onlineshop.enteties.User;

public class DefaultUser implements User {

	private int id;
	private String firstName;
	private String lastName;
	private String password;
	private String email;
	private UserRole role;

	private static int userCounter = 0;

	{
		id = ++userCounter;
	}

	public DefaultUser() {
	}

	public DefaultUser(String firstName, String lastName, String password, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.email = email;
	}

	@Override
	public String getFirstName() {
		return this.firstName;
	}

	@Override
	public String getLastName() {
		return this.lastName;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getEmail() {
		return this.email;
	}

	@Override
	public String toString() {
		return "User [id=" + this.id + ", firstName=" + this.firstName + ", lastName=" + this.lastName + ", password="
				+ this.password + ", email=" + this.email + "]";
	}

	@Override
	public void setPassword(String password) {
		if (password == null) {
			return;
		}
		this.password = password;
	}

	@Override
	public void setEmail(String newEmail) {
		if (newEmail == null) {
			return;
		}
		this.email = newEmail;
	}

	@Override
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	void clearState() {
		userCounter = 0;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole() {
		this.role = new DefaultUserRole("default_user");
	}
}
