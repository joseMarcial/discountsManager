package com.discounts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.discounts.service.EmployeeService;
import com.discounts.service.api.EmployeeDiscountsResponse;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	EmployeeService service;
	
	@RequestMapping(value = "/{employeeId}/companies/{companyId}/discounts", method = RequestMethod.GET,  produces = "application/json")
	public ResponseEntity<EmployeeDiscountsResponse> getAllDiscountsByEmployee(@PathVariable  long employeeId, @PathVariable  long companyId){
		return service.getDiscountsByEmployee(employeeId, companyId) ;
	}

}
