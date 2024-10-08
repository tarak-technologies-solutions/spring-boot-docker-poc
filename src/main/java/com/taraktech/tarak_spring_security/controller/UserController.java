package com.taraktech.tarak_spring_security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taraktech.tarak_spring_security.entity.Users;
import com.taraktech.tarak_spring_security.service.UsersService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UsersService usersService;

	@GetMapping
	public String greet() {
		return "Welcome to user dash board..!";
	}
	
	@PostMapping("/save")
	public Users persist(@RequestBody Users users) {
		return usersService.persists(users);
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "admin dash board...!";
	}
	@PostMapping("/login")
	public String verify(@RequestBody Users user) {
		return usersService.verify(user);
	}
	
	@GetMapping("/upannel")
	public String user() {
		return "This is user pannel.!";
	}

}
