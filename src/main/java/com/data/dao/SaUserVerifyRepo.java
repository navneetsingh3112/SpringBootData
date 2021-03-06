package com.data.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.data.entity.SaUserVerify;
import com.data.entity.SaUserVerifyStatus;

interface SaUserVerifyRepo extends CrudRepository<SaUserVerify, Integer> {
	public List<SaUserVerify> findByStatus(SaUserVerifyStatus status);
	
	public List<SaUserVerify> findByToken(String token);
	
	@Query(value="SELECT * FROM sa_user_verify where status in ?1",nativeQuery=true)
	public List<SaUserVerify> findByStatusList(List<String> statusList);
	
	public List<SaUserVerify> findAllByOrderByUserIdDesc();
	
	public List<SaUserVerify> findByTokenAndStatus(String token, SaUserVerifyStatus status);
	
	public List<SaUserVerify> findByTokenAndStatusIn(String token, List<SaUserVerifyStatus> statusList);
}
