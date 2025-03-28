package com.company.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.dao.BoardDao;

public class BEditeView implements BoardService {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//언어세팅
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		//request 데이터받기
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		//dao list.do
		BoardDao dao = new BoardDao();
		//request.setAttribute
		request.setAttribute("dto", dao.select(bno));
	}

}
