package com.thejoa.boot008.util_naver;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class NaverController {
	@Autowired NaverBooks api;
	
	@GetMapping("/naver/books")
	public String books() {return "books";}
	
	@GetMapping(value = "/naver/booksapi/{search}", produces = "application/json;charset=UFT-8") 
	@ResponseBody public String booksJson(@PathVariable String search) throws IOException {
		return api.getApi(search);
	}
}
