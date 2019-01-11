package com.ritchieeinstein.spring.jwtdemo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ritchieeinstein.spring.jwtdemo.model.Mobile;

@RestController
@RequestMapping("/mobile")
public class MobileController {
	
	@GetMapping("/getAll")
	public List<Mobile> getAllMobiles(){
		List<Mobile> mobileList = new ArrayList<>();
		mobileList.add(new Mobile(1, "iPhone 7", "Apple"));
		mobileList.add(new Mobile(2, "Note 4", "RedMI"));
		return mobileList;
	}

}
