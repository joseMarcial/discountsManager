package com.discounts.service;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.discounts.entities.auth.Role;
import com.discounts.entities.auth.User;
import com.discounts.model.Discount;
import com.discounts.model.Discount.DiscountType;

@Service
public class DataService  {
	
	public static  final List<User> USERS  = new ArrayList<User>();
	
	public static void init() {
		
		List<Role> roles = new ArrayList<Role>();
				roles.add(new Role("USER"));
				roles.add(new Role("ACTUATOR"));
				USERS.add(new User(1L, "user","user",roles));
	}
	
	DataService() {
		init();
	}
	
	
	public Map<Integer, Discount> getAllDiscounts(){
		init();
		
		Map<Integer, Discount> discounts = new Hashtable<>();
		discounts.put(1, new Discount(1,DiscountType._10_PERCENTAGE,"Nike_discount_10%"));
		discounts.put(2, new Discount(2,DiscountType._20_PERCENTAGE,"Adidas_discount_20%"));
		discounts.put(3, new Discount(3,DiscountType._30_PERCENTAGE,"Reebok_discount_30%"));
		
		return discounts;
	}
	
	public User findUserByName(String  name) {
		
		return ((User) USERS.stream().filter(u ->  u.getUserName().equals(name)));
	}
	
	
 
	

}
