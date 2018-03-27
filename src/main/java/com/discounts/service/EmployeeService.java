package com.discounts.service;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.discounts.model.Discount;
import com.discounts.service.api.EmployeeDiscountsResponse;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class EmployeeService {
	
	@Autowired
	private DataService dataService;
	
//	@Bean
//	public RestTemplate rest(RestTemplateBuilder builder) {
//		return builder.build();
//	}
	
	private  RestTemplate restTemplate;
	
	public EmployeeService(RestTemplate rest) {
	    this.restTemplate = rest;
	}
	
	public  ResponseEntity<EmployeeDiscountsResponse> getDiscountsByEmployeeLocal(Long employeeId, Long companyId){
		
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

	@HystrixCommand(fallbackMethod = "getDiscountsByEmployeeLocal")
	public  ResponseEntity<EmployeeDiscountsResponse> getDiscountsByEmployee(Long employeeId, Long companyId){
		
		List<Discount> discounts;
		ResponseEntity<EmployeeDiscountsResponse> response;
		EmployeeDiscountsResponse employeeDiscountsResponse;
		
		URI uri = URI.create("http://localhost:8080//{companyId}/employees/{empoyeeId}");
		
		Map<String, String> params = new HashMap<String, String>();
	    params.put("companyId", String.valueOf(companyId));
	    params.put("empoyeeId", String.valueOf(employeeId));
		
	    this.restTemplate = new RestTemplate();
	    Boolean restResponse = this.restTemplate.getForObject(uri.toString(), Boolean.class, params);
	    System.out.println(restResponse);
		
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
