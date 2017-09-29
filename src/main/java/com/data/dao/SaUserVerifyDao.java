package com.data.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.entity.SaUserVerify;
import com.data.entity.SaUserVerifyStatus;

@Service
public class SaUserVerifyDao {
	
	@Autowired
	SaUserVerifyRepo saUserVerifyRepo;
	
	public void createSaUserVerify(SaUserVerify saUserVerify) {
		saUserVerifyRepo.save(saUserVerify);
	}
	
	public SaUserVerify getSaUserVerify(Integer id) {
		return saUserVerifyRepo.findOne(id);
	}
	
	public List<SaUserVerify> findByStatus(SaUserVerifyStatus status) {
		return saUserVerifyRepo.findByStatus(status);
	}
	
	public List<SaUserVerify> findByToken(String token) {
		return saUserVerifyRepo.findByToken(token);
	}

	public List<SaUserVerify> findByStatusList(List<String> statusList) {
		return saUserVerifyRepo.findByStatusList(statusList);
	}
	
	public List<SaUserVerify> getAllByOrderByUserIdDesc() {
		return saUserVerifyRepo.findAllByOrderByUserIdDesc();
	}
	
	public List<SaUserVerify> getAllByTokenAndStatus(String token, SaUserVerifyStatus status) {
		return saUserVerifyRepo.findByTokenAndStatus(token,status);
	}
	
	public List<SaUserVerify> getByTokenAndStatusIn(String token, List<SaUserVerifyStatus> statusList) {
		return saUserVerifyRepo.findByTokenAndStatusIn(token,statusList);
	}
	
}
