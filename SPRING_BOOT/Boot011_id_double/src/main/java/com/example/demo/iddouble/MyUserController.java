package com.example.demo.iddouble;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyUserController {
	@Autowired MyUserService service;
	@GetMapping(value = "/idByUsername/{username}", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public Map<String, Object> idByUsername( @PathVariable String username){
		Map<String, Object> result = new HashMap<>();
		String msg="사용 불가능합니다.";
		try {
			 service.selectUserName(username);
		}catch (Exception e) {msg="가능합니다.";}
		
		result.put("result", msg);
		return result;
	}
	
	@GetMapping(value = "/idByUseremail/{email}", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public Map<String, Object> idByUseremail( @PathVariable String email){
		Map<String, Object> result = new HashMap<>();
		result.put("result", service.selectUserEmail(email));
		return result;
	}
	
	@GetMapping("/idDouble")
	public String test() {return "idDouble";}
	
}
