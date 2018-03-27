package com.discounts.model;

import java.util.Collection;

public class Company {
	
	String  id_company;
	String name;
	
	Collection<User> employees;
	
	
	
	
	public Company(String id_company, String name) {
		super();
		this.id_company = id_company;
		this.name = name;
	}
	
	
	public Collection<User> getEmployees() {
		return employees;
	}
	public void setEmployees(Collection<User> employees) {
		this.employees = employees;
	}
	public String getId_company() {
		return id_company;
	}
	public void setId_company(String id_company) {
		this.id_company = id_company;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
