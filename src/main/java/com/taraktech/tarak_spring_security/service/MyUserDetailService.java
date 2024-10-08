package com.taraktech.tarak_spring_security.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.taraktech.tarak_spring_security.entity.Users;
import com.taraktech.tarak_spring_security.repo.UsersRepo;

@Service
public class MyUserDetailService implements UserDetailsService {

	@Autowired
	private UsersRepo usersRepo;

	private List<GrantedAuthority> roles = new ArrayList<>();

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Users user = usersRepo.findByUname(username);
		if (user == null) {
			throw new UsernameNotFoundException("user does not exist...!");
		}
		// System.out.println(user);

		String[] userRoles = user.getRoles().split(",");
		for (String role : userRoles) {
			roles.add(new SimpleGrantedAuthority(role));
		}

		System.out.println(roles);

		return new MyUser(user.getUname(), user.getPassword(), roles);
	}

}
