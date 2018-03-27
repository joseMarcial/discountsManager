package com.discounts.service;



import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.discounts.model.Company;
import com.discounts.model.Discount;
import com.discounts.service.api.BuyDiscountRequest;
import com.discounts.service.api.BuyDiscountResponse;
import com.discounts.service.api.RegisterEmployeesRequest;
import com.discounts.service.api.RegisterEmployeesResponse;

@Service
public class CompanyService {
	
	@Autowired
	private DataService dataService;
	
	public Map<Long, Discount> getDiscounts(){
		
		Map<Long, Discount> discounts = dataService.getAllDiscounts();
		
		return discounts;
		
	}
	
	
	public BuyDiscountResponse buyDiscount(BuyDiscountRequest request) {
		
		return new BuyDiscountResponse("200", "Ok");
	}
	
	
	public boolean isExistCompany(String companyId) {
		return dataService.isExistCompany(companyId);
		
	}
	
	
	public RegisterEmployeesResponse executeRegisterEmployees(RegisterEmployeesRequest request , String company_id){
		RegisterEmployeesResponse  result ;
		if (dataService.isExistCompany(company_id)) {
			Company company = dataService.findCompanyById(company_id).get();
			company.setEmployees(request.getEmployees());
			result = new RegisterEmployeesResponse("200", "Employees registered under company : "+ request.getId_company());
		}else
			
			result = new RegisterEmployeesResponse("406", "company  : "+ request.getId_company()+" not found");
		return result;
	}
	
	
	
	
	
	

}
