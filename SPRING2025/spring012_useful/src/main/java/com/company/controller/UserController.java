package com.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.service.UserService;

@Controller
public class UserController {
	@Autowired  UserService  service;
	
	@RequestMapping("/list.user")	
	public String list(Model model) { 
		model.addAttribute("list" , service.selectAll());//처리하고 
		return "users/list";  //화면 
	}
	
}






