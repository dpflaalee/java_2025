package com.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.company.dto.UserDto;
import com.company.service.UserService;

@Controller
public class UserController {
	@Autowired  UserService  service;
	
	//@RequestMapping(value="/list.user", method = RequestMethod.GET)
	//@GetMapping("/list.user") 
	@RequestMapping("/list.user")
	//세가지 다 동일한 표현방법 근데 GetMapping은 높은버전에서 사용가능한듯
	public String list(Model model) { 
		model.addAttribute("list" , service.selectAll());//처리하고 
		return "users/list";  //화면 
	}
	
	@RequestMapping("/detail.user")
	public String detail(Model model, int no) {
		//System.out.println(no); //잘 되는지 테스트. users/select.jsp를 만들어야 오류없이 테스트가능
		model.addAttribute("dto", service.selectOne(no));
		return "users/select";
	}
	
	@RequestMapping(value = "/insert.user", method = RequestMethod.POST) 
	public String insert(UserDto dto){
		if(dto!=null) {service.insert(dto);}
		return "redirect:/list.user";
	}
	
	@RequestMapping(value = "/update.user", method = RequestMethod.POST) 
	public String update(UserDto dto){
		if(dto!=null) {service.update(dto);}
		return "redirect:/list.user";
	}
	
	@RequestMapping("/delete.user") 
	public String delete(int no){
		service.delete(no);
		return "redirect:/list.user";
	}
	
	//detail.user - get  방식 해당번호의 사용자정보 users/select.jsp
	//insert.user - post 방식 글쓰기기능       , list.user
	//update.user - post 방식 글수정기능       , list.user
	//delete.user - post 방식 삭제기능         , list.user
}






