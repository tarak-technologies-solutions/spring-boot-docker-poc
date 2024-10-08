package com.taraktech.tarak_spring_security.service;

import com.taraktech.tarak_spring_security.entity.Users;

public interface UsersService {
	public Users persists(Users users);

	public String verify(Users user);
}
