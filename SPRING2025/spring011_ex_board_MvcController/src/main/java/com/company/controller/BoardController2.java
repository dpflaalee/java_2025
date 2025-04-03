package com.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.company.dto.BoardDto;
import com.company.service.ServiceBoard;

@Controller
@RequestMapping("/board")
public class BoardController2 {
	@Autowired ServiceBoard service;
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("list", service.selectAll());
		return "board/list";}
	
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String create(BoardDto dto) {
		if(dto!=null) {service.insert(dto);}
		return "redirect:/board/list";}
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String detail(Model model, int bno) {
		model.addAttribute("dto", service.detail(bno));
		return "board/detail";}
	
	
	
	
	@RequestMapping("/edit")
	public String edit(Model model, int bno) {
		model.addAttribute("dto", service.updateForm(bno));
		return "board/edit";}
	
	@RequestMapping("/delete")
	public String delete() {return "board/delete";}
}
