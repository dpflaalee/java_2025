package com.company.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.dao.BoardDao;

public class BDelete implements BoardService {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//언어세팅
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		//parameter
		int bno = Integer.parseInt(request.getParameter("bno"));
	
		//sql dao
		BoardDao dao= new BoardDao();
		
		//결과
		request.setAttribute("result", String.valueOf(dao.delete(bno)));
		// test : delete.do?bno=5

	}

}
