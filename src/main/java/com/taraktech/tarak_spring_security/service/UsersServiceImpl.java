package com.taraktech.tarak_spring_security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.taraktech.tarak_spring_security.entity.Users;
import com.taraktech.tarak_spring_security.jwt.JWTServices;
import com.taraktech.tarak_spring_security.repo.UsersRepo;
@Service
public class UsersServiceImpl implements UsersService{
	@Autowired
	private UsersRepo usersRepo;
	@Autowired
	private PasswordEncoder encoder;
	@Autowired
	private AuthenticationManager authManager;
	@Autowired
	private JWTServices jwtServices;
	 
	
	@Override
	public Users persists(Users users) {
		users.setPassword(encoder.encode(users.getPassword()));
		return usersRepo.save(users);
	}

	@Override
	public String verify(Users user) {
		String roles = user.getRoles();
		//String[] role = roles.split(",");
		Authentication authenticate = authManager
				.authenticate(new UsernamePasswordAuthenticationToken(user.getUname(), user.getPassword()));
		if (authenticate.isAuthenticated()) {
			return jwtServices.generateToken(user.getUname());
		}
		return "Login failure";
	}

}
