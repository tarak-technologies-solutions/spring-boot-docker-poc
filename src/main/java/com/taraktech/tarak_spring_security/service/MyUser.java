package com.taraktech.tarak_spring_security.service;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MyUser implements UserDetails {

	private String uname;
	private String password;
	private List<GrantedAuthority> roles;

	public MyUser() {
	}

	public MyUser(String uname, String password, List<GrantedAuthority> roles) {
		this.uname = uname;
		this.password = password;
		this.roles = roles;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// System.out.println(roles);
		return roles;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return uname;
	}

}
