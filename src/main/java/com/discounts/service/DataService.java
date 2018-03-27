package com.discounts.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import com.discounts.model.Company;
import com.discounts.model.Discount;
import com.discounts.model.Discount.DiscountType;
import com.discounts.model.Role;
import com.discounts.model.Transaction;
import com.discounts.model.User;

@Service
@Scope(value = WebApplicationContext.SCOPE_APPLICATION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class DataService  {
	
	public static  final List<User> USERS  = new ArrayList<User>();
	public static  final Set<Company> COMPANIES  = new HashSet<Company>();
	public static  final Map<Long, Discount> DISCOUNTS =  new Hashtable<>();
	public static  final Set<Transaction> TRANSACTIONS =  new HashSet<Transaction>();
	
	private static long users_Id_counter= 1;
	private static long companies_Id_counter= 100;
	private static long discounts_Id_counter= 1;
	private static long transaction_Id_counter= 1;
	
	
	
	public static void init() {
		
		List<Role> roles = new ArrayList<Role>();
		
		roles.add(new Role("EMPLOYEE"));
		User testUser  = new User(users_Id_counter++, "user","password",roles);
		USERS.add(testUser);
		
		Company testCompany = new Company(String.valueOf(companies_Id_counter++),"globant");
		Collection testEmployees= new ArrayList();
		testEmployees.add(testUser);
		testCompany.setEmployees(testEmployees);
		
		COMPANIES.add(testCompany);
		
		
		Discount first = new Discount((int )discounts_Id_counter++,DiscountType._10_PERCENTAGE,"Nike_discount_10%");
		Discount second = new Discount((int )discounts_Id_counter++,DiscountType._20_PERCENTAGE,"Adidas_discount_20%");
		Discount third = new Discount((int )discounts_Id_counter++,DiscountType._30_PERCENTAGE,"Reebok_discount_30%");
		
		DISCOUNTS.put(Long.valueOf(first.getId_discount()), first);
		DISCOUNTS.put(Long.valueOf(second.getId_discount()), second);
		DISCOUNTS.put(Long.valueOf(third.getId_discount()), third);
	
		Transaction testTrans = new Transaction(String.valueOf(transaction_Id_counter++),testCompany.getId_company(),"2");
		
		TRANSACTIONS.add( testTrans);
		
						
						
	}
	
	DataService() {
		init();
	}
	
	
	public Map<Long, Discount> getAllDiscounts(){
		
		
		return DISCOUNTS;
	}
	
	public User findUserByName(String  name) {
		
		return ((User) USERS.stream().filter(u ->  u.getUserName().equals(name)));
	}

	public boolean isExistCompany(String id_company) {
		
		return  COMPANIES.stream().filter(c -> c.getId_company().equals(id_company)).count()>0;
	}
	
	public Optional<Company> findCompanyById(String id_company) {
		
		return COMPANIES.stream().filter(c -> c.getId_company().equals(id_company)).findAny();
	}

	public List<Discount> getAllDiscountsByEmployee(Long employeeId , Long companyId) {
		
		List<String> discountsIds =  TRANSACTIONS.stream().filter( t -> t.getId_company().equals(String.valueOf(companyId))).map(t -> t.getId_discount()).collect(Collectors.toList());
		List<Discount>  discounts = new ArrayList<>();
		if (discountsIds!= null && !discountsIds.isEmpty() ) {
			
			for (String id : discountsIds) {
				discounts.add(DISCOUNTS.get(Long.valueOf(id)));
			}
			
			
		}
		
		return discounts;
		
	}
 
	public boolean validateEmployeeBelongs(Long employeeId , Long companyId) {
		
		//return COMPANIES.stream().map(arg0)(c -> c.getEmployees().contains(arg0)));
		
		Optional<Company> optionalCompany = COMPANIES.stream().filter(c -> c.getId_company().equals(String.valueOf(companyId))).findAny();
		
		return   optionalCompany.get().getEmployees().stream().anyMatch(e -> e.getId().toString().equals(String.valueOf(employeeId)));
			
			
			
		}
			
				

	

}
