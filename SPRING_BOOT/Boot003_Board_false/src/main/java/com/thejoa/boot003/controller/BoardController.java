package com.thejoa.boot003.controller;
 
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thejoa.boot003.myjpa.Board;

@Controller
public class BoardController {
	@RequestMapping("/test")
	public String test() {return "test";}
	//https://localhost:8080/test
	
	/*
	@GetMapping("/board/list")
	public String list(Model model){
		//##전체 리스트 뽑고
		return "board/list";
	}//https://localhost:8080/board/list
	
/////////////////////////////////////////////////////////////////////////////////////////	
	@GetMapping("/board/detail/{id}")
	public String detail(@PathVariable Long id, Model model){
		//##조회수 올리고 상세보기
		
		return "board/detail";
		//https://localhost:8080/board/detail/1
	}	
/////////////////////////////////////////////////////////////////////////////////////////
	@GetMapping("/board/insert")
	public String insert_get(){
		return "board/write";
		//https://localhost:8080/board/insert  글쓰기폼
	}
	@PostMapping("/board/insert")
	public String insert_post(Board board){
		//##글쓰기기능
		return "redirect:/board/list"; //글쓰고 갱신된 리스트로 이동
		//https://localhost:8080/board/insert  글쓰기기능
	}
/////////////////////////////////////////////////////////////////////////////////////////
	@GetMapping("/board/update/{id}")
	public String update_get(@PathVariable Long id, Model model){
		// ##수정할 글 가져오기
		return "board/edit";
		//https://localhost:8080/board/update/1 글수정폼
	}
	
	@PostMapping("/board/update")
	public String update_post(Board board){
		//##글수정기능
		return "redirect:/board/detail/{id}"; //글수정하고 해당 상세페이지로 이동
		//https://localhost:8080/board/update  
	}
/////////////////////////////////////////////////////////////////////////////////////////
	@GetMapping("/board/delete")
	public String delete_get(){ return "board/delete";
		//https://localhost:8080/board/delete 글삭제폼
	}
	
	@PostMapping("/board/delete")
	public String delete_post(Board board){
		//##글삭제기능
		return "redirect:/board/list"; //글삭제하고 리스트로이동
		//https://localhost:8080/board/delete  
	}
	*/
}

/*Restful Api
	기존게시판			: localhost:8080/board/detail?bno=10 쿼리스트링
	Restful Api		: localhost:8080/board/detail/bno/10 쿼리스트링
	1) restful		: http url을 기반으로 자원에 접근해서 서비스를 제공하는 애플리케이션
	2) api			:
	3) method - GET:검색 || POST:생성 || PATCH(부분업데이트) PUT(전체업데이트) || DELETE:삭제
	4) DATA			: json, xml
	 
 */