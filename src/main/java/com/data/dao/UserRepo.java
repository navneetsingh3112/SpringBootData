package com.data.dao;

import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;

import com.data.entity.User;

@Transactional
interface UserRepo extends CrudRepository<User, Integer> {
	public User findByEmail(String email);
}