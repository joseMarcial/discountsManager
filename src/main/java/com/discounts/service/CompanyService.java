package com.discounts.service;



import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.discounts.model.Discount;
import com.discounts.service.api.BuyDiscountRequest;
import com.discounts.service.api.BuyDiscountResponse;

@Service
public class CompanyService {
	
	@Autowired
	private DataService dataService;
	
	public Map<Integer, Discount> getDiscounts(){
		
		Map<Integer, Discount> discounts = dataService.getAllDiscounts();
		
		return discounts;
		
	}
	
	
	public BuyDiscountResponse buyDiscount(BuyDiscountRequest request) {
		
		return new BuyDiscountResponse("200", "Ok");
	}
	
	
	
	
	
	

}
