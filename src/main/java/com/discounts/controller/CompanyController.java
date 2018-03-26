package com.discounts.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.discounts.model.Discount;
import com.discounts.service.CompanyService;
import com.discounts.service.api.BuyDiscountRequest;
import com.discounts.service.api.BuyDiscountResponse;

@RestController
@RequestMapping("/discounts")
public class CompanyController {
	
	@Autowired
	CompanyService service;
	
	@RequestMapping(value = "/all", method = RequestMethod.GET,  produces = "application/json")
	public ResponseEntity<Map<Integer,Discount>> getAllDiscounts(){
		
		return new ResponseEntity<>(service.getDiscounts(),HttpStatus.OK) ;
	}
	
	@RequestMapping(value = "/buyDiscount", method = RequestMethod.POST , produces = "application/json", consumes="application/json")
	public ResponseEntity<BuyDiscountResponse> buyDiscount(@RequestBody BuyDiscountRequest request) {
		
		if (validateInputMapping(request)) {
			
			BuyDiscountResponse response = new BuyDiscountResponse("200", "buy Registered");		
			return new ResponseEntity<BuyDiscountResponse>(response,HttpStatus.OK);
		}
		else {
			return invalidREsponse();
		}
	}
	
	private ResponseEntity<BuyDiscountResponse> invalidREsponse() {
		BuyDiscountResponse response = new BuyDiscountResponse("400", "Invalid Params");
		
		return new ResponseEntity<BuyDiscountResponse>(response, HttpStatus.OK);
	}

	private  boolean validateInputMapping(BuyDiscountRequest request){
		return (request.getId_company() == null || request.getId_discount() == null?false:true);

	}

}
