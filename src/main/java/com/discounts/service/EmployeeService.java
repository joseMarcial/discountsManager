package com.discounts.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.discounts.model.Discount;
import com.discounts.service.api.EmployeeDiscountsResponse;

@Service
public class EmployeeService {
	
	@Autowired
	private DataService dataService;
	
	public  ResponseEntity<EmployeeDiscountsResponse> getDiscountsByEmployee(Long employeeId, Long companyId){
		
		List<Discount> discounts;
		ResponseEntity<EmployeeDiscountsResponse> response;
		EmployeeDiscountsResponse employeeDiscountsResponse;
		
		if (dataService.validateEmployeeBelongs(employeeId, companyId)) {
		
			discounts = dataService.getAllDiscountsByEmployee(employeeId , companyId);
			employeeDiscountsResponse = new EmployeeDiscountsResponse(HttpStatus.OK.toString(), HttpStatus.OK.getReasonPhrase());
			employeeDiscountsResponse.setDiscounts(discounts);
			response = new ResponseEntity<EmployeeDiscountsResponse>(employeeDiscountsResponse, HttpStatus.OK);
		}else {
			discounts = new ArrayList<Discount>();
			employeeDiscountsResponse = new EmployeeDiscountsResponse(HttpStatus.NOT_FOUND.toString(), "employee doesnt belong to Company" + companyId );
			employeeDiscountsResponse.setDiscounts(discounts);
			response = new ResponseEntity<EmployeeDiscountsResponse>(employeeDiscountsResponse, HttpStatus.OK);
		}
		
		
		return response;
		
	}

}
