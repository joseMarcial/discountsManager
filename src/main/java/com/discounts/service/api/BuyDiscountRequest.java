package com.discounts.service.api;

public class BuyDiscountRequest {
	
	String id_company;
	String id_discount;
	String discountPercentage;
	
	public BuyDiscountRequest() {}
	
	public BuyDiscountRequest(String id_company, String id_discount, String discountPercentage) {
		super();
		this.id_company = id_company;
		this.id_discount = id_discount;
		this.discountPercentage = discountPercentage;
	}
	public String getId_company() {
		return id_company;
	}
	public void setId_company(String id_company) {
		this.id_company = id_company;
	}
	public String getId_discount() {
		return id_discount;
	}
	public void setId_discount(String id_discount) {
		this.id_discount = id_discount;
	}
	public String getDiscountPercentage() {
		return discountPercentage;
	}
	public void setDiscountPercentage(String discountPercentage) {
		this.discountPercentage = discountPercentage;
	}
	
	

}
