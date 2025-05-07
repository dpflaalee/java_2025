package com.company.test.board;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.company.test.member.Member;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BoardController {
	private final BoardService service;
	
	@GetMapping("/board/list")
	public String list(Model model){
		model.addAttribute("list" , service.findAll());
		return "board/list"; 
	}
	
	
	@GetMapping("/board/detail/{id}")
	public String detail( @PathVariable  Long id,  Model model){
		model.addAttribute("dto" , service.find(id)); 
		return "board/detail";
	}

	//insert
	@GetMapping("/board/insert")
	public String insert_get(Model model, Principal principal){
		model.addAttribute("username", principal.getName());
		return "board/write"; }
	
	@PostMapping("/board/insert")
	public String insert_post(Board board, Member member){ 
		board.setMember(member);
		service.insert(board);
		return "redirect:/board/list"; 
	} 
	
	//update
	@GetMapping("/board/update/{id}")
	public String update_get( @PathVariable( required = false) Long id , Model model){ 
		model.addAttribute("dto",service.update_view(id));
		return "board/edit"; 
	}
	
	@PostMapping("/board/update")
	public String update_post( Board board, RedirectAttributes rttr ){ 
		String msg="fail";
		if(service.update(board)>0) {msg="글 수정완료!";}
		rttr.addFlashAttribute("msg",msg);
		return "redirect:/board/detail/"+board.getId(); 
	}
	
	//delete
	@GetMapping("/board/delete/{id}")
	public String delete_get(@PathVariable Long id, Model model){ 
		model.addAttribute("id",id);
		return "board/delete"; }
	
	@PostMapping("/board/delete")
	public String delete_post( Board board, RedirectAttributes rttr ){ 
		String msg = "fail";
		if(service.delete(board)>0) { msg ="글삭제성공!";}
		rttr.addFlashAttribute("msg", msg );
		
		return "redirect:/board/list"; 
	} 
	
}
