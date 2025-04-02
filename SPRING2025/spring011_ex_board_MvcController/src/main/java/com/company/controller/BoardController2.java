package com.company.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BoardController2 {
	@RequestMapping(value = "/board/list", method = RequestMethod.GET)
	public String list() {return "/board/list";}
	
	@RequestMapping(value = "/board/write", method = RequestMethod.GET)
	public String create() {return "/board/write";}
	
	@RequestMapping(value = "/board/detail", method = RequestMethod.GET)
	public String detail() {return "board/detail";}
	
	@RequestMapping("/board/edit")
	public String edit() {return "board/edit";}
	
	@RequestMapping("/board/delete")
	public String delete() {return "board/delete";}
}
