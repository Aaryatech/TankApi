package com.ats.tankwebapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.tankwebapi.model.User;
import com.ats.tankwebapi.repository.UserRepo;

@RestController
public class MasterWebApiController {
	@Autowired
	UserRepo userRepo;
	
	@RequestMapping(value = { "/getAllUserDetailsList" }, method = RequestMethod.GET)
	public @ResponseBody List<User> getAllUserList() {

		List<User> list = new ArrayList<User>();
		try {

			list = userRepo.findByOrderByUserIdDesc();

		} catch (Exception e) {

			e.printStackTrace();
		}

		return list;

	}
}
