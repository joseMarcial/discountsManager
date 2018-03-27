package com.discounts.service.api;

import java.util.List;

import com.discounts.model.User;

public class RegisterEmployeesRequest {
	
	private String id_company;
	private List<User> employees;
	
	
	public RegisterEmployeesRequest() {}
	
	public RegisterEmployeesRequest(String id_company, List<User> employees) {
		super();
		this.id_company = id_company;
		this.employees = employees;
	}
	public String getId_company() {
		return id_company;
	}
	public void setId_company(String id_company) {
		this.id_company = id_company;
	}
	public List<User> getEmployees() {
		return employees;
	}
	public void setEmployees(List<User> employees) {
		this.employees = employees;
	}
	
	
	

}
