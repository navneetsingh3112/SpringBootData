package com.data.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.entity.User;

@Service
public class UserDao {
	
	@Autowired
	UserRepo userRepo;
	
	public void createUser(User user) {
		userRepo.save(user);
	}
}
