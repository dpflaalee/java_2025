package com.company.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.dao.BoardDao;

public class BList implements BoardService {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1 언어세팅
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		//2 request 데이터 받아오기 X
		//3 dao list.do - 
		BoardDao dao = new BoardDao();
		
		
		//4. request.setAttrubute()	}
		request.setAttribute("list", dao.selectAll());

}}
