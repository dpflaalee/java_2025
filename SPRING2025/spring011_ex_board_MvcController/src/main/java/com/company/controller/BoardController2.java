package com.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	//글쓰기-화면
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create(BoardDto dto) {
		return "board/write";}
	
	//글쓰기-기능
	/*
	 * @RequestMapping(value = "/create", method = RequestMethod.POST) public String
	 * create_post(BoardDto dto) { if(dto!=null) {service.insert(dto);} return
	 * "redirect:/board/list";}
	 */
	
	//
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create_post(BoardDto dto, RedirectAttributes rttr) {
		String result="fail";
		if(dto!=null || service.insert(dto)>0 ) {result="success";}
		rttr.addFlashAttribute("result", result);
		return "redirect:/board/list";}
	//RedirectAttributes : view페이지에 redirect한결과를 넘겨주는 방법
	//board/list.jsp 파일에서 result한결과를 알림창에 1번만 처리
	//refresh(새로고침) result 유지안됨
	///////////////////////////////////////////////////////////////////////////////
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
