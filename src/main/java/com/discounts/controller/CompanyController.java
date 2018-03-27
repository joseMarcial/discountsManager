package com.discounts.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.discounts.model.Discount;
import com.discounts.service.CompanyService;
import com.discounts.service.api.BuyDiscountRequest;
import com.discounts.service.api.BuyDiscountResponse;
import com.discounts.service.api.RegisterEmployeesRequest;
import com.discounts.service.api.RegisterEmployeesResponse;

@RestController
@RequestMapping("/companies")
public class CompanyController {
	
	@Autowired
	CompanyService service;
	
	@RequestMapping(value = "/discounts", method = RequestMethod.GET,  produces = "application/json")
	public ResponseEntity<Map<Long,Discount>> getAllDiscounts(){
		return new ResponseEntity<>(service.getDiscounts(),HttpStatus.OK) ;
	}
	
	@RequestMapping(value = "/{companyId}/discount", method = RequestMethod.POST , produces = "application/json", consumes="application/json")
	public ResponseEntity<BuyDiscountResponse> buyDiscount(@RequestBody BuyDiscountRequest request, @PathVariable  long companyId) {
		
		if (validateInputMapping(request)) {
			
			BuyDiscountResponse response = new BuyDiscountResponse("200", "buy Registered");		
			return new ResponseEntity<BuyDiscountResponse>(response,HttpStatus.OK);
		}
		else {
			return invalidREsponse();
		}
	}
	
	
	@RequestMapping(value = "/{companyId}/employees", method = RequestMethod.POST , produces = "application/json", consumes="application/json")
	public ResponseEntity<RegisterEmployeesResponse> addEmployees(@RequestBody RegisterEmployeesRequest request, @PathVariable  long companyId) {
		
		if (validateInputMappingAddEmployees(request)) {
			
			RegisterEmployeesResponse response = service.executeRegisterEmployees(request, String.valueOf(companyId))		;
			return new ResponseEntity<RegisterEmployeesResponse>(response,HttpStatus.OK);
		}
		else {
			return invalidAddEmployeesREsponse();
		}
	}
	
	
	
	
	private boolean validateInputMappingAddEmployees(RegisterEmployeesRequest request) {
		
		return (request.getId_company() == null || request.getEmployees() == null || request.getEmployees().isEmpty() ?false:true);
	}

	private ResponseEntity<BuyDiscountResponse> invalidREsponse() {
		
		BuyDiscountResponse response = new BuyDiscountResponse("400", "Invalid Params");
		return new ResponseEntity<BuyDiscountResponse>(response, HttpStatus.OK);
	}

	private ResponseEntity<RegisterEmployeesResponse> invalidAddEmployeesREsponse() {
		
		RegisterEmployeesResponse response = new RegisterEmployeesResponse("400", "Invalid Params");
		return new ResponseEntity<RegisterEmployeesResponse>(response, HttpStatus.OK);
	}
	private  boolean validateInputMapping(BuyDiscountRequest request){
		
		return (request.getId_company() == null || request.getId_discount() == null?false:true);
	}

}
