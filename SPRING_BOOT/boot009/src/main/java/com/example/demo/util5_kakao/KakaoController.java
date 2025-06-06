package com.example.demo.util5_kakao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class KakaoController {
	@Autowired KakaoLogin api;
	
	@GetMapping("/kakaologin")
	public String login(Model model) {
		model.addAttribute("url", api.step1());
		return "login";
	}
	
	@GetMapping("/kakao")
	public String loginuser(@RequestParam("code") String code, Model model){
		List<String> infos = api.step2(code);
		model.addAttribute("nickname", infos.get(0));
		model.addAttribute("profile_image", infos.get(1));
		return"login_result";
	}
	
	
	
}
