package com.discounts.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

import com.discounts.service.DiscountsUserDetailsService;

@Configuration
@EnableAutoConfiguration
@ComponentScan({"com.discounts.controller","com.discounts.service"})
public class DiscountsManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiscountsManagerApplication.class, args);
	}
	
//	public void authenticationManager(AuthenticationManagerBuilder builder) throws Exception {
//		
//		builder.userDetailsService(new DiscountsUserDetailsService());
//	}
}
