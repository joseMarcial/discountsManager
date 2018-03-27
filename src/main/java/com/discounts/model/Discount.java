package com.discounts.model;

public class Discount {
	
	
	public enum DiscountType {
		
		_10_PERCENTAGE,
		_20_PERCENTAGE,
		_30_PERCENTAGE,
		
		
		

	}

	int id_discount;
	DiscountType type;
	String description;
	
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Discount(int id_discount, DiscountType type, String description) {
		super();
		this.id_discount = id_discount;
		this.type = type;
		this.description = description;
	}
	
	public int getId_discount() {
		return id_discount;
	}
	public void setId_discount(int id_discount) {
		this.id_discount = id_discount;
	}
	public DiscountType getType() {
		return type;
	}
	public void setType(DiscountType type) {
		this.type = type;
	}
	
	
	
	
	
	

}
