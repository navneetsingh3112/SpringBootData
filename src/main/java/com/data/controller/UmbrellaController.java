package com.data.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.data.dao.SaUserVerifyDao;
import com.data.dao.UserDao;
import com.data.entity.SaUserVerify;
import com.data.entity.SaUserVerifyStatus;
import com.data.entity.User;

@Controller
public class UmbrellaController {
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	SaUserVerifyDao saUserVerifyDao;

	@RequestMapping(value = "/createUser", method = RequestMethod.POST,consumes = "application/json")
	@ResponseBody
	public String create(@RequestBody User user) {
		try {
			userDao.createUser(user);
		} catch (Exception ex) {
			ex.printStackTrace();
			return "Error creating the user: " + ex.toString();
		}
		return "User succesfully created! (id = " + user.getId() + ")";
	}
	
	
	@RequestMapping(value = "/createSaUserVerify", method = RequestMethod.POST,consumes = "application/json")
	@ResponseBody
	public String createSaUserVerify(@RequestBody SaUserVerify saUserVerify) {
		try {
			saUserVerifyDao.createSaUserVerify(saUserVerify);
		} catch (Exception ex) {
			ex.printStackTrace();
			return "Error creating the user: " + ex.toString();
		}
		return "SaUserVerify succesfully created! (id = " + saUserVerify.getId() + ")";
	}

	@RequestMapping(value = "/getSaUserVerify", method = RequestMethod.POST,consumes = "application/json")
	@ResponseBody
	public String getSaUserVerify(@RequestBody Map<String, Integer> json) {
		try {
			SaUserVerify saUserVerify = saUserVerifyDao.getSaUserVerify(json.get("id"));
			return saUserVerify.toString();
		} catch (Exception ex) {
			ex.printStackTrace();
			return "Error creating the user: " + ex.toString();
		}
	}
	
	@RequestMapping(value = "/getByStatus", method = RequestMethod.POST,consumes = "application/json")
	@ResponseBody
	public String getByStatus(@RequestBody Map<String, String> json) {
		try {
			List<SaUserVerify> list = saUserVerifyDao.findByStatus(SaUserVerifyStatus.valueOf(json.get("status")));
			return SaUserVerify.toString(list);
		} catch (Exception ex) {
			ex.printStackTrace();
			return "Error creating the user: " + ex.toString();
		}
	}
	
	
	@RequestMapping(value = "/getByStatusList", method = RequestMethod.POST,consumes = "application/json")
	@ResponseBody
	public String getByStatusList(@RequestBody List<Map<String, String>> json) {
		try {
			List<SaUserVerifyStatus> statusList = new ArrayList<>();
			for (Map<String, String> map : json) {
				statusList.add(SaUserVerifyStatus.valueOf(map.get("status")));
			}
			List<SaUserVerify> list = saUserVerifyDao.findByStatusList(statusList);
			return SaUserVerify.toString(list);
		} catch (Exception ex) {
			ex.printStackTrace();
			return "Error creating the user: " + ex.toString();
		}
	}
}
