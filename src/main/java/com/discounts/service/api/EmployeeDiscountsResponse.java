package com.discounts.service.api;

import java.util.List;

import com.discounts.model.Discount;
import com.discounts.model.User;

public class EmployeeDiscountsResponse extends RestResponse {
	
	List<Discount> discounts;
	User user;

	public EmployeeDiscountsResponse(String responseCode, String codeDescription) {
		super(responseCode, codeDescription);
		// TODO Auto-generated constructor stub
	}

	public List<Discount> getDiscounts() {
		return discounts;
	}

	public void setDiscounts(List<Discount> discounts) {
		this.discounts = discounts;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	

}
