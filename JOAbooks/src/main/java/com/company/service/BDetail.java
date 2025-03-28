package com.company.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.dao.BoardDao;

public class BDetail implements BoardService {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//언어세팅
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		//request 데이터받기
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		//dao 조회수 올리기 dao.updateHit(bno) /해당글 상세 dao.select(bno)
		BoardDao dao = new BoardDao();
		dao.updateHit(bno);
		
		//결과물 세팅 request.setAttribute()
		request.setAttribute("dto", dao.select(bno));
		//System.out.println(dao.select(bno));
	}

}
