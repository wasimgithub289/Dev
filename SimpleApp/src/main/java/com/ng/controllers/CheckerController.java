package com.ng.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ng.entities.User;
import com.ng.services.UserService;

@RestController
@RequestMapping("/checker")
public class CheckerController 
{
	@Autowired
	UserService service;
	
	@GetMapping("/checkerInbox")
	public ModelAndView getAllUsers()
	{
		ModelAndView mv= new ModelAndView("checkerInbox");
		mv.addObject("userList", service.getAllUser());
		mv.addObject("userCount", service.getUserCount());
		return mv;
	}
}
