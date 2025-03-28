package com.company.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.dao.BoardDao;
import com.company.domain.BoardVO;

public class BEdit implements BoardService {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//언어세팅
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		//parameter
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		int bno = Integer.parseInt(request.getParameter("bno"));
	
		//sql dao
		BoardVO vo = new BoardVO();
		BoardDao dao= new BoardDao();
		
		vo.setBtitle(btitle);
		vo.setBcontent(bcontent);
		vo.setBno(bno);
		
//		System.out.println(dao.update(vo)); 
//		System.out.println(dao.select(1));		
		
		//결과
		request.setAttribute("result", String.valueOf(dao.update(vo)));
		// test : edit.do?bno=5&btitle=a&bcontent=a
	}

}
