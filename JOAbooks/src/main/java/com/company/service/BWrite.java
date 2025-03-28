package com.company.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.dao.BoardDao;
import com.company.domain.BoardVO;


public class BWrite implements BoardService {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1 언어세팅
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		//2 request 데이터 받아오기 
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		String bname = request.getParameter("bname");
		//System.out.println(btitle+"/"+bcontent+"/"+bname);
		
		
		//3 dao insert 처리
		BoardDao dao = new BoardDao();
		BoardVO vo = new BoardVO();
		
		vo.setBtitle(btitle);
		vo.setBcontent(bcontent);
		vo.setBname(bname);
		
		//4. 결과물
		request.setAttribute("result", String.valueOf(dao.insert(vo)));

	}

}
