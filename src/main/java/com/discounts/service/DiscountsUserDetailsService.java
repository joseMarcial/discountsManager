package com.discounts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.discounts.entities.auth.CustomerUserDetails;


public class DiscountsUserDetailsService implements UserDetailsService {
	
	@Autowired
	private DataService dataService;

	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		
		//return new CustomerUserDetails (dataService.findUserByName(name));
		return  new CustomerUserDetails (dataService.findUserByName(name));
	}

}
