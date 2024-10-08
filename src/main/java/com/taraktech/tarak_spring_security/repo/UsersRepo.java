package com.taraktech.tarak_spring_security.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taraktech.tarak_spring_security.entity.Users;

public interface UsersRepo extends JpaRepository<Users, Integer>{
	
	public Users findByUname(String uname);
}
