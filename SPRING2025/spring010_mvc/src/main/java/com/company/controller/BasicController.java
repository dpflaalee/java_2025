package com.company.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller 
public class BasicController {
	@RequestMapping("/") 
	public String basic() { return "home"; }
	
	@RequestMapping("/basic1.do")
	public String basic1(Model model) { //1.처리결과를 Model 객체에 담기
		model.addAttribute("result","sally");
		//return"basic1.jsp"; //2.경로 http://localhost:8080/spring010_mvc/
		return "basic1"; // prefix [/] 	파일명 basic1 	suffix [.jsp] 
						//==> servlet 에서 InternalResourceViewResolver 설정을 해서 경로랑 확장자명 표기 안해도 됨
		
	}
	
}
