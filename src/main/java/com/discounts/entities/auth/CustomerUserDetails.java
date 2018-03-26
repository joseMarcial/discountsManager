package com.discounts.entities.auth;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomerUserDetails implements UserDetails {
	
	
	private String userName;
	private String password;
	Collection<? extends GrantedAuthority> authorities;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7388469563169189667L;

	public CustomerUserDetails(User user){
		this.userName= user.getUserName();
		this.password= user.getPassword();
		
		this.authorities= user.getRoles().stream().map(r -> new SimpleGrantedAuthority(r.getName().toUpperCase())).collect(Collectors.toList());
		
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	@Override
	public String getPassword() {
		
		return password;
	}

	@Override
	public String getUsername() {
		
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	@Override
	public boolean isEnabled() {
		
		return true;
	}

}
