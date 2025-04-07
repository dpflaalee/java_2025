package com.thejoa.boot002.dto;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
	@RequestMapping("/ex1")
	@ResponseBody
	public String basic2() {return "springboot";}
	
	//@GetMapping("/ex2")
	@RequestMapping("/ex2")
	public String ex(Model model) {
		model.addAttribute("test","ex2");
		return "ex2";}
}
