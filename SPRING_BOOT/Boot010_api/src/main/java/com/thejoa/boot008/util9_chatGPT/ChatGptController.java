package com.thejoa.boot008.util9_chatGPT;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ChatGptController {
	@Autowired 
	private ChatGptService chatGptService;
	
	@PostMapping(value="/openai", produces="appplication/json;charset=UTF-8")
	@ResponseBody
	public String openai(@RequestBody String content) {return chatGptService.getAPIResponse(content);}
}
